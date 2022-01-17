package ua.od.atomspace.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

//    @Pointcut("execution(* get*())")// создаем поинткат для всех геттеров
//    public void allGetMethods(){}
    @Pointcut("execution(* add2*(..))")// создаем поинткат для всех add методов (двойку нужно убрать)
    public void allAddMethods(){}

}
