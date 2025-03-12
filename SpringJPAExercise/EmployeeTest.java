package com.product.SpringJPAExercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeRepository employeeRepository;


//    3 Perform Create Operation on Entity using Spring Data JPA
    @Test
    public void createEmployee(){
        List<Employee> employees = List.of(
                new Employee("Himanshi",21,"New Address"),
                new Employee("Karan",25,"New Address"),
                new Employee("Shilpa",28,"New Address")
        );
        System.out.println(employeeRepository.saveAll(employees));
    }

//    4 Perform Update Operation on Entity using Spring Data JPA
    @Test
    public void updateEmployee(){
        Employee employee = employeeRepository.findById(2L).orElse(null);
        if (employee==null) {
            System.out.println("No employee exist with given ID");
            return;
        }
        employee.setName("Himanshi");
        employee.setAge(21);
        employee.setAddress("New Delhi-110015");
        System.out.println(employeeRepository.save(employee));
    }


//    5 Perform Delete Operation on Entity using Spring Data JPA
    @Test
    public void deleteEmployee(){
        Employee employee = employeeRepository.findById(5L).orElse(null);
        if (employee==null) {
            System.out.println("No employee exist with given ID");
            return;
        }
        employeeRepository.deleteById(5L);
        System.out.println("Employee with given ID deleted");
    }

//    6 Perform Read Operation on Entity using Spring Data JPA
    @Test
    public void readEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee:employees)
            System.out.println(employee);
    }


//    7 Get the total count of the number of Employees
    @Test
    public void countEmployee(){
        System.out.println(employeeRepository.count());
    }


//    9    Create and use finder to find Employee by Name
    @Test
    public void findEmployeeByName(){
        List<Employee> employees = employeeRepository.findByName("Himanshi");
        if(employees==null){
            System.out.println("Employees Not Found");
            return;
        }
        System.out.println(employees);
    }

    //    8 Implement Pagination and Sorting on the bases of Employee Age

    @Test
    public void findEmployeesSortedOnAge(){
        List<Employee> employees = employeeRepository.findAll(Sort.by(new Sort.Order(Sort.Direction.ASC,"age")));
        employees.forEach(System.out::println);
    }

    @Test
    public void findEmployeeByNameAndId(){
        List<Employee> employees = employeeRepository.findByIdOrName(53L,"Himanshi");
        if(employees==null){
            System.out.println("Employees Not Found");
            return;
        }
        System.out.println(employees.toString());
    }

    @Test
    public void findEmployeeByAgeGreaterThan(){
        List<Employee> employees = employeeRepository.findByAgeGreaterThan(20);
        if(employees==null){
            System.out.println("Employees Not Found");
            return;
        }
        employees.forEach(System.out::println);
    }

    @Test
    public void findEmployeesByAddress(){
        List<Employee> employees = employeeRepository.findByAddressContains("delhi");
        if(employees==null){
            System.out.println("Employees Not Found");
            return;
        }
        employees.forEach(System.out::println);
    }

//    11 Create and use finder to find Employees Between the age of 28 to 32
    @Test
    public void findEmployeesByAgeBetween(){
        List<Employee> employees = employeeRepository.findByAgeBetween(21,28);
        if(employees==null){
            System.out.println("Employees Not Found");
            return;
        }
        employees.forEach(System.out::println);
    }


//   10 Create and use finder to find Employees starting with A character
    @Test
    public void findEmployeesByNameLike(){
        List<Employee> employees = employeeRepository.findByNameLike("A%");
        if(employees==null){
            System.out.println("Employees Not Found");
            return;
        }
        employees.forEach(System.out::println);
    }



}
