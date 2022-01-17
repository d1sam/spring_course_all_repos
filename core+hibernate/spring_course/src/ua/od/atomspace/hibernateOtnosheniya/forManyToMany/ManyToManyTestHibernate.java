package ua.od.atomspace.hibernateOtnosheniya.forManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyTestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

// -------------------------------------------------------------------

//            Section footBallSection = new Section("football");
//            Child child1 = new Child(5,"Zaur");
//            Child child2 = new Child(7,"Oleh");
//            Child child3 = new Child(4,"Sveta");
//
//            session.save(footBallSection);
//
//            footBallSection.addChildToSection(child1);
//            footBallSection.addChildToSection(child2);
//            footBallSection.addChildToSection(child3);
//
//            session.save(child1);
//            session.save(child2);
//            session.save(child3);

// -------------------------------------------------------------------

//            Section basketBallSection = new Section("basketball");
//            Section physicSection = new Section("physic");
//            Section csSection = new Section("counter strike");
//            Child child1 = new Child(8,"Masha");
//
//            session.save(child1);
//
//            child1.addSectionToChild(basketBallSection);
//            child1.addSectionToChild(physicSection);
//            child1.addSectionToChild(csSection);
//
//            session.save(basketBallSection);
//            session.save(physicSection);
//            session.save(csSection);

// -------------------------------------------------------------------

//            Выше мы сохраняли сущности в БД без каскада, так как убрали CascadeType.ALL,
//            и в каскаде оставили все кроме CascadeType.REMOVE (для того чтобы удаление не было каскадным)
//            При написании классов Child и Section мы пользовались импортом import javax.persistence.*
//            В этой библиотеке нет каскадного CascadeType.SAVE, а есть только CascadeType.PERSIST
//            Поэтому, чтобы каскадно сохранить сущности нужно пользоваться методом persist (смотрим ниже)

// -------------------------------------------------------------------

//            Section footBallSection = new Section("football");
//            Child child1 = new Child(5,"Zaur");
//            Child child2 = new Child(7,"Oleh");
//            Child child3 = new Child(4,"Sveta");
//
//            footBallSection.addChildToSection(child1);
//            footBallSection.addChildToSection(child2);
//            footBallSection.addChildToSection(child3);
//            session.persist(footBallSection);

// -------------------------------------------------------------------

//            Section basketBallSection = new Section("basketball");
//            Section physicSection = new Section("physic");
//            Section csSection = new Section("counter strike");
//            Child child1 = new Child(8,"Masha");
//
//            child1.addSectionToChild(basketBallSection);
//            child1.addSectionToChild(physicSection);
//            child1.addSectionToChild(csSection);
//            session.persist(child1);

// -------------------------------------------------------------------

//            Section section = session.get(Section.class,1);
//            System.out.println(section);
//            System.out.println(section.getChildren());

// -------------------------------------------------------------------

//            Child child = session.get(Child.class, 4);
//            System.out.println(child);
//            System.out.println(child.getSections());

// -------------------------------------------------------------------

//            Ниже представлено удаление сущностей из таблицы, не затрагивая тех сущностей из другой таблицы
//            С которыми они связаны. Этого достигли благодаря тому, что из каскада удалили CascadeType.ALL
//            и оставили в нем все, кроме CascadeType.REMOVE

// -------------------------------------------------------------------

//            Section section = session.get(Section.class,1);
//            session.delete(section);

// -------------------------------------------------------------------

//            Child child = session.get(Child.class,1);
//            session.delete(child);

            System.out.println("DONE");
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
