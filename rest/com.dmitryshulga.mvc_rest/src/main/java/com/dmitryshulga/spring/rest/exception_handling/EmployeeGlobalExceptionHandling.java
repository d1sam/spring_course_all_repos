package com.dmitryshulga.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice// класс аспект, в котором прописаны методы, которые будут перехватывать эксепшены
public class EmployeeGlobalExceptionHandling {
    @ExceptionHandler// аннотация, указывающая, что данный метод будет перехватывать определенный эксепшен
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception){// возвращает обертку-респонс
        EmployeeIncorrectData data = new EmployeeIncorrectData();// создаем объект который будет возвращаться в респонсе
        data.setInfo(exception.getMessage());// вытягиваем из эксепшена мэсседж и помещяем его в возвращаемый объект
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);// помещяем возвращаемый объект в обертку и указываем статус респонса
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception){// аннотация, указывающая,
        // что данный метод будет перехватывать все эксепшены, которые не поймали другие хэндлеры
        EmployeeIncorrectData data = new EmployeeIncorrectData();// создаем объект который будет возвращаться в респонсе
        data.setInfo(exception.getMessage());// вытягиваем из эксепшена мэсседж и помещяем его в возвращаемый объект
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);// помещяем возвращаемый объект в обертку и указываем статус респонса
    }
}
