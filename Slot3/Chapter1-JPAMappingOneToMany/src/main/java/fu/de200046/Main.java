package fu.de200046;

import fu.de200046.pojo.Department;
import fu.de200046.pojo.Employee;
import fu.de200046.pojo.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Department department = new Department("IT", "Da Nang");

        Employee employee = new Employee(
                "test@gmail.com",
                "Test Employee",
                Gender.MALE,
                new BigDecimal("10000000"),
                LocalDate.now()
        );

        System.out.println("Department:");
        System.out.println("Name: " + department.getName());
        System.out.println("Location: " + department.getLocation());

        System.out.println("\nEmployee:");
        System.out.println("Name: " + employee.getFullName());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Gender: " + employee.getGender());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Hire Date: " + employee.getHireDate());
        System.out.println("Active: " + employee.isActive());
    }
}