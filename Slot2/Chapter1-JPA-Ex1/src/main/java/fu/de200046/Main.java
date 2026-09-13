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


        System.out.println("===== Find By Email =====");

        Employee employeeByEmail =
                employeeDAO.findByEmail("nguyenvana@gmail.com");

        if (employeeByEmail != null) {
            System.out.println("Found employee:");
            System.out.println("ID: " + employeeByEmail.getId());
            System.out.println("Name: " + employeeByEmail.getFullName());
            System.out.println("Email: " + employeeByEmail.getEmail());
        } else {
            System.out.println("Employee not found!");
        }



        System.out.println("\n===== Find By Email (Not Found) =====");

        Employee notFound =
                employeeDAO.findByEmail("khongtontai@gmail.com");

        if (notFound != null) {
            System.out.println("Found employee: "
                    + notFound.getFullName());
        } else {
            System.out.println("No employee with this email!");
        }



        System.out.println("\n===== Find By Salary =====");

        List<Employee> employees =
                employeeDAO.findBySalaryGreaterThan(new BigDecimal("10000000"));

        for (Employee e : employees) {
            System.out.println(
                    e.getId() + " - "
                            + e.getFullName() + " - "
                            + e.getSalary()
            );
        }
    }
}
