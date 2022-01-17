package com.dmitryshulga.spring.mvc_hibernate_aop.controller;

import com.dmitryshulga.spring.mvc_hibernate_aop.service.EmployeeService;
import com.dmitryshulga.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired// сервис, которым будет пользоваться контроллер для взаимодействия с БД
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        //создаем лист эмплоис, который инициализируем объектами из БД
        List<Employee> allEmployees = employeeService.getAllEmployees();
        // помещяем в модель этот лист в качестве аттрибута и даем ему название allEmps
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();// создаем нового эмплои и помещяем его в модель
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute(name = "employee") Employee employee) {//вытягиваем из модели и изменяем либо добавляем его в БД
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {// вытягиваем из реквеста empId
        Employee employee = employeeService.getEmployee(id);// получаем работника по этому айди
        model.addAttribute("employee",employee);// добавляем его в модель
        return "employee-info";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){// вытягиваем из реквеста empId
        employeeService.deleteEmployee(id);// удаляем работника по этому айди
        return "redirect:/";
    }
}
