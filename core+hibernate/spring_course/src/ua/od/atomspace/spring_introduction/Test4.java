package ua.od.atomspace.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        // если у бина scope = singleton, то метод init вызовется после создания Spring контейнера

        // в данном случае у бина scope = prototype, поэтому метод init вызывается на момент
        // запроса бина из контейнера, на каждом запросе создается новый бин
        Person person = context.getBean("myPerson",Person.class);

        person.sayHiPet();

        context.close();// если scope = prototype, то метод destroy не будет вызываться
        // он вызывается только, когда scope = singleton

    }
}
