package ua.od.atomspace;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean("personBean",Person.class);

        person.saiHiPet();

        System.out.println("Person's name = "+person.getName());
        System.out.println("Person's age = "+person.getAge()+" years!");
        context.close();
    }
}
