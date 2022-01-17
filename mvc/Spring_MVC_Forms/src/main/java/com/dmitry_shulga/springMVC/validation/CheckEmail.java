package com.dmitry_shulga.springMVC.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)// аннотацией можно будет аннотировать только поле
@Retention(RetentionPolicy.RUNTIME)// аннотацию будет видно даже в рантайме
@Constraint(validatedBy = CheckEmailValidator.class)// указываем на класс, который будет валидировать
public @interface CheckEmail {
    // значение, которое будет проходить валидацию
    String value() default "xyz.com";
    // message, который будет на jsp странице, в случае не прохождения валидации
    String message() default "email must ends xyz.com";
    // 2 обязательных аттрибута
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
