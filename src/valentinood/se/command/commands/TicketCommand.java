package valentinood.se.command.commands;

import valentinood.se.command.Command;
import valentinood.se.models.*;
import valentinood.se.vehicles.VehicleRepository;
import valentinood.se.vehicles.VehicleRepositoryFactory;

import java.util.Scanner;

public class TicketCommand extends Command {
    private final VehicleRepository repository;

    public TicketCommand() {
        super("ticket", "t");
        repository = VehicleRepositoryFactory.getRepository();
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Buying ticket");

        System.out.println("Available vehicles:");
        System.out.println("index\t\tVehicle\t\t\tPrice Lower\t\tPrice Higher\tMaximum Space");
        int i = 0;
        for (Vehicle vehicle : repository.getArrived()) {
            System.out.print(i++ + "\t\t\t" + vehicle.getClass().getSimpleName() + "\t\t\t" + vehicle.getSize().getLowerFee() + "\t\t\t" + vehicle.getSize().getHigherFee());

            if (vehicle instanceof Train train) {
                System.out.println("\t\t\t\t" + train.getMaxSpace());
            } else {
                System.out.println("\t\t\t\tNot applicable");
            }
        }
        System.out.println(" ");
        System.out.println("Use Index = -1 to cancel");
        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);
        System.out.print("ID> ");

        int id = scanner.nextInt();
        scanner.reset();
        if (id == -1) return;


        Vehicle vehicle = repository.getArrived().get(id);
        System.out.println("Selected: " + vehicle.getClass().getSimpleName());

        int fee = -1;
        System.out.println("Select your vehicle type:");
        do {
            if (vehicle instanceof SmallTrain train) {
                System.out.println("car\tvan");
                System.out.print("> ");
                String type = scanner.nextLine().toLowerCase();

                if (type.equals("car")) fee = train.getSize().getLowerFee();
                if (type.equals("van")) fee = train.getSize().getHigherFee();
            } else if (vehicle instanceof LargeTrain train) {
                System.out.println("bus\ttruck");
                System.out.print("> ");
                String type = scanner.nextLine().toLowerCase();

                if (type.equals("bus")) fee = train.getSize().getLowerFee();
                if (type.equals("truck")) fee = train.getSize().getHigherFee();
            } else {
                System.out.println("Unsupported");
                fee = 0;
                return;
            }
        } while (fee == -1);

        vehicle.board(new Ticket(vehicle, fee));
        System.out.println("Ticket purchased for " +vehicle.getClass().getSimpleName() + " for " + fee + " EUR.");
    }
}
