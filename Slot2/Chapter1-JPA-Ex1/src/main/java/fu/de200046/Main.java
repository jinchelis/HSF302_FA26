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
        // ===== TEST TODO 5 =====

        EmployeeDAO employeeDAO = new EmployeeDAO();


        // ===== TEST TODO 6: UPDATE =====

        Employee employee = employeeDAO.findById(1L);

        if (employee != null) {

            System.out.println("Before update:");
            System.out.println("Name: " + employee.getFullName());
            System.out.println("Salary: " + employee.getSalary());

            // Sửa salary
            employee.setSalary(new BigDecimal("20000000"));

            // Update
            employeeDAO.update(employee);

            // Đọc lại để kiểm tra
            Employee updated = employeeDAO.findById(1L);

            System.out.println("\nAfter update:");
            System.out.println("Name: " + updated.getFullName());
            System.out.println("Salary: " + updated.getSalary());

        } else {
            System.out.println("Employee not found!");
        }
    }
}
