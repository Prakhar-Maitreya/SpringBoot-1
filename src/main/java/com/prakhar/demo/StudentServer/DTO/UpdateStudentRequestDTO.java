package com.prakhar.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateStudentRequestDTO {
    private int id;
    private String name;
    private int age;
    private String department;
}
