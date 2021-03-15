package com.ttn.JPADemoPart2.employee.repos;

import com.ttn.JPADemoPart2.employee.entities.EmployeeComponentMapping;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<EmployeeComponentMapping, Integer> {
}
