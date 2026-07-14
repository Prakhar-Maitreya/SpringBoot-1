package com.prakhar.demo.StudentServer;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository
{
    public Student save(Student student)
    {
        System.out.println("Student Information Stored");
        return student;
    }
}
