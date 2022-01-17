package ua.od.atomspace.hibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.od.atomspace.hibernateCRUD.entity.Employee;

public class AddAndGetOneSecondTestHibernate {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Elena", "Ivanova", "Sales", 500);
            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();
            int myId = emp.getId();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee emp2 = session.get(Employee.class,myId);
            session.getTransaction().commit();
            System.out.println(emp2);
            System.out.println("DONE");
        }
    }
}
