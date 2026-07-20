package com.prakhar.demo.Scope;

import com.prakhar.demo.StudentServer.Entity.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LPU
{
    LPU()
    {
        System.out.println("LPU Rank 1");
    }
    public void admission(Student student)
    {
        System.out.println("Admission");
    }
    public void exam()
    {
        System.out.println("exam");
    }
    public void prepClasses(Student student)
    {
        System.out.println("Prep Classes");
    }
}


