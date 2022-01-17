package ua.od.atomspace.hibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.od.atomspace.hibernateCRUD.entity.Employee;

public class AddFirstTestHibernate {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Ivan", "Vasiliev", "IT", 1000);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println("DONE: id = "+emp.getId());
        }
    }
}
