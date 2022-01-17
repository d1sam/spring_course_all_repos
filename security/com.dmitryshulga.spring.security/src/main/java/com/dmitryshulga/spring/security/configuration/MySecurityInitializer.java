package com.dmitryshulga.spring.security.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// extendимся от AbstractSecurityWebApplicationInitializer, чтобы запрашивалась дефолтная форма для аутентификации
public class MySecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
