package com.springbootapi.OneToMany_mapping.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student implements Serializable {

    private static final Long serialVersionUID=1234567890L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_first_name")
    @NotNull(message = "StudentFirstName should not be null")
    @Pattern(regexp = "^[a-zA-Z]+$",message = "Only alphabets allowed")
    private String studentFirstName;

    @NotNull(message = "studentLastName should not be null")
    @Pattern(regexp = "^[a-zA-Z]+$" , message = "studentLastName only contains alphabets")
    @Column(name = "student_last_name")
    private String studentLastName;

    @NotNull(message = "studentPhoneNumber should not be null")
    @Size(min=10,max = 10, message = "studentPhoneNumber must be of 10 digits")
    @Column(name = "student_phone_no")
    private String studentPhoneNo;

    @NotNull(message = "StudentEmail should not be null")
    @Email(regexp = "[A-Za-z0-9._%+-]+@gmail\\.com",message = "Student Email must ends with @gmail.com")
    @Column(name = "student_email")
    private String studentEmail;

    @NotNull(message = "studentAddress should not be null")
    @Pattern(regexp = "^[a-zA-Z]+$",message = "Only alphabets allowed")
    @Column(name = "student_address")
    private String studentAddress;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

}
