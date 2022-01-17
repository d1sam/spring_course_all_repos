package ua.od.atomspace;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Method main starts...");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary",UniLibrary.class);
        String bookName = null;
        try {
           bookName = uniLibrary.returnBook();
       }catch (Exception e){
            System.out.println("Был пойман эксепшен!");
        }
        System.out.println("В библиотеку вернули книгу "+bookName);

        context.close();
    }
}
