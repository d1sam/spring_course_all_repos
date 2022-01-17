package ua.od.atomspace;


public class Cat implements Pet {
    public Cat(){
        System.out.println("Created cat!");
    }
    @Override
    public void say() {
        System.out.println("Meow - Meow!");
    }
}
