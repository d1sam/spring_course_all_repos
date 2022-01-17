package ua.od.atomspace;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);

        Book book = context.getBean("book",Book.class);
        library.getBook();
        library.addBook("Dmitry",book);
        library.addMagazine();

        context.close();
    }
}
