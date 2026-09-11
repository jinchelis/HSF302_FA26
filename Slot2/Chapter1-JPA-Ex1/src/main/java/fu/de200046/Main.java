package fu.de200046;

import fu.de200046.dao.EmployeeDAO;
import fu.de200046.pojo.Employee;
import fu.de200046.pojo.Gender;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee employee = new Employee();
        employee.setFullName("Nguyen Van A");
        employee.setEmail("nguyenvana@gmail.com");
        employee.setSalary(new BigDecimal("15000000"));
        employee.setGender(Gender.MALE);
        employee.setHireDate(LocalDate.of(2024, 1, 15));
        employee.setActive(true);

        // Test TODO 0.3: save()
        employeeDAO.save(employee);

        // ID được tự động sinh sau khi persist()
        System.out.println("Employee saved successfully!");
        System.out.println("Generated ID: " + employee.getId());
    }
}
