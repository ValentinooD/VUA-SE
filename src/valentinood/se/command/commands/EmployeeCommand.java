package valentinood.se.command.commands;

import valentinood.se.command.Command;
import valentinood.se.employees.EmployeeRepository;
import valentinood.se.employees.EmployeeRepositoryFactory;
import valentinood.se.models.Employee;

import java.util.Scanner;

public class EmployeeCommand extends Command {
    private final EmployeeRepository repository;

    public EmployeeCommand() {
        super("employee", "employees", "e", "emp");
        repository = EmployeeRepositoryFactory.getRepository();
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("All Employees:");
            for (Employee employee : repository.getAll()) {
                System.out.println(employee.getName() + " has a salary of " + (employee.getSalary()*100) + "% and a total money of " + employee.getMoney() + " EUR.");
            }

            System.out.println();
            System.out.println("Usage: employee [add]");
            return;
        }

        if (args[0].equalsIgnoreCase("add")) {
            System.out.println("Adding new employee");
            System.out.print("Name: ");

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            System.out.print("Salary (%): ");
            double salary = scanner.nextDouble();

            Employee employee = new Employee(name, salary);
            repository.addEmployee(employee);
            System.out.println("Added employee " + employee.getName() + " with a salary of " + (employee.getSalary() * 100) + "%.");
        } else {
            System.out.println("Invalid usage");
        }
    }
}
