package com.springbootapi.OneToMany_mapping.Repository;

import com.springbootapi.OneToMany_mapping.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

  public Optional<Department> findByDepartmentName(String departmentName);

  @Query(value = "SELECT d FROM Department d JOIN FETCH d.students s WHERE s.studentFirstName = :studentFirstName")
  public List<Department> findByStudentFirstName(@Param("studentFirstName") String studentFirstName);
  @Query(value = "SELECT d FROM Department d JOIN FETCH d.students s WHERE s.studentEmail = :studentEmail")
  public Optional<Department> findByStudentEmail(@Param("studentEmail") String studentEmail);


}
