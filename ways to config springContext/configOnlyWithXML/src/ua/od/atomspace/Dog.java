package ua.od.atomspace;

public class Dog implements Pet{
    public Dog (){
        System.out.println("Created dog!");
    }
    @Override
    public void say() {
        System.out.println("Bow - Wow!");
    }
}
