package ua.od.atomspace.hibernateOtnosheniya.forOneToMany.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyUniTestHibernate {
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

//            Department dep = new Department("HR",500,1500);
//            Employee emp1 = new Employee("Ivan","Sergeev",800);
//            Employee emp2 = new Employee("Andrei","Sidorov",1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.save(dep);

            // --------------------------------------------------------------------
//
//            Department dep = session.get(Department.class,2);
//            System.out.println(dep);
//            System.out.println(dep.getEmps());


            // --------------------------------------------------------------------

//            Employee emp = session.get(Employee.class, 1);
//            session.delete(emp);

            // --------------------------------------------------------------------

            Department dep = session.get(Department.class, 1);
            session.delete(dep);

            session.getTransaction().commit();
            System.out.println("DONE");
        } finally {
            session.close();
            factory.close();
        }
    }
}
