package com.dmitryshulga.spring.springboot.spring_data_jpa.service;

import com.dmitryshulga.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.dmitryshulga.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
// Использование данной аннотации позволит искать бины-сервисы автоматически.
// этот сервис будет работать с дао эмплои использую его методы
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;// создаем объект типа EmployeeRepository, чтобы проводить операции с БД

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);// findById() возвращает Optional и поэтому нужно работать с ним как с Optional
        if (optional.isPresent()) {// если в опшионал поместили не налл
            employee = optional.get();// то получаем объект из опшионал
        }// в ином случае можно выбросить исключение и обернуть его в ResponseEntity и вернуть в точку вызова метода
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}
