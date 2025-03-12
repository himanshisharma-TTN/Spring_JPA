package com.product.SpringJPAExercise;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//2 Set up EmployeeRepository with Spring Data JPA

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public List<Employee> findByName(String name);

    public List<Employee> findByIdOrName(Long id,String name);

    public List<Employee> findByAgeGreaterThan(int age);

    public List<Employee> findByAddressContains(String city);

    public List<Employee> findByAgeBetween(int start,int end);

    public List<Employee> findByNameLike(String expression);

}
