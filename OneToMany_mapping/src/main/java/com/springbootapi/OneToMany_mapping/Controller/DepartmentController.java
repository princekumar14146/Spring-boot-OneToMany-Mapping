package com.springbootapi.OneToMany_mapping.Controller;

import com.springbootapi.OneToMany_mapping.Entity.Department;
import com.springbootapi.OneToMany_mapping.Entity.Student;
import com.springbootapi.OneToMany_mapping.Service.DepartmentServiceImpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping("/saveDepartment")
    public ResponseEntity<String> saveDepartment(@RequestBody Department department)
    {
      String str=departmentService.saveDepartment(department);
      return ResponseEntity.status(HttpStatus.OK).body(str);
    }

    @PostMapping("/saveStudent/{departmentName}")
    public ResponseEntity<String> saveStudent(@PathVariable("departmentName") String departmentName, @RequestBody Student student)
    {
       String str= departmentService.saveStudent(departmentName,student);
       return ResponseEntity.status(HttpStatus.OK).body(str);
    }

    @GetMapping("/allDepartment")
    public ResponseEntity<List<Department>> getAllDepartment(){

       List<Department> departments= departmentService.getAllDepartment();
       return ResponseEntity.status(HttpStatus.OK).body(departments);

    }
    @GetMapping("/getById")
    public ResponseEntity<Department> getDepartmentById(@RequestParam("departmentId") String departmentId)
    {
        Department department= departmentService.getDepartmentById(departmentId);
        return ResponseEntity.status(HttpStatus.OK).body(department);
    }
    @GetMapping("/getByDepartmentName")
    public ResponseEntity<Department> getByDepartmentName(@RequestHeader("departmentName") String departmentName)
    {
       Department department= departmentService.getByDepartmentName(departmentName);
       return ResponseEntity.status(HttpStatus.OK).body(department);
    }

    @PutMapping("/updateDepartment/{departmentId}")
    public ResponseEntity<String> updateDepartmentById(@PathVariable("departmentId") String departmentId,@RequestBody Department department)
    {
        String str=departmentService.updateDepartmentById(departmentId, department);
        return ResponseEntity.status(HttpStatus.OK).body(str);

    }

    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudentById(@RequestParam("departmentId") String departmentId, @RequestParam("studentId") Integer studentId,@RequestBody Student student)
    {
       String str=departmentService.updateStudentById(departmentId,studentId, student);
       return ResponseEntity.status(HttpStatus.OK).body(str);
    }

    @DeleteMapping("/delete/{departmentId}")
    public ResponseEntity<String> deleteById(@PathVariable("departmentId") String departmentId)
    {
        String str=departmentService.deleteById(departmentId);
        return ResponseEntity.status(HttpStatus.OK).body(str);
    }

    @GetMapping("/getByStudentName/{studentFirstName}")
    public ResponseEntity<List<Department>> getDataByStudentFirstName(@PathVariable("studentFirstName") String studentFirstName)
    {
       List<Department> list=departmentService.getDataByStudentFirstName(studentFirstName);
       return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @GetMapping("/getDataStudentEmail/{studentEmail}")
    public ResponseEntity<Department> getDataByStudentEmail(@PathVariable("studentEmail") String studentEmail)
    {
          Department department=departmentService.getDataByStudentEmail(studentEmail);
          return ResponseEntity.status(HttpStatus.OK).body(department);
    }




}
