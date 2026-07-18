package com.prakhar.demo.StudentServer.Controller;

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

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(@RequestBody Student student) {
        Student result = studentService.studentValidate(student);

        if(result == null)
        {
           return ResponseEntity.status(400).body("Invalid input");
        }
        return  ResponseEntity.status(201).body(result);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }
}

/**

 */










