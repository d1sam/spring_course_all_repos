package ua.od.atomspace.hibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.od.atomspace.hibernateCRUD.entity.Employee;

import java.util.List;

public class GetAllAndByParameterThirdTestHibernate {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            List<Employee> emps = session.createQuery("from Employee").getResultList();
            List<Employee> emps = session.createQuery("from Employee where firstName = 'Dmitry' AND salary > 500")
                    .getResultList();
            for (Employee e : emps) {
                System.out.println(e);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
