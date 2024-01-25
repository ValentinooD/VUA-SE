package valentinood.se;

import valentinood.se.command.CommandSingletonRepository;
import valentinood.se.employees.EmployeeRepositoryFactory;
import valentinood.se.models.Employee;
import valentinood.se.models.LargeTrain;
import valentinood.se.models.SmallTrain;
import valentinood.se.vehicles.VehicleRepositoryFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeRepositoryFactory.getRepository().addEmployee(new Employee("Fantozzi", 0.10));
        EmployeeRepositoryFactory.getRepository().addEmployee(new Employee("Pierino", 0.11));
        EmployeeRepositoryFactory.getRepository().addEmployee(new Employee("Mozart", 0.05));

        VehicleRepositoryFactory.getRepository().addVehicle(new LargeTrain());
        VehicleRepositoryFactory.getRepository().addVehicle(new LargeTrain());
        VehicleRepositoryFactory.getRepository().addVehicle(new SmallTrain());
        VehicleRepositoryFactory.getRepository().addVehicle(new SmallTrain());

        System.out.println();
        System.out.println();
        System.out.println("Train station of Zagreb - best station");
        System.out.println();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();
            String command = input.split(" ")[0].trim();
            String[] cmdArgs = input.substring(command.length()).trim().split(" ");

            if (cmdArgs[0].isEmpty()) cmdArgs = new String[] {};

            if (!command.equals("exit")) {
                CommandSingletonRepository.getCommand(command.toLowerCase()).execute(cmdArgs);
            } else {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            System.out.println();
        }
    }
}