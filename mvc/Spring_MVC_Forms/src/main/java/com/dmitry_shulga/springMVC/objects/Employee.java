package com.dmitry_shulga.springMVC.objects;


import com.dmitry_shulga.springMVC.validation.CheckEmail;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    // @Size можно указать минимальную и максимальную длину строки, которая будет помещена в определенное поле
    @Size(min = 2, message = "name must be minimum 2 symbols")
    private String name;
    //@NotNull // - не работает, ибо строка конвертируется в ""
    //@NotEmpty // - не работает, ибо можно указать пробелы и эта аннотация допустит
    @NotBlank(message = "surname is required!")// не допускает null, "" и просто пробелы
    private String surname;
    private String department;
    // @Min @Max - обеспечивают валидацию максимальных и минимальных значений, которые могут быть помещены в
    @Min(value = 100, message = "must be greater than 99")
    @Max(value = 1000, message = "must be less than 1001")
    private int salary;
    private Map<String, String> departments;
    private String carBrand;
    private Map<String, String> carBrands;
    private String[] languages;
    private Map<String, String> languageList;
    // @Pattern - валидирует строку по переданному регулярному выражению
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use XXX-XX-XX")
    private String phoneNumber;
    // своя написанная валидирующая аннотация
    @CheckEmail(value = "abc.com",message = "email must ends abc.com")
    private String email;

    public Employee() {
        departments = new HashMap<>();
        departments.put("Informational Technologies", "IT");
        departments.put("Human Resources", "HR");
        departments.put("Sales", "Sales");

        carBrands = new HashMap<>();
        carBrands.put("BMW", "BMW");
        carBrands.put("AUDI", "AUDI");
        carBrands.put("Mercedes-Benz", "MB");

        languageList = new HashMap<>();
        languageList.put("English", "EN");
        languageList.put("Deutsch", "DE");
        languageList.put("French", "FR");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Map<String, String> languageList) {
        this.languageList = languageList;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
