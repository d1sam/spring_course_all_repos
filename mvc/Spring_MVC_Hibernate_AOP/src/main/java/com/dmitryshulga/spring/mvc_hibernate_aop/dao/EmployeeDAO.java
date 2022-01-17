package com.dmitryshulga.spring.mvc_hibernate_aop.dao;

import com.dmitryshulga.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;
// интерфейс методы которого будут работать с БД и использоваться в сервисе
public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
