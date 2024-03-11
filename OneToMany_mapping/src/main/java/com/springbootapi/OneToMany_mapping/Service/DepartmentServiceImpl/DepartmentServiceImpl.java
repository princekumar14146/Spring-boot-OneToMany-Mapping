package com.springbootapi.OneToMany_mapping.Service.DepartmentServiceImpl;

import com.springbootapi.OneToMany_mapping.Entity.Department;
import com.springbootapi.OneToMany_mapping.Entity.Student;
import com.springbootapi.OneToMany_mapping.Exception.DataAlreadyPresentException;
import com.springbootapi.OneToMany_mapping.Exception.DataNotPresentException;
import com.springbootapi.OneToMany_mapping.Repository.DepartmentRepository;
import com.springbootapi.OneToMany_mapping.Repository.StudentRepository;
import com.springbootapi.OneToMany_mapping.Service.DepartmentService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @SneakyThrows
    @Override
    public String saveDepartment(@Valid Department department) {
       Optional<Department> department1=departmentRepository.findByDepartmentName(department.getDepartmentName());
       if(department1.isEmpty())
       {
           departmentRepository.save(department);
           return "Department saved Successfully";
       }
       else {
           throw new DataAlreadyPresentException("Department Already Registered");
       }

    }
    @SneakyThrows
    @Override
    public String saveStudent(String departmentName, Student student) {
      Optional<Department> department=departmentRepository.findByDepartmentName(departmentName);
      if(department.isEmpty())
      {
          throw new DataNotPresentException("Particular Department is not available firstly register the Department");
      }
      else
      {
          Optional<Student> student1=studentRepository.findByStudentEmail(student.getStudentEmail());
          if(student1.isPresent())
          {
              throw new DataAlreadyPresentException("studentEmail="+student.getStudentEmail()+" is already registered");
          }
          else {
              student.setDepartment(department.get());
              studentRepository.save(student);
              return "Student Details saved Successfully";
          }

      }
    }

    @SneakyThrows
    @Override
    public List<Department> getAllDepartment() {
        List<Department> list=departmentRepository.findAll();
        if(list.isEmpty())
        {
            throw new DataNotPresentException("Database is empty");
        }
        else
        {
            return list;
        }

    }

    @SneakyThrows
    @Override
    public Department getDepartmentById(String departmentId) {
       Optional<Department> department=departmentRepository.findById(departmentId);

       if(department.isEmpty())
       {
           throw new DataNotPresentException("THe data related to departmentId="+departmentId+" is not available");
       }
       else {
           return department.get();
      }
    }

    @SneakyThrows
    @Override
    public Department getByDepartmentName(String departmentName) {
        Optional<Department> department =departmentRepository.findByDepartmentName(departmentName);
        if(department.isEmpty())
        {
            throw new DataNotPresentException("The department related to departmentName="+departmentName+" is not available");
        }
        else {
            return department.get();
        }
    }

    @SneakyThrows
    @Override
    public String updateDepartmentById(String departmentId, Department department) {
          Optional<Department>  department1=departmentRepository.findById(departmentId);
          if(department1.isEmpty())
          {
              throw new DataNotPresentException("The department related to departmentId="+departmentId+" is not available");
          }
          else
          {
              department.setDepartmentId(department1.get().getDepartmentId());
              departmentRepository.save(department);
              return "Department gets updated successfully";
          }


    }

    @SneakyThrows
    @Override
    public String updateStudentById(String departmentId, Integer studentId,Student student) {
       Optional<Department> department=  departmentRepository.findById(departmentId);
       if(department.isEmpty())
       {
           throw new DataNotPresentException("The data related to departmentId="+departmentId+" is not available");
       }
       else {
               Optional<Student> student1=studentRepository.findById(studentId);
               if(student1.isEmpty())
               {
                   throw new DataNotPresentException("The data related to studentId="+studentId+" is not available");
               }
               else
               {
                   Student student2=student1.get();
                   student2.setStudentId(studentId);
                   student2.setStudentFirstName(student.getStudentFirstName());
                   student2.setStudentLastName(student.getStudentLastName());
                   student2.setStudentEmail(student.getStudentEmail());
                   student2.setStudentPhoneNo(student.getStudentPhoneNo());
                   student2.setStudentAddress(student.getStudentAddress());
                   studentRepository.save(student2);
                   return "Data Updated successfully";
               }

       }
    }

    @SneakyThrows
    @Override
    public String deleteById(String departmentId) {

         Optional<Department> department=departmentRepository.findById(departmentId);
         if(department.isEmpty())
         {
             throw new DataNotPresentException("Data related to departmentId="+departmentId+" is not available");
         }
         else {
             departmentRepository.deleteById(departmentId);
             return "Data Deleted Successfully";
         }
    }

    @SneakyThrows
    @Override
    public List<Department> getDataByStudentFirstName(String studentFirstName) {
        List<Department> department=  departmentRepository.findByStudentFirstName(studentFirstName);
        if(department.isEmpty())
        {
            throw new DataNotPresentException("There is no data related to "+studentFirstName+" in database");
        }
        else
        {
           return department;
        }

    }

    @SneakyThrows
    @Override
    public Department getDataByStudentEmail(String studentEmail) {
        Optional<Department> department= departmentRepository.findByStudentEmail(studentEmail);

        if(department.isEmpty())
        {
            throw new DataNotPresentException("Data related to email="+studentEmail+" is not available");
        }
        else
        {
            return department.get();
        }
    }
}
