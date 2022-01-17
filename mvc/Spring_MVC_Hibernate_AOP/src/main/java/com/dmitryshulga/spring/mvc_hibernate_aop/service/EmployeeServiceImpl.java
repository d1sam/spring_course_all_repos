package com.dmitryshulga.spring.mvc_hibernate_aop.service;

import com.dmitryshulga.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.dmitryshulga.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
// аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
// Использование данной аннотации позволит искать бины-сервисы автоматически.
// этот сервис будет работать с дао эмплои использую его методы
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;// нужен объект дао, чтобы проводить операции с БД
    @Override
    @Transactional// указывает, что в данном методе будет производиться транзакция и транзакшн менеджер сам откроет транзакцию и закоммитит ее
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
