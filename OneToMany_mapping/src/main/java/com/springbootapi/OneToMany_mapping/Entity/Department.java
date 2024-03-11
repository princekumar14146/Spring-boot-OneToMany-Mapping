package com.springbootapi.OneToMany_mapping.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department implements Serializable {

    private static final Long serialVersionUID= 1234567890L;

    @Id
    @GeneratedValue(generator = "Dept")
    @GenericGenerator(name = "Dept", strategy = "com.springbootapi.OneToMany_mapping.CustomIdGeneratorConfig.CustomDepartmentIdGenerator")
    @Column(name = "department_id")
    private String departmentId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabets allowed")
    @Column(name = "department_name")
    private String departmentName;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$",  message = "Only alphabets allowed")
    @Column(name = "department_hod")
    private String departmentHOD;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student> students;



}
