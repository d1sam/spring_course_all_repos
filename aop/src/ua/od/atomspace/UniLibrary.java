package ua.od.atomspace;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {
    public void getBook() {
        System.out.println("Мы берём книгу в университете!");
        System.out.println("-------------------------------------------");
    }

    public void getMagazine() {
        System.out.println("Мы берём журнал в университете!");
        System.out.println("-------------------------------------------");
    }

    public String returnBook(){
      //  int a = 31/0;
        System.out.println("Мы возвращаем книгу в UniLibrary");
        return "Война и мир";
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в UniLibrary");
        System.out.println("-------------------------------------------");
    }

    public void addBook(String personName,Book book){
        System.out.println("Мы добавляем книгу в UniLibrary");
        System.out.println("-------------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Мы добавляем журнал в UniLibrary");
        System.out.println("-------------------------------------------");
    }
}
