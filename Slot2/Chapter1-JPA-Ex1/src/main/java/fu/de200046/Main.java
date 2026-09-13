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
// ===== TEST TODO 7: DELETE =====

        Employee employee = employeeDAO.findById(1L);

        if (employee != null) {

            System.out.println("Before delete:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getFullName());

            employeeDAO.delete(1L);

            Employee deleted = employeeDAO.findById(1L);

            System.out.println("\nAfter delete:");

            if (deleted == null) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Delete failed!");
            }

        } else {
            System.out.println("Employee not found!");
        }
    }
}
