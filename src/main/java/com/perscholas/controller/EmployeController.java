package com.perscholas.controller;

import com.perscholas.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeController {
    public void createEmployeeTable()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Employee uone = new Employee();
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

    public  void updateemployeetable()
    {
        String name;
        int salary;
        String job;
        String addressLine;
        String zipcode;
        String city;
        Date startDate;
        String sdString;
        int officeCode;

        System.out.println("Enter your name");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Enter your city");
        city = sc.nextLine();
        System.out.println("Enter your addressLine");
        addressLine = sc.nextLine();
        System.out.println("Enter your job");
        job = sc.nextLine();
        System.out.println("Enter your officeCode");
        officeCode = sc.nextInt();
        System.out.println("Enter your salary");
        salary = sc.nextInt();
        System.out.println("Enter your zipcode");
        zipcode = sc.nextLine();
        sc.nextLine();

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t1 = session.beginTransaction();

        String q = "INSERT INTO Employee (addressLine, city, job, name, officeCode, salary, startDate, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        TypedQuery tq = session.createSQLQuery(q);
        tq.setParameter(1, addressLine);
        tq.setParameter(2, city);
        tq.setParameter(3, job);
        tq.setParameter(4, name);
        tq.setParameter(5, officeCode);
        tq.setParameter(6, salary);
        tq.setParameter(7, new Date());
        tq.setParameter(8, zipcode);
        tq.executeUpdate();

        t1.commit();
        System.out.println("Successfully saved");
        factory.close();
        session.close();
    }

    public void getAllEmployeeInfo()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        //if you are going to update/insert/delete data, then we need to open transacation. if we are going to get info we don't need to open.
        TypedQuery q = session.getNamedQuery("allemployee"); //we use getNamedQuery instead of using createQuery().
        List<Employee> employeeList = q.getResultList();
        for (Employee e : employeeList)
        {
            System.out.println(e.getAddressLine());
            System.out.println(e.getCity());
            System.out.println(e.getName());
            System.out.println(e.getJob());
        }
        factory.close();
        session.close();
    }

    public void findEmployeeByID()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery q = session.getNamedQuery("getEmployeebyID");
        //q.setParameter("id", 5); // 5 will goes to id value, and compiler will give this value to getEmployeebyID
        //but this 5 is hard code value, if we want to make it dynamic then we can create a scanner above, and pass the name instead of 5.
        System.out.println("Enter your id: ");
        Scanner enterid = new Scanner(System.in);
        int enterID = enterid.nextInt();
        q.setParameter("id", enterID);
        List<Employee> employeeList1 = q.getResultList();
        for (Employee e : employeeList1)
        {
            System.out.println(e.getName());
            System.out.println(e.getJob());
            System.out.println(e.getAddressLine());
            System.out.println(e.getCity());
            System.out.println(e.getId());
            System.out.println(e.getSalary());
        }
        factory.close();
        session.close();
    }

    public void findEmployeeBySalary()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery q = session.getNamedQuery("getEmployeeBySalary");
        System.out.println("Enter your salary: ");
        Scanner entersalary = new Scanner(System.in);
        int enterSalary = entersalary.nextInt();
        q.setParameter("employsalary", 80000);
        List<Employee> employeeList2 = q.getResultList();
        for (Employee e : employeeList2)
        {
            System.out.println(e.getName());
            System.out.println(e.getSalary());
        }
        factory.close();
        session.close();
    }

    public void findEmployeeByTwoColumn()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery q = session.getNamedQuery("getEmployeeMultipleColumn");
        List<Object[]> list = q.getResultList();
        for (Object[] e : list)
        {
            System.out.println("OfficeCode: " + e[1] + " | Department Name: " + e[3] + " | Employee Name: " + e[2]);
        }
        factory.close();
        session.close();
    }
}
