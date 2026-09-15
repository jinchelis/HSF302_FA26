package fu.de200046;

import fu.de200046.pojo.Department;
import fu.de200046.pojo.Employee;
import fu.de200046.pojo.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Department dept = new Department("IT", "Da Nang");

        Employee emp = new Employee(
                "test@company.com",
                "Test",
                Gender.OTHER,
                new BigDecimal("1000"),
                LocalDate.now()
        );

        dept.addEmployee(emp);

        System.out.println(
                dept.getEmployees().contains(emp)
        );

        System.out.println(
                emp.getDepartment() == dept
        );

        dept.removeEmployee(emp);

        System.out.println(
                dept.getEmployees().contains(emp)
        );

        System.out.println(
                emp.getDepartment() == null
        );
    }
}