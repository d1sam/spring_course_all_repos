package ua.od.atomspace.hibernateOtnosheniya.forOneToMany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyBiTestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            // --------------------------------------------------------------------

//            Department dep = new Department("IT",300,1200);
//            Employee emp1 = new Employee("Zaur","Tregulov",800);
//            Employee emp2 = new Employee("Elena","Smirnova",1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.save(dep);

            // --------------------------------------------------------------------

//            Department dep = session.get(Department.class,1);
//            System.out.println(dep);
//            System.out.println(dep.getEmps());

            // --------------------------------------------------------------------

//            Employee emp = session.get(Employee.class,1);
//            System.out.println(emp);
//            System.out.println(emp.getDepartment());

            // --------------------------------------------------------------------

            Employee emp = session.get(Employee.class, 1);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("DONE");
        } finally {
            session.close();
            factory.close();
        }
    }
}
