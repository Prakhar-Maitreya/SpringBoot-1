package com.prakhar.demo.StudentServer.Controller;

import com.prakhar.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.prakhar.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.prakhar.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.prakhar.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.prakhar.demo.StudentServer.Entity.Student;
import com.prakhar.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public void index(jakarta.servlet.http.HttpServletResponse response) throws java.io.IOException {
        response.sendRedirect("/frontend.html");
    }

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(@RequestBody CreateStudentRequestDTO createStudentRequestDTO) {
        CreateStudentResponseDTO result = studentService.studentValidate(createStudentRequestDTO);

        if(result == null)
        {
           return ResponseEntity.status(400).body("Invalid input");
        }
        return  ResponseEntity.status(201).body(result);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){

        Student student = studentService.getStudentById(id);

        if(student == null){
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student){
        Student result = studentService.studentUpdate(id, student);
        if(result == null)
        {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return ResponseEntity.status(200).body(result);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<?> updateStudentWithDTO(@RequestBody UpdateStudentRequestDTO dto) {
        UpdateStudentResponseDTO result = studentService.studentUpdateWithDTO(dto);
        if (result == null) {
            return ResponseEntity.status(404).body("Student not found with id: " + dto.getId());
        }
        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        Student student = studentService.deleteStudent(id);
        if(student == null) {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return ResponseEntity.status(200).body("Student deleted");
    }
}









