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

        employee.setDepartment(department);

        System.out.println("Employee: " + employee.getFullName());
        System.out.println("Department: " + employee.getDepartment().getName());
    }
}