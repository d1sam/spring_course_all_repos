package com.dmitryshulga.spring.springboot.springboot_rest.dao;

import com.dmitryshulga.spring.springboot.springboot_rest.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository// аннотация, которая указывает, что в данном классе будет проводиться работа с БД
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;// EntityManager выполняет роль сессии в JPA, его аналогом в hibernate является Session
    // то есть это механизм по управлению связью между энтити и БД
    // он создается автоматически с помощью SpringBoot,
    // в то время как SessionFactory нам приходилось создавать в контексте с помощью .xml или джава кода

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        так как EntityManager является оберткой сессии, мы его можем равернуть в сессию
//        return session.createQuery("from Employee", Employee.class).getResultList();

        Query query = entityManager.createQuery("from Employee");
        return (List<Employee>) query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee newEmployee = entityManager.merge(employee);// с помощью метода из JPA merge() делаем saveOrUpdate() employee
        // и указываем на новосозданный или измененный объект ссылку newEmployee
        employee.setId(newEmployee.getId());// сетим переданному объекту айди из того объекта, который в БД
        // чтобы из вышевызывающего метода вернулся объект с корректным айди

    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(Employee.class, id);
        return entityManager.find(Employee.class, id);// с помощью метода из JPA find() находим нужный нам объект и возвращаем его выше
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");// создаем query,
        // который будет удалять из БД объект по переменной айди
        query.setParameter("employeeId", id);// сетим эту перменную айди, пришедшим извне
        query.executeUpdate();// выполняем query
    }
}
