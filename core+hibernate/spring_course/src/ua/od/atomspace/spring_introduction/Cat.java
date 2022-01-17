package ua.od.atomspace.spring_introduction;

import org.springframework.stereotype.Component;

@Component //создастся бин с дэфолтным названием cat
public class Cat implements Pet {
    public Cat(){
        System.out.println("Created cat!");
    }
    @Override
    public void say() {
        System.out.println("Meow - Meow!");
    }
}
