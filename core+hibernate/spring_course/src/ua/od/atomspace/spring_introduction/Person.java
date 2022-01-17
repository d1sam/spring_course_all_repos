package ua.od.atomspace.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("personBean")
@Scope("prototype")
public class Person {

    // Dependency Injection происходит с помощью autowiring поля
//    @Autowired
//    @Qualifier("cat")
    // @Qualifier нужна на тот случай, если в контйнере присутствует 2 и более бина с нужным типом
    // подставится бин с id, указанным в (), то есть "cat"
    private Pet pet;
    @Value("${person.surName}")
    private String surName;
    @Value("25")
    private int age;

//    public Person(){
//        System.out.println("Created person!");
//    }

// Dependency Injection происходит с помощью autowiring конструктора
    @Autowired
//    так как у аннотации @Qualifier target'ом не является конструктор, то ее применять нужно к параметру конструктора
    public Person(@Qualifier("cat") Pet pet) {
        this.pet = pet;
        System.out.println("Created person by Pet!");
    }

    @PostConstruct
    private void init(){
        System.out.println("Class Person : init method");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Class Person : destroy method");
    }

    public void sayHiPet(){
        System.out.println("Hi, my dear pet!");
        pet.say();
    }
// Dependency Injection происходит с помощью autowiring сеттера
//    @Autowired
//    @Qualified("cat")
//    та сама ситуация, что и с полем, подставится в pet бин с id = "cat"
    public void setPet(Pet pet) {
        System.out.println("Class Person : set pet");
        this.pet = pet;
    }

// Когда создастся bean personBean, будет происходить внедрение зависимости на членах класса помеченных @Autowired
// в контейнере Spring (ApplicationContext) Spring будет искать bean'ы с нужным типом
// если таких нет, то будет выброшен Exception, такая же ситуация, если будет 2 бина с нужным типом
// на чем именно использовать @Autowired не имеет значения, хорошим тоном является использование во всем коде одного и того же способа (например @Autowired на сеттере)
    public Pet getPet() {
        return pet;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        System.out.println("Class Person : set surName");
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person : set age");
        this.age = age;
    }
}
