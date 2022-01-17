package ua.od.atomspace;

import org.springframework.stereotype.Component;

@Component("catBean")
public class Cat implements Pet {
    public Cat(){
        System.out.println("Created cat!");
    }
    @Override
    public void say() {
        System.out.println("Meow - Meow!");
    }
}
