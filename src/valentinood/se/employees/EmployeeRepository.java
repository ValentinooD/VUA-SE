package valentinood.se.employees;

import valentinood.se.models.Employee;
import valentinood.se.models.Ticket;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> getEmployee(String name);
    void pay(Employee employee, Ticket ticket);

    void addEmployee(Employee employee);

    Collection<Employee> getAll();

    Optional<Employee> getRandom();
}
