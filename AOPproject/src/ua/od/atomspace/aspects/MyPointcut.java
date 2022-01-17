package ua.od.atomspace.aspects;


import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut("execution(* add*(..))")
    public void addAllMethods(){}
    @Pointcut("execution(* get*())")
    public void addGetMethods(){}
    @Pointcut("addAllMethods()||addGetMethods()")
    public void allAddGetMethods(){}
}
