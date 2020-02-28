package test;

import java.util.ArrayList;
import java.util.List;

public class DeepCloneDemo {

    public static void main(String[] args) {
        Company companyA = new Company();
        companyA.createdYears = 5;
        companyA.employees.add(new Employee("Tom", 20));
        companyA.employees.add(new Employee("Jerry", 22));

        try {
            Company companyB = companyA.clone();
            System.out.println("companyA" + " is " + companyA.toString());
            System.out.println("companyB" + " is " + companyA.toString());
            System.out.println("companyA == companyB" + " is " + (companyA == companyB));
            System.out.println("companyA.firstEmployee == companyB.firstEmployee " + " is " + (companyA.employees.get(0) == companyB.employees.get(0)));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Company implements Cloneable {
    public int createdYears;
    public List<Employee> employees = new ArrayList<>();

    @Override
    public Company clone() throws CloneNotSupportedException {
        Company company = (Company) super.clone();
        company.employees = new ArrayList<>();
        for (Employee employee : employees) {
            company.employees.add(employee.clone());
        }
        return company;
    }

    @Override
    public String toString() {
        StringBuilder employeeString = new StringBuilder();
        if (employees.size() > 1) {
            for (Employee employee : employees) {
                employeeString.append(" employee ").append("name=").append(employee.name).append(", age=").append(employee.age);
            }
        }
        return "Company had created " + createdYears + " years. " + "Employee:" + employeeString;
    }
}

class Employee implements Cloneable {
    public String name;
    public int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
