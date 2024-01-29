package valentinood.se.employees;

import valentinood.se.models.Employee;
import valentinood.se.models.Ticket;

import java.util.*;

public class DefaultEmployeeRepository implements EmployeeRepository {

    private final HashMap<String, Employee> employees;

    DefaultEmployeeRepository() {
        employees = new HashMap<>();
    }

    @Override
    public Optional<Employee> getEmployee(String name) {
        return Optional.of(employees.get(name.toLowerCase()));
    }

    @Override
    public void pay(Employee employee, Ticket ticket) {
        employee.pay(ticket.getPrice() * employee.getSalary());
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.put(employee.getName(), employee);
    }

    @Override
    public Collection<Employee> getAll() {
        return employees.values();
    }

    @Override
    public Optional<Employee> getRandom() {
        List<Employee> all = new ArrayList<>(getAll());
        Collections.shuffle(all);

        if (all.isEmpty()) return Optional.empty();
        return Optional.of(all.get(0));
    }
}
