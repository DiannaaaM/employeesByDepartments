package com.example.employees;

import java.util.Objects;

public class Employee {
    private String name;
    private String familyName;
    private String fullName;
    private byte departament;
    private int salary;
    public Employee(String name, String familyName, byte departament, int salary){
        this.name = name;
        this.familyName = familyName;
        this.fullName = this.familyName + ' ' + this.name;
        this.departament = departament;
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    public String getFamilyName() {
        return this.familyName;
    }

    public byte getDepartament() {
        return this.departament;
    }

    public int getSalary() {
        return this.salary;
    }
    public String getFullName(){
        return this.fullName;
    }
    public void setDepartament(byte departament) {
        this.departament = departament;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee Employee = (Employee) o;
        return departament == Employee.departament && Objects.equals(name, Employee.name) && Objects.equals(familyName, Employee.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, familyName, departament, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", departament=" + departament +
                ", salary=" + salary +
                '}';
    }
}
