package com.dmitryshulga.spring.rest.exception_handling;

public class NoSuchEmployeeException extends RuntimeException {// наследуемся от рантайм-эксепшен, чтобы эксепшен был unhandled и его не нужно было обрабатывать
    public NoSuchEmployeeException(String message) {
        super(message);// передаем message в конструктор RuntimeException
    }
}
