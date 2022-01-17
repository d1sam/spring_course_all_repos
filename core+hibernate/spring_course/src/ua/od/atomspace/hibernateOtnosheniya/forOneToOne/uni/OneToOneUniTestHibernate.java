package ua.od.atomspace.hibernateOtnosheniya.forOneToOne.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUniTestHibernate {
    public static void main(String[] args) {
//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Detail.class)
//                .buildSessionFactory()) {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Zaur","Tregulov","IT",500);
//            Detail detail = new Detail("Baku","+380952009829","zaurTreg@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
//            System.out.println("DONE");
//        }
//        // -----------------------------------------------------------------------------
//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Detail.class)
//                .buildSessionFactory()) {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleh", "Shevchenko", "Sales", 700);
//            Detail detail = new Detail("Kyiv", "+380953420046", "olehShev01@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
//            System.out.println("DONE");
//        }


        // -----------------------------------------------------------------------------
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee.getEmpDetail());
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee empForDelete = session.get(Employee.class,2);
            session.delete(empForDelete);
            session.getTransaction().commit();
            System.out.println("DONE");
        } finally {
            session.close();
            factory.close();
        }
    }
}
