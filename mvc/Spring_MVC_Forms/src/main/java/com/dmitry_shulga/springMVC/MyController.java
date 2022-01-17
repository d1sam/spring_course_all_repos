package com.dmitry_shulga.springMVC;

import com.dmitry_shulga.springMVC.objects.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {
    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        Employee emp = new Employee();
//        emp.setName("Dima");
//        emp.setSurname("Shulga");
//        emp.setSalary(10000);
        model.addAttribute("employee", emp);
        return "ask-emp-details-view";
    }
    // будет срабатывать на request с методом post, по url /employee/showDetails
    @PostMapping("/showDetails")
    //с помощью аннотации @Valid помечаем то, что аттрибут с модели employee нужно провалидировать
    //с помощью аннотации @ModelAttribute вытягиваем из модели аттрибут employee
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        // с помощью BindingResult можно проверить результат валидации
//        employee.setName("Mr" + employee.getName());
//        employee.setSurname(employee.getSurname() + "!");
//        employee.setSalary(employee.getSalary() * 10);
        // если в резалте есть ошибки, то возвращаем view, с которого пришел запрос
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            //ошибок нет, открываем нужный view
            return "show-emp-details-view";
        }
    }
}
