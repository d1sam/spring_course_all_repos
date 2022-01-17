package ua.od.atomspace.hibernateOtnosheniya.loadingTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadingTypesTestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            // OneToOne - fetch = FetchType.EAGER
            // ManyToOne - fetch = FetchType.EAGER
            // OneToMany - fetch = FetchType.LAZY
            // ManyToMany - fetch = FetchType.LAZY

            // когда фетч тайп лейзи, то энтити, с которыми
            // существует связь подгружаются по мере поступления
            // запроса на получение их

            System.out.println("Get department:");
            Department dep = session.get(Department.class,1);
            System.out.println("Show department:");
            System.out.println(dep);
            System.out.println("Show employees:");
            System.out.println(dep.getEmps());

            session.getTransaction().commit();
            System.out.println("DONE");
        } finally {
            session.close();
            factory.close();
        }
    }
}
