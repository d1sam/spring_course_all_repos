package com.dmitryshulga.spring.rest.controller;

import com.dmitryshulga.spring.rest.entity.Employee;
import com.dmitryshulga.spring.rest.exception_handling.NoSuchEmployeeException;
import com.dmitryshulga.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// аллиас для контроллера, в котором будут описаны методы, что будут вызываться на рест реквесты
@RequestMapping("/api")
public class MyRESTController {
    @Autowired// сервис, которым будет пользоваться контроллер для взаимодействия с БД
    private EmployeeService employeeService;

    @GetMapping("/employees")// метод, который будет срабатывать по урл (только get запросы)
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")// метод, который будет срабатывать по урл (только get запросы), после / указывается айди, по которому идет запрос
    public Employee getEmployee(@PathVariable int id) {// с помощью аннотации получаем нужный айди
        Employee employee = employeeService.getEmployee(id);// делаем запрос в бд по этому айди
        if (employee == null) {// если с бд ничего не вернулось, то эмплои нет и нужно выбросить исключение с определенным месседжем
            throw new NoSuchEmployeeException("There is no Employee with ID = " + id + " in DataBase!");
        }// если эксепшен не был выброшен, то возвращаем объект эмплои
        return employee;
    }

    @PostMapping("/employees")// метод, который будет срабатывать по урл (только post запросы)
    public Employee addNewEmployee(@RequestBody Employee employee) {// получаем из тела запроса работника с помощью аннотации @RequestBody
        employeeService.saveEmployee(employee);// сохраняем в БД полученного работника
        return employee;// возвращаем сохраненного работника уже с айди, который засеттился ему
    }

    @PutMapping("/employees")// метод, который будет срабатывать по урл (только put запросы)
    public Employee updateEmployee(@RequestBody Employee employee) {// получаем из тела запроса работника с помощью аннотации @RequestBody
        employeeService.saveEmployee(employee);// апдейтим в БД полученного работника (в дао вызывается метод saveOrUpdate),
        // поэтому, если у полученного работника есть айди, то просто обновляем в бд его значения
        return employee;// возвращаем уже обновленного сотрудника
    }

    @DeleteMapping("/employees/{id}")// метод, который будет срабатывать по урл (только delete запросы), после / указывается айди, по которому идет запрос
    public String deleteEmployee(@PathVariable int id) {// с помощью аннотации получаем нужный айди
        Employee employee = employeeService.getEmployee(id);//// делаем запрос в бд по этому айди
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no Employee with ID=" + id + " in DataBase!");// если с бд ничего не вернулось,
            // то эмплои нет и нужно выбросить исключение с определенным месседжем
        }// если эксепшен не был выброшен, то удаляем из БД объект эмплои
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted!";// возвращаем мэсседж, что объект был удален
    }
}
