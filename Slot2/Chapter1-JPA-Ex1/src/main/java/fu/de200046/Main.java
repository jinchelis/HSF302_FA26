package fu.de200046;

import fu.de200046.dao.EmployeeDAO;
import fu.de200046.pojo.Employee;
import fu.de200046.pojo.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        /*
         * ===== TODO 0.10: ENTITY LIFECYCLE =====
         *
         * 1. NEW / TRANSIENT
         *    - Entity object vừa được tạo bằng new.
         *    - Chưa được quản lý bởi EntityManager.
         *
         * 2. MANAGED
         *    - Sau khi gọi em.persist(entity),
         *      entity trở thành Managed.
         *    - JPA sẽ theo dõi các thay đổi của entity.
         *
         * 3. DETACHED
         *    - Khi EntityManager bị close,
         *      entity không còn được quản lý.
         *    - Entity vẫn tồn tại trong Java memory.
         *
         * 4. REMOVED
         *    - Sau khi gọi em.remove(entity),
         *      entity được đánh dấu để xóa khỏi database.
         *
         * Lifecycle:
         *
         * NEW
         *   ↓ persist()
         * MANAGED
         *   ↓ EntityManager.close()
         * DETACHED
         *
         * MANAGED
         *   ↓ remove()
         * REMOVED
         */
    }
}
