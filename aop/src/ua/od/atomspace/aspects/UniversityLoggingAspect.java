package ua.od.atomspace.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ua.od.atomspace.Student;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: логгируем получения списка студентов перед методом getStudents()");
    }

//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
//    // можно также использовать джоинпоинт, но в данном случае этого не надо было
//    public void afterReturningStudentsLoggingAdvice(List<Student> students) {// метод, в котором бизнес-логика уже закончился
//        // но мы можем перехватить его таким эдвайсом и изменить возвращаемое значение, которое вернется в точку вызова метода с бизнес-логикой
//        Student st1 = students.get(0);
//        String nameSurname = st1.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//        st1.setNameSurname(nameSurname);
//        double avgGrade = st1.getAvgGrade();
//        avgGrade += 1;
//        st1.setAvgGrade(avgGrade);
//        System.out.println("beforeAfterReturningStudentsLoggingAdvice: логгируем получения списка студентов после работы метода getStudents()");
//    }

//    @AfterThrowing(pointcut = "execution(* getStudents())",
//    throwing = "exception")
//    // можно также использовать джоинпоинт, но в данном случае этого не надо было
//    public void afterThrowingStudentsLoggingAdvice(Throwable exception){//метод отработает в случае исключения в методе с бизнес-логикой,
//    //но все равно вернется исключение в точку вызова метода с бизнес логикой
//        System.out.println("afterThrowingStudentsLoggingAdvice: логгируем выброс исключения"+exception);
//    }

    @After("execution(* getStudents())")
    public void afterStudentsLoggingAdvice(){
        System.out.println("afterStudentsLoggingAdvice: логгируем в любом случае: исключение или нормальное завершение работы");
    }

}
