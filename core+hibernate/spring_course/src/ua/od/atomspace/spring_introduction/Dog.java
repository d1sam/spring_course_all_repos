package ua.od.atomspace.spring_introduction;

import org.springframework.stereotype.Component;


// в данном случае указывается id бина - "dogBean", что является хорошим тоном
// если его не указать, то bean создастся с id = название класса с маленькой буквы,
// но если название класса начинается с 2-ух больших букв, то создастся bean с id = названию класса
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
