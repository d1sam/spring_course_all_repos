package com.dmitryshulga.spring.rest.dao;

import com.dmitryshulga.spring.rest.entity.Employee;

import java.util.List;
// интерфейс методы которого будут работать с БД и использоваться в сервисе
public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
