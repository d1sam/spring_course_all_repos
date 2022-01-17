package com.dmitryshulga.spring.springboot.spring_data_jpa.service;


import com.dmitryshulga.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

// интерфейс методы которого будут работать с БД и использоваться в контроллере
public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> findAllByName(String name);
}
