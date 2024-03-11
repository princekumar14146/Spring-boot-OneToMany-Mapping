package com.springbootapi.OneToMany_mapping.Repository;

import com.springbootapi.OneToMany_mapping.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public Optional<Student> findByStudentEmail(String studentEmail);

}
