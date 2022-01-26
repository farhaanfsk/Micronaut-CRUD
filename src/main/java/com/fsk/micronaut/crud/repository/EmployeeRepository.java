package com.fsk.micronaut.crud.repository;

import com.fsk.micronaut.crud.entity.Employee;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
