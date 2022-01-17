package ua.od.atomspace.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Pet pet = context.getBean("myPet", Pet.class);
//        Person person1 = new Person(pet);
//        person1.sayHiPet();

//        Person person2 = context.getBean("myPerson", Person.class);
//        person2.sayHiPet();

        Person person3 = context.getBean("myPerson2", Person.class);
        person3.sayHiPet();
        System.out.println(person3.getAge());
        System.out.println(person3.getSurName());

        context.close();
    }
}
