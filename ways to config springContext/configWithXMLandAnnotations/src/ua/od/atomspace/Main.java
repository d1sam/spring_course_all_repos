package ua.od.atomspace;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("personBean",Person.class);

        person.saiHiPet();
        System.out.println("Person name = "+person.getName());
        System.out.println("Person age = "+ person.getAge()+" years!");
        context.close();

    }
}
