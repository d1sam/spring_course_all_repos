package com.dmitryshulga.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller// контроллер - это специальный компонент
@RequestMapping("/employee")
public class MyController {
    // метод с помощью, которого будет происходить вызов view
    @RequestMapping("/")// используется для связывания url с методом, который должен вызываться
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails(){
//        return "show-emp-details-view";
//    }

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails(HttpServletRequest request// request содержит информацию о поступившем запросе /showDetails
//    , Model model) {
//        String empName = request.getParameter("employeeName");// получаем значение из ask-emp-details-view.jsp
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute", empName);// помещаем в модель (контейнер данных) новый аттрибут, которым будем пользоваться в show-emp-details-view
//        model.addAttribute("description", "software developer");// можем поместить в модель что угодно
//        return "show-emp-details-view";
//    }

    @RequestMapping("/showDetails") // метод равносильный предыдущему, но тут уже пользуемся аннотацией
    public String showEmployeeDetails(@RequestParam("employeeName") String empName, Model model) {
        empName = "Mr. " + empName + "!";
        model.addAttribute("nameAttribute", empName);
        model.addAttribute("description", "software developer");
        return "show-emp-details-view";
    }
}
