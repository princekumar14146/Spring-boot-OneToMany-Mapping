package com.springbootapi.OneToMany_mapping.Service;

import com.springbootapi.OneToMany_mapping.Entity.Department;
import com.springbootapi.OneToMany_mapping.Entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface DepartmentService {

    public String saveDepartment(Department department);   // as application started firstly we have to store all departments then we hav eto store student in departments
    public String saveStudent(String departmentName, Student student);  // in this we have to store students in particular department in which he want to go
    public List<Department> getAllDepartment();   // in this we fetch all the department along with student in that department
    public Department getDepartmentById(String departmentId); // in this we have to fetch particular department with all students in it by using departmentId
    public Department getByDepartmentName(String departmentName);// if we have department name then we have to find department along with all student in it
    public String updateDepartmentById(String departmentId,Department department);
    public String updateStudentById(String departmentId,Integer studentId,Student student);
    public String deleteById(String departmentId); // here if we want to delete particular department then student also deleted
    public List<Department> getDataByStudentFirstName(String studentFirstName); // if we have student first name then we can fetch all it details
    public Department getDataByStudentEmail(String studentEmail); // if we want to detch the data on the basis of student Email.

}
