package org.example;

import org.example.configuration.MyConfig;
import org.example.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);// получаем контекст
        Communication communication = context.getBean("communication",Communication.class);// запрашиваем из контекста бин для связи с рест апи

//        List<Employee> listEmployee = communication.getAllEmployees();
//        System.out.println(listEmployee);
//        Employee employee = communication.getEmployee(3);
//        System.out.println(employee);
//
//        Employee employee = new Employee(700,"Sveta","Sokolova","HR");
//        communication.saveEmployee(employee);
//        Employee employee = new Employee(1200,"Sveta","Sokolova","HR");
//        employee.setId(10);
//        communication.saveEmployee(employee);
//        communication.deleteEmployee(10);

    }
}
