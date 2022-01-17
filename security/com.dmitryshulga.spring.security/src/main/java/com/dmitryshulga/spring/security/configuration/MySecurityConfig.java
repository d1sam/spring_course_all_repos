package com.dmitryshulga.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity// помечаем наш класс, как класс ответственный за security конфигурацию
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    // ниже представлен способ хранения паролей и логинов in memory
    // это такой себе подход с точки зрения безопасности
    // в нормальных приложениях пароль хранится в БД в зашифрованном формате

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();// будем использовать дефолтное шифрование паролей
//        auth.inMemoryAuthentication().withUser(userBuilder// используем метод inMemoryAuthentication(),
//        что значит, что будем хранить пароли и логины в памяти приложения
//                .username("dmitry")// юзернейм
//                .password("shulga")// пароль
//                .roles("EMPLOYEE"))// его роль
//                .withUser(userBuilder
//                        .username("elena")
//                        .password("elena")
//                        .roles("HR"))
//                .withUser(userBuilder
//                        .username("ivan")
//                        .password("ivan")
//                        .roles("MANAGER", "HR"));
//    }

    // чтобы спринг секьюрити брал на себя процедуру аутентификации из БД
    // нужно создать структуру БД именно такой, которую понимает спринг секьюрити
    // 2 таблицы: user, authorities
    // users: username VARCHAR(15) PRIMARY KEY, password VARCHAR(15), enabled TINYINT(1) -- enabled (разрешен вход - 1, не разрешен - 2)
    // username VARCHAR(15) references users(username), authority VARCHAR(25)
    // пароль может хранится в нешифрованном формате {noop}password
    // либо использую один из алгоритмов шифрования, например: {bcrypt}password
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);//
    }

    // метод для авторизации
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// запрашивается авторизация для определенных url
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")// на url / (домашний) добавляем все роли
                .antMatchers("/hr_info").hasAnyRole("HR")// на url /hr_info добавляем все роли
                .antMatchers("/manager_info/**").hasAnyRole("MANAGER")// на url /manager_info/ и дальнейшие от него добавляем все роли
                .and().formLogin().permitAll();// форма логина и пароля будет запрашиваться у всех
    }
}
