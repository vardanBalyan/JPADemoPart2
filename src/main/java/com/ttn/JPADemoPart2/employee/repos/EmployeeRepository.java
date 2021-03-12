package com.ttn.JPADemoPart2.employee.repos;

import com.ttn.JPADemoPart2.employee.entities.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    //select all employees
    @Query("from Employee")
    List<Employee> findAllEmployees();

    // select all first name and last name
    @Query("select emp.firstName, emp.lastName from Employee emp")
    List<Object[]> findAllEmployeePartialInfo();

    //select employees by name where providedName is value we're passing in query
    //and using in function using the @Param
    @Query("from Employee where firstName=:providedName")
    List<Employee> findAllEmployeeByFirstName(@Param("providedName") String name);

    //find employee having age between certain range
    @Query("from Employee where age>:min and age<:max")
    List<Employee> findEmployeeByAge(@Param("min") int min, @Param("max") int max);

    //delete employee by name we have to use @Modify to delete an update the records
    @Modifying
    @Query("delete from Employee where firstName=:providedName")
    void deleteEmployeeByName(@Param("providedName") String name);

    //paging
    @Query("from Employee")
    List<Employee> findAllPaging(Pageable pageable);

    @Query("select emp.firstName, emp.lastName from Employee emp where " +
            "emp.salary>(select AVG(emp2.salary) from Employee emp2)")
    List<Object[]> findEmployeeBySalary(Sort sort);

    @Modifying
    @Query("update Employee emp set emp.salary=emp.salary+:incrementedAmount where " +
            "emp.salary<AVG(emp.salary)")
    public void incrementSalaryBy(@Param("incrementedAmount") double amount);
}
