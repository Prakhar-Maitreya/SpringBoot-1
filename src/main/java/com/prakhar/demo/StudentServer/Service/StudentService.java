package com.prakhar.demo.StudentServer.Service;

import com.prakhar.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.prakhar.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.prakhar.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.prakhar.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.prakhar.demo.StudentServer.Entity.Student;
import com.prakhar.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = mapToStudent(createStudentRequestDTO);
        Student savedStudent = studentRepository.save(student);
        return mapToResponseDTO(savedStudent);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student studentUpdate(int id, Student student) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        result.setName(student.getName());
        result.setAge(student.getAge());
        result.setDepartment(student.getDepartment());
        result.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(result);
    }

    public UpdateStudentResponseDTO studentUpdateWithDTO(UpdateStudentRequestDTO dto) {

        Student result = studentRepository.findById(dto.getId()).orElse(null);

        if (result == null) {
            return null;
        }

        result.setName(dto.getName());
        result.setAge(dto.getAge());
        result.setDepartment(dto.getDepartment());
        result.setUpdatedAt(LocalDateTime.now());

        Student saved = studentRepository.save(result);

        UpdateStudentResponseDTO response = new UpdateStudentResponseDTO();
        response.setMessage("Student record updated successfully!");
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setAge(saved.getAge());
        response.setDepartment(saved.getDepartment());

        return response;
    }

    public Student deleteStudent(int id) {
        Student result = studentRepository.findById(id).orElse(null);
        if(result == null) {
            return null;
        }
        studentRepository.delete(result);
        return result;
    }

    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());

        return createStudentResponseDTO;

    }
}