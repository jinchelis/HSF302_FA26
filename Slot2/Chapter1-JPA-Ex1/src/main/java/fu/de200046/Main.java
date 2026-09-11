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
        // ===== TEST TODO 4 =====

// Test findById()
        Employee found = employeeDAO.findById(1L);

        if (found != null) {
            System.out.println("FindById:");
            System.out.println("ID: " + found.getId());
            System.out.println("Name: " + found.getFullName());
            System.out.println("Email: " + found.getEmail());
        } else {
            System.out.println("Employee not found!");
        }


// Test findAll()
        System.out.println("\nFindAll:");

        List<Employee> employees = employeeDAO.findAll();

        for (Employee e : employees) {
            System.out.println(
                    e.getId() + " - "
                            + e.getFullName() + " - "
                            + e.getEmail()
            );
        }
    }
}
