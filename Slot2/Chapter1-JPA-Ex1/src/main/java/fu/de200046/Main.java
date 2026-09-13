package fu.de200046;

import fu.de200046.dao.EmployeeDAO;
import fu.de200046.pojo.Employee;
import fu.de200046.pojo.Gender;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        // ================= CREATE =================

        Employee employee = new Employee();

        employee.setFullName("Tran Van B");
        employee.setEmail("tranvanb@gmail.com");
        employee.setSalary(new BigDecimal("12000000"));
        employee.setGender(Gender.MALE);
        employee.setHireDate(LocalDate.of(2024, 1, 15));
        employee.setActive(true);

        employeeDAO.save(employee);

        System.out.println("=== CREATE ===");
        System.out.println("Created employee ID: " + employee.getId());


        // ================= READ =================

        Employee found = employeeDAO.findById(employee.getId());

        System.out.println("\n=== READ ===");

        if (found != null) {
            System.out.println("ID: " + found.getId());
            System.out.println("Name: " + found.getFullName());
            System.out.println("Email: " + found.getEmail());
            System.out.println("Salary: " + found.getSalary());
        }


        // ================= UPDATE =================

        System.out.println("\n=== UPDATE ===");

        found.setSalary(new BigDecimal("18000000"));

        employeeDAO.update(found);

        Employee updated = employeeDAO.findById(found.getId());

        System.out.println("Updated salary: " + updated.getSalary());


        // ================= DELETE =================

        System.out.println("\n=== DELETE ===");

        employeeDAO.delete(updated.getId());

        Employee deleted = employeeDAO.findById(updated.getId());

        if (deleted == null) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Delete failed!");
        }
    }
}
