package com.prakhar.demo.StudentServer.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prakhar.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.prakhar.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.prakhar.demo.StudentServer.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    // ─── POST /create ────────────────────────────────────────────────────────────

    @Test
    void postCreate_withValidJson_returns201() throws Exception {
        CreateStudentRequestDTO request = new CreateStudentRequestDTO();
        request.setName("prakhar");
        request.setAge(22);
        request.setDepartment("CSE");

        CreateStudentResponseDTO mockResponse = new CreateStudentResponseDTO();
        mockResponse.setId(1);
        mockResponse.setName("prakhar");
        mockResponse.setAge(22);
        mockResponse.setDepartment("CSE");

        when(studentService.studentValidate(any(CreateStudentRequestDTO.class)))
                .thenReturn(mockResponse);

        mockMvc.perform(post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isCreated())          // 201
                .andExpect(jsonPath("$.name").value("prakhar"))
                .andExpect(jsonPath("$.age").value(22))
                .andExpect(jsonPath("$.department").value("CSE"));
    }

    @Test
    void postCreate_withGetMethod_returns405() throws Exception {
        // Intentionally send GET to POST-only endpoint — should get 405
        mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void postCreate_withNoContentType_returns415() throws Exception {
        // Send POST with plain-text body (no Content-Type: application/json)
        mockMvc.perform(post("/create")
                        .content("{\"name\":\"prakhar\",\"age\":22,\"department\":\"CSE\"}"))
                .andDo(print())
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    void postCreate_withEmptyBody_returns400() throws Exception {
        // POST with empty body — Jackson will fail to deserialise
        mockMvc.perform(post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void postCreate_serviceReturnsNull_returns400() throws Exception {
        // Service returns null → controller should return 400
        CreateStudentRequestDTO request = new CreateStudentRequestDTO();
        request.setName("prakhar");
        request.setAge(22);
        request.setDepartment("CSE");

        when(studentService.studentValidate(any(CreateStudentRequestDTO.class)))
                .thenReturn(null);

        mockMvc.perform(post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isBadRequest())       // 400
                .andExpect(content().string("Invalid input"));
    }
}
