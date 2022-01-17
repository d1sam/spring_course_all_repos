package ua.od.atomspace.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("exceptionHandlingAspectBean")
@Aspect
@Order(30)
public class ExceptionHandlingAspect {
    @Before("ua.od.atomspace.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddExceptionHandlingAdvice(){
        System.out.println("beforeGetExceptionHandlingAdvice: ловим/обрабатываем " +
                "исключения при попытке получить книгу/журнал");
        System.out.println("-------------------------------------------");
    }
}
