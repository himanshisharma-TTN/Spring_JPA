package com.springJPA2.JPA2.Ques_1_2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employeeTable")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private Long id;

    @Column(name = "empFirstName",nullable = false)
    private String firstName;

    @Column(name = "empLastName",nullable = false)
    private String lastName;

    @Column(name = "empSalary",nullable = false)
    private int salary;

    @Column(name = "empAge",nullable = false)
    private int age;
}
