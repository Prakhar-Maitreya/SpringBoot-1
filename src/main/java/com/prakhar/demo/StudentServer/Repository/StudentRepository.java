package com.prakhar.demo.StudentServer.Repository;

import com.prakhar.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
