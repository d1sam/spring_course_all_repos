package com.dmitryshulga.spring.mvc_hibernate_aop.dao;

import com.dmitryshulga.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
// аннотация, которая указывает, что в данном классе будет проводиться работа с БД
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired// для получения сессии подключения к БД нужна сешн фэктори, которую создали в аппликэйшн котексте
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {// получаем сессию и возвращаем всех эмплои с БД
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {// получаем сессию и либо сохраняем либо обновляем конкретного эмплои
        // (если айди 0, сохраняем, если другое значение, то обновляем)
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {// получаем сессию и возвращаем конкретного эмплои по айди
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {// получаем сессию и удаляем с БД эмплои по конкретному айди
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
