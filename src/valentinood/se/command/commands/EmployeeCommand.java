package valentinood.se.command.commands;

import valentinood.se.command.Command;
import valentinood.se.employees.EmployeeRepository;
import valentinood.se.employees.EmployeeRepositoryFactory;
import valentinood.se.models.Employee;

public class EmployeeCommand extends Command {
    private final EmployeeRepository repository;

    public EmployeeCommand() {
        super("employee", "employees", "e", "emp");
        repository = EmployeeRepositoryFactory.getRepository();
    }

    @Override
    public void execute(String[] args) {
        System.out.println("All Employees:");
        for (Employee employee : repository.getAll()) {
            System.out.println(employee.getName() + " has a salary of " + (employee.getSalary()*100) + "% and a total money of " + employee.getMoney() + " EUR.");
        }
    }
}
