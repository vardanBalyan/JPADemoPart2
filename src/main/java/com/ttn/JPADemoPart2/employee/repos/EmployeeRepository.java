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


    //JPQL 1.
    @Query("select emp.firstName, emp.lastName from Employee emp where " +
            "emp.salary>(select AVG(emp2.salary) from Employee emp2)")
    List<Object[]> findEmployeeBySalary(Sort sort);


    //JPQL 2.

    @Query("select emp.id from Employee emp where salary < (select AVG(e.salary) from Employee e)")
    public List<Integer> getEmployeeIdWithSalaryLessThanAverage();
    @Modifying
    @Query("update Employee emp set emp.salary =:incrementedAmount where emp.id=:givenId")
    public void incrementSalaryBy(@Param("incrementedAmount") double amount, @Param("givenId") int id);

    //JPQl 3.

    @Query("select MIN(salary) from Employee")
    public Double minSalary();

    @Modifying
    @Query("delete from Employee emp where emp.salary=:minSalary")
    public void deleteMinSalaryEmployees(@Param("minSalary") Double minSalary);

    //Native 1.

    @Query(value = "select empId, empFirstName, empAge from employeettn where " +
            "empLastName Like 'Singh'", nativeQuery = true)
    public List<Object[]> findEmployeeWithLastNameSinghNQ();

    // Native 2.
    @Modifying
    @Query(value = "delete from employeettn where empAge>:enteredAge",nativeQuery = true)
    public void deleteEmployeeByAge(@Param("enteredAge") int age);
}

