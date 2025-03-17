package com.springJPA2.JPA2.Ques_1_2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Ques1 - Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
    @Query("Select firstName,lastName from Employee")
    public List<Object[]> getFirstAndLastName();

    //Ques1 - Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
    @Modifying
    @Query("Update Employee e set e.salary=:salary where e.salary<:avg_sal")
    public void updateSalary(@Param("salary") int salary, @Param("avg_sal") int avgSal);

    //Ques1 - Delete all employees with minimum salary.
    @Modifying
    @Query("delete from Employee where salary=:min_salary")
    public void deleteWithMinSalary(@Param("min_salary") int minSalary);

    @Query("Select Avg(salary) from Employee")
    public int averageSalary();

    @Query("Select min(salary) from Employee")
    public int minSalary();

    @Modifying
    @Query(value = "update employee_table set emp_salary=1000000 where emp_first_name='Krishna'",nativeQuery = true)
    public void updateKrishna();


    //Ques2 - Display the id, first name, age of all employees where last name ends with "singh"
    @Query(value = "Select emp_id, emp_first_name, emp_age from employee_table where emp_last_name='Singh'",nativeQuery = true)
    public List<Object[]> findByLastNameWithSingh();

    //Ques2 - Delete all employees with age greater than 45(Should be passed as a parameter
    @Modifying
    @Query(value = "Delete from employee_table where emp_age> :empl_age",nativeQuery = true)
    public void deleteWithAgeGreaterThan45(@Param("empl_age") int empAge);

}
