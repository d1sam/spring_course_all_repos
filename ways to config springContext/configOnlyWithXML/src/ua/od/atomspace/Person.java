package ua.od.atomspace;

public class Person {
    private String name;
    private int age;
    private Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }

    private void init(){
        System.out.println("class Person: init method!");
    }

    private void destroy(){
        System.out.println("class Person: destroy method!");
    }

    public void saiHiPet(){
        System.out.println("Hello pet!");
        pet.say();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
