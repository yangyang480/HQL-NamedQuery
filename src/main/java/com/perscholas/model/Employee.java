package com.perscholas.model;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "employee")
//@NamedQuery( name = "allemployee", query = "SELECT e FROM Employee e" )//after this go to the other class create a new method
//allemployee is the name of the query.
//if we have multiple queries then we will use NamedQueries and out all the query inside of it.
@NamedQueries(
        {
                @NamedQuery( name = "allemployee", query = "SELECT e FROM Employee e" ), //after this go to the other class create a new method
                @NamedQuery( name = "getEmployeebyID", query = "SELECT e FROM Employee e WHERE e.id = : id"), //the second id is just a value, we can put any name here, like employID
                @NamedQuery( name = "getEmployeeBySalary", query = "SELECT e FROM Employee e WHERE e.salary < : employsalary"),
                @NamedQuery( name = "getEmployeeMultipleColumn", query = "SELECT e, e.officeCode, e.name, CASE WHEN (e.officeCode = '1') THEN 'IT'" +
                        "WHEN (e.officeCode = '6') THEN 'Admin'" +
                        "WHEN (e.officeCode = '5') THEN 'HR'" +
                        "WHEN (e.officeCode = '4') THEN 'Developers'" +
                        "ELSE 'General' END FROM Employee e")
}
)

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generate the id automatically.
    private int id;
    private String name;
    private int salary;
    private String job;
    private String addressLine;
    private String zipcode;
    private String city;
    private Date startDate;
    private int officeCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getOfficeCode(){
        return officeCode;
    }

    public void setOfficeCode(int officeCode) {
        this.officeCode = officeCode;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", job=" + job + ", addressLine="
                + addressLine + ", zipcode=" + zipcode + ", city=" + city + ", startDate=" + startDate + "]";
    }
}

