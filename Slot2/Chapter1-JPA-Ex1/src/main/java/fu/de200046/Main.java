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

        // ===== TODO 0.9: DUPLICATE EMAIL =====

        Employee existing = new Employee();

        existing.setFullName("Test Employee");
        existing.setEmail("test@gmail.com");
        existing.setSalary(new BigDecimal("10000000"));
        existing.setGender(Gender.MALE);
        existing.setHireDate(LocalDate.now());
        existing.setActive(true);

        employeeDAO.save(existing);

        try {
            Employee duplicate = new Employee();

            duplicate.setFullName("Duplicate Employee");
            duplicate.setEmail("test@gmail.com"); // TRÙNG EMAIL
            duplicate.setSalary(new BigDecimal("15000000"));
            duplicate.setGender(Gender.MALE);
            duplicate.setHireDate(LocalDate.now());
            duplicate.setActive(true);

            employeeDAO.save(duplicate);

            System.out.println("Duplicate email test failed!");

        } catch (Exception e) {
            System.out.println("Duplicate email detected successfully!");
        }
    }
}
