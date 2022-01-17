package com.dmitryshulga.spring.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration// аннотация обозначающая, что данный класс является конфигурацией контекста
@ComponentScan(basePackages = "com.dmitryshulga.spring.rest")// аннотация обозначающая, в каком пакете будет происходить сканирование в поиске бинов
@EnableWebMvc//добавление поддержки форматирования, валидации и различных преобразований, что равносильно в .xml <mvc:annotation-driven/>
@EnableTransactionManagement// включаем поддержку TransactionManager'a, который будет заниматься открытимем и закрытиеем транзакций hibernate
// что равносильно в .xml <tx:annotation-driven transaction-manager="transactionManager"/>
public class MyConfig {
    @Bean
    //создаем бин коннекшен пул, который нужен для быстрого подключения к БД
    public DataSource dataSource(){
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

    @Bean
    //создаем бин, сешн фэктори от Hibernate
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());//инициализируем датасорс созданным бином типа коннекшен пул
        sessionFactory.setPackagesToScan("com.dmitryshulga.spring.rest.entity");// указываем в каком пакете нужно искать наши энтити
        Properties hibernateProperties = new Properties();// создаем характеристики session factory
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");// работаем диалектом скл базы майскл
        hibernateProperties.setProperty("hibernate.show_sql","true");// показываем скл команды в терминале
        sessionFactory.setHibernateProperties(hibernateProperties);// устанавливаем характеристики в сешнфэктори
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(){// создаем транзакшн менеджер, который будет открывать и коммитить транзакции
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
