package com.dmitryshulga.spring.security.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};// прописываем путь к конфигу аплликейшен контекста
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//означает, что какой-бы адресс мы бы не прописали, то по-любому он будет приходить на диспетчер сервлет
    }
}