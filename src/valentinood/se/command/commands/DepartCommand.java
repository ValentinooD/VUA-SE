package valentinood.se.command.commands;

import valentinood.se.command.Command;
import valentinood.se.models.Train;
import valentinood.se.models.Vehicle;
import valentinood.se.vehicles.VehicleRepositoryFactory;

import java.text.DecimalFormat;
import java.util.Optional;

public class DepartCommand extends Command {
    private final DecimalFormat format = new DecimalFormat("###,###,###.##");
    public DepartCommand() {
        super("depart", "d");
    }

    @Override
    public void execute(String[] args) {
        Optional<Vehicle> opt = VehicleRepositoryFactory.getRepository().depart();

        if (opt.isEmpty()) {
            System.out.println("No vehicle");
            return;
        }

        Vehicle vehicle = opt.get();

        System.out.println("Vehicle departed: ");
        System.out.println(" ID: " + vehicle.getId());
        System.out.println(" Vehicle: " + vehicle.getClass().getName());
        System.out.println(" Gas: " + format.format(vehicle.getGas()));
        System.out.println(" Size: " + vehicle.getSize());

        vehicle.getDriver().ifPresent((employee) -> {
            System.out.println(" Driver: " + employee.getName());
        });

        System.out.println(" Tickets: " + vehicle.getTickets().size());

        if (vehicle instanceof Train train) {
            System.out.println(" Space: " + train.getMaxSpace());
        }
    }
}
