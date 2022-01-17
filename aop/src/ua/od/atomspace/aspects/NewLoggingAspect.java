package ua.od.atomspace.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // в эдвайсе типа эраунд мы получаем полный доступ к методу с бизнес-логикой
        // возвращаемый тип эдвайса должен соответствовать возвращаемому типу метода с бизнес-логикой
        // мы берем на себя ответственность за высозов таргет метода
        // можно изменить результат таргет метода и вернуть его в точку вызова, но не желательно это делать
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println("aroundReturnBookLoggingAdvice: Exception был залоггирован");
            // дальше есть 2 варианта: выкинуть исключение дальше в точку вызова таргет метода
            throw e;
            // либо варинт похуже: захардкодить возвращение дефолтного значения
            // return "неизвестная книга";
        }
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        return object;
    }
}
