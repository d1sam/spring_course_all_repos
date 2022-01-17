package com.dmitryshulga.spring.mvc_hibernate_aop.service;

import com.dmitryshulga.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;
// интерфейс методы которого будут работать с БД и использоваться в контроллере
public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
