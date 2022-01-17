package com.dmitry_shulga.springMVC.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// имлементим валидатор от существующего интерфейса валидатора
// указываем в одном из дженериков, под какую аннотацию создается валидатор и какому полю она будет применяться
public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {
    private String endOfEmail;

    @Override
    public void initialize(CheckEmail checkEmail) {
        // в endOfEmail помещяем значение из аннотации
        endOfEmail = checkEmail.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        // проверяем значение, которое валидируется на то ли заканчивается оно на то, что указали в аннотации валидирующегося поля
        return enteredValue.endsWith(endOfEmail);
    }
}
