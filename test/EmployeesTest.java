import org.junit.jupiter.api.Test;
import valentinood.se.employees.EmployeeRepository;
import valentinood.se.employees.EmployeeRepositoryFactory;
import valentinood.se.models.Employee;
import valentinood.se.models.SmallTrain;
import valentinood.se.models.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeesTest {


    @Test
    public void testAddEmployee() {
        EmployeeRepositoryFactory.getRepository().addEmployee(new Employee("Test", 0.1));
        assertFalse(EmployeeRepositoryFactory.getRepository().getAll().isEmpty());
    }

    @Test
    public void testGetEmployee() {
        EmployeeRepository repository = EmployeeRepositoryFactory.getRepository();

        repository.addEmployee(new Employee("Fantozzi", 0.1));
        assertNotNull(repository.getEmployee("Fantozzi"));
    }

    @Test
    public void testPayment() {
        EmployeeRepository repository = EmployeeRepositoryFactory.getRepository();

        Employee employee = new Employee("Payment", 0.5);
        repository.addEmployee(employee);
        repository.pay(employee, new Ticket(new SmallTrain(), 10));

        assertEquals(employee.getMoney(), 5);
    }

    @Test
    public void testGetRandom() {
        EmployeeRepository repository = EmployeeRepositoryFactory.getRepository();

        Employee employee = new Employee("Random1", 0.5);
        Employee employee2 = new Employee("Random1", 0.5);
        Employee employee3 = new Employee("Random1", 0.5);
        Employee employee4 = new Employee("Random1", 0.5);

        repository.addEmployee(employee);
        repository.addEmployee(employee2);
        repository.addEmployee(employee3);
        repository.addEmployee(employee4);

        assertTrue(repository.getRandom().isPresent());
    }
}
