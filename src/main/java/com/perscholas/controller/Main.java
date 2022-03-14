package com.perscholas.controller;

public class Main {
    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        EmployeController e = new EmployeController();
        e.createEmployeeTable();
        e.updateemployeetable();
        e.getAllEmployeeInfo();
        e.findEmployeeByID();//invoke the method here
        e.findEmployeeBySalary();
        e.findEmployeeByTwoColumn();
    }
}
