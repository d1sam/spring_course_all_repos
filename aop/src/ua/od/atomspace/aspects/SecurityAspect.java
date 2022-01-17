package ua.od.atomspace.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("securityAspectBean")
@Aspect
@Order(20)
public class SecurityAspect {
    @Before("ua.od.atomspace.aspects.MyPointcuts.allAddMethods()")// используем ссылку на нужное поинткат выражение
    public void beforeAddSecurityAdvice() {
        System.out.println("before getSecurityAdvice: проверка прав на получение книги/журнала!");
        System.out.println("-------------------------------------------");
    }
}
