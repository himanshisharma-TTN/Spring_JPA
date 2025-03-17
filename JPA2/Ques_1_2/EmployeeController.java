package com.springJPA2.JPA2.Ques_1_2;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String testMapping() {
        return "Employee Database Created";
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostMapping("/all")
    public List<Object[]> getEmployeeFirstAndLastName() {
        return employeeRepository.getFirstAndLastName();
    }

    @PutMapping("/update-salary/{salary}")
    @Transactional
    public List<Employee> updateSalaryOfBelowAverage(@PathVariable int salary) {
        employeeRepository.updateSalary(salary, employeeRepository.averageSalary());
        return employeeRepository.findAll();
    }

    @DeleteMapping("/delete")
    @Transactional
    public List<Employee> deleteWithMinSalary() {
        employeeRepository.deleteWithMinSalary(employeeRepository.minSalary());
        return employeeRepository.findAll();
    }

    @PostMapping("/lastname-singh")
    public List<Object[]> getByLastNameWithSingh() {
        return employeeRepository.findByLastNameWithSingh();
    }

    @DeleteMapping("/delete-greaterthan")
    @Transactional
    public List<Employee> deleteEmployeesGreaterThan45(@RequestParam int age) {
        employeeRepository.deleteWithAgeGreaterThan45(age);
        return employeeRepository.findAll();
    }

}
