package ua.od.atomspace;

import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet{
    public Dog (){
        System.out.println("Created dog!");
    }
    @Override
    public void say() {
        System.out.println("Bow - Wow!");
    }
}
