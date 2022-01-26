package com.fsk.micronaut.crud.controller;

import com.fsk.micronaut.crud.entity.Employee;
import com.fsk.micronaut.crud.repository.EmployeeRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Controller("/api/v1/employees")
@Slf4j
public class EmployeeController {

    @Inject
    EmployeeRepository repository;

    @Get
    public List<Employee> getEmployees() {
        List<Employee> emps = repository.findAll();
        log.info(emps.toString());
        return emps;
    }

    @Get("/{id}")
    public Employee getEmployee(long id) {
        return repository.findById(id).get();
    }

    @Post
    public HttpResponse<Employee> createEmployee(@Body Employee e) {
        return HttpResponse.created(repository.save(e));
    }

    @Put
    public Employee updateEmployee(@Body Employee e){
        return repository.update(e);
    }

    @Delete("/{id}")
    public HttpResponse deleteEmployee(long id){
        repository.deleteById(id);
        return HttpResponse.ok();
    }
}
