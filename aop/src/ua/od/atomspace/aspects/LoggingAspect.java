package ua.od.atomspace.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ua.od.atomspace.Book;

@Component("loggingAspectBean")
@Aspect
@Order(10)// указывает порядок вызова эдвайсов с аспектов, когда метод с бизнес-логикой подход по поинткату
//сразу нескольким эдвайсам (типа приоритет вызова)
public class LoggingAspect {

//    @Before("ua.od.atomspace.aspects.MyPointcuts.allAddMethods()")// используем ссылку на нужное поинткат выражение
//    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {// джоинпоинт - точка присоединения метода со сквозной логикой к методу с бизнес-логикой
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();// получаем сигнатуру метода со служебной логикой с джоинпоинта
//        System.out.println("MethodSignature = "+methodSignature);
//        System.out.println("methodSignature.getMethod() = "+methodSignature.getMethod());
//        System.out.println("methodSignature.getReturnType() = "+methodSignature.getReturnType());
//        System.out.println("methodSignature.getName() = "+methodSignature.getName());
//
//        //можем работать с аргументами в зависимости от метода с бизнес-логикой, к которому присоединидлся эдвайс
//        if(methodSignature.getName().equals("addBook")){
//            Object[] arguments = joinPoint.getArgs();
//            for(Object obj: arguments){
//                if (obj instanceof Book){
//                    Book myBook = (Book) obj;
//                    System.out.println("Информация о книге: название - "+myBook.getName()+
//                            ", автор - "+myBook.getAuthor()+
//                            ", год издания - "+myBook.getYearOfPublication());
//                }else if(obj instanceof String){
//                    System.out.println("Книгу добавил "+ obj);
//                }
//            }
//        }
//
//        System.out.println("before getLoggingAdvice: логирование попытки взять книгу/журнал!");
//        System.out.println("-------------------------------------------");
//    }

    // ---------------------------------------------------------
//
//    @Pointcut("execution(* ua.od.atomspace.UniLibrary.*())")// все методы из класса UniLibrary
//    private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void ua.od.atomspace.UniLibrary.returnMagazine())")// pointcut для public void returnMagazine()
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")// все методы из класса UniLibrary, кроме returnMagazine()
//    private void allMethodsFromUniLibraryExceptReturnMagazine(){}
//
//    @Before("allMethodsFromUniLibraryExceptReturnMagazine()")
//    public void beforeAllMethodsExceptReturnMagazineFromUniLibraryLoggingAdvice(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineFromUniLibraryLoggingAdvice: writing Log #10");
//    }

    // ---------------------------------------------------------
//    @Pointcut("execution(* ua.od.atomspace.UniLibrary.get*())")// поинткат для гет методов из UniLibrary
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* ua.od.atomspace.UniLibrary.return*())")// поинткат для ретерн методов из UniLibrary
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allReturnMethodsFromUniLibrary()||allGetMethodsFromUniLibrary()")// поинткат для гет и ретерн методов
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//    @Before("allReturnMethodsFromUniLibrary()")// advice для гет методов из UniLibrary
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetMethodsFromUniLibrary()")// advice для ретерн методов из UniLibrary
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")// advice для гет и ретерн методов
//    private void beforeReturnAndGetAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }

    // ---------------------------------------------------------

    // pointcut - выражение, описувающее где будет вызываться advice
    // нужно обязательно указывать тип возвращаемого значения, название метода и принимаемые значения
    // также можно указать модификатор доступа вначале, полное название класса, к которому будет применяться данный advice
    // и в конце можно указать, что метод выбрасывает какое-то исключение
//    @Before("execution(* get*())")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("before getLoggingAdvice: попытка взять книгу/журнал!");
//    }

    // тот же поинткат, что и выше, только будет применяться только методам из класса UniLibrary
//    @Before("execution(public void ua.od.atomspace.UniLibrary.getBook())")
//    public void beforeGetBookUniAdvice() {
//        System.out.println("before getBookUniAdvice: попытка взять книгу с университета!");
//    }

    // данный поинткат описывает то, что эдвайс будет применяться к методам возврающим String, принимающим void,
    // название которых начинается на get
//    @Before("execution(String get*())")
//    public void beforeReturnBookAdvice() {
//        System.out.println("before getReturnBookAdvice: попытка вернуть книгу!");
//    }

    // независимо от названиям и типа возвращаемого значения будем применяться advice (главное, чтобы не было аргументов)
//    @Before("execution(* *())")
//    public void beforeGetAdvice() {
//        System.out.println("before getAdvice: попытка взять что-то!");
//    }

    // для метода у которого аргументом является строка
//    @Before("execution(public void getBook(String))")
//    public void beforeGetBookAdvice() {
//        System.out.println("before getBookAdvice: попытка взять книгу!");
//    }

    // для метода у которого аргументом является одно принимаемое значение любого типа
//    @Before("execution(public void getBook(*))")
//    public void beforeGetBookAdvice() {
//        System.out.println("before getBookAdvice: попытка взять книгу!");
//    }

    // для метода у которого аргументом является 0 или несколько принимамемых значений разных типов
//    @Before("execution(public void getBook(..))")
//    public void beforeGetBookAdvice() {
//        System.out.println("before getBookAdvice: попытка взять книгу!");
//    }

    // для любого метода с любым названием возвращаемым значением
    // у которого аргументом является 0 или несколько принимамемых значений разных типов
//    @Before("execution(* *(..))")
//    public void beforeGetBookAdvice() {
//        System.out.println("before getBookAdvice: попытка взять книгу!");
//    }

    // для методов, у которых первым принимаем значением вляется Book, а дальше может быть сколько угодно и каких угодно аргументов
//    @Before("execution(public void *(ua.od.atomspace.Book,..))")
//    public void beforeGetBookAdvice() {
//        System.out.println("before getBookAdvice: попытка взять книгу!");
//    }
}
