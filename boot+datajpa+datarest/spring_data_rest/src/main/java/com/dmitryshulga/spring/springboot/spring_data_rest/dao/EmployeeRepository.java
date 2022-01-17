package com.dmitryshulga.spring.springboot.spring_data_rest.dao;

import com.dmitryshulga.spring.springboot.spring_data_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {// это spring data rest
    // нам достаточно лишь унаследоваться от JpaRepository, указать энтити и тип первичного ключа, чтобы спринг создал рест api
    // url будет сгенерированны по best practise : к названию энтити будет добавлено 's' и первая буква станет маленькой
    // пример:
    // GET employees
    // GET employees/{employeeId}
    // POST employees
    // PUT employees
    // DELETE employees/{employeeId}
    List<Employee> findAllByName(String name);
}
