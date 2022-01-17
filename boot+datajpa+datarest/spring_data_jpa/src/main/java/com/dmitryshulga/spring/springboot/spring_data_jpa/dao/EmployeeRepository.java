package com.dmitryshulga.spring.springboot.spring_data_jpa.dao;


import com.dmitryshulga.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// extendимся от интерфейса JpaRepository, который предоставляет spring boot и spring data jpa
// служит для того, чтобы работать с энтити бд с помощью готовых реализаций методов sql апросов к БД
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // первый дженерик - тип энтити,
    // второй дженерик - тип, которым является первичный ключ у энтити
    List<Employee> findAllByName(String name);// можно добавить свой метод с помощью названия и принимаемого элемента
    // это является возможностью, которая предоставляется Spring Data JPA - декларативные запросы
}
