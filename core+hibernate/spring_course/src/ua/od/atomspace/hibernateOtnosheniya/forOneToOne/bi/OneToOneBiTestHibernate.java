package ua.od.atomspace.hibernateOtnosheniya.forOneToOne.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiTestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            // --------------------------------------------------------------------

//            Employee employee = new Employee("Misha","Sidorov","HR",850);
//            Detail detail = new Detail("London","+890240928933","missshanyaa@gmail.com");
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.save(detail);

            // --------------------------------------------------------------------

//            Detail detail = session.get(Detail.class,1);
//            System.out.println(detail.getEmployee());

            // --------------------------------------------------------------------

//            Detail detail = session.get(Detail.class,1);
//            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("DONE");
        } finally {
            session.close();
            factory.close();
        }
    }
}
