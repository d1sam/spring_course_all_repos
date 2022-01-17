package ua.od.atomspace.hibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.od.atomspace.hibernateCRUD.entity.Employee;

public class UpdateFourthTestHibernate {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class,1);
//            emp.setSalary(2000);
            session.createQuery("update Employee set salary = 2000 where firstName = 'Dmitry'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
