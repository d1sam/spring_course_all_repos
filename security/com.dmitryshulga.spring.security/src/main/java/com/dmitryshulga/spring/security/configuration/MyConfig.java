package com.dmitryshulga.spring.security.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration// аннотация обозначающая, что данный класс является конфигурацией контекста
@ComponentScan(basePackages = "com.dmitryshulga.spring.security")// аннотация обозначающая, в каком пакете будет происходить сканирование в поиске бинов
@EnableWebMvc//добавление поддержки форматирования, валидации и различных преобразований, что равносильно в .xml <mvc:annotation-driven/>
public class MyConfig {
    @Bean
    public ViewResolver viewResolver() {// для того, чтобы к jsp страницам можно было обращаться только по имени
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    //создаем бин коннекшен пул, который нужен для быстрого подключения к БД
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");//инициализируем поле, отвечающее за драйвер JDBC
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false");// прописываем урлу к БД
            dataSource.setUser("root");//прописываем под каким юзернеймом будет производиться лог он процесс в бд
            dataSource.setPassword("d1sam");// прописываем пароль к БД
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
