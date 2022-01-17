package com.dmitryshulga.spring.rest.exception_handling;

public class EmployeeIncorrectData {// класс, объекты которого будут возвращаться в оберетке респонса, в случае если не будет найдено нужного эмплои
    private String info;// поле, куда будет помещен мэсседж респонса
    public EmployeeIncorrectData(){

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
