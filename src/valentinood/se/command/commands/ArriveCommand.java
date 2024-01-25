package valentinood.se.command.commands;

import valentinood.se.command.Command;
import valentinood.se.models.Train;
import valentinood.se.models.Vehicle;
import valentinood.se.vehicles.VehicleRepositoryFactory;

import java.text.DecimalFormat;
import java.util.Optional;

public class ArriveCommand extends Command {
    private final DecimalFormat format = new DecimalFormat("###,###,###.##");
    public ArriveCommand() {
        super("arrive", "a");
    }

    @Override
    public void execute(String[] args) {
        Optional<Vehicle> opt = VehicleRepositoryFactory.getRepository().arrive();

        if (opt.isEmpty()) {
            System.out.println("No vehicle");
            return;
        }

        Vehicle vehicle = opt.get();

        System.out.println("Vehicle arrived: ");
        System.out.println(" ID: " + vehicle.getId());
        System.out.println(" Vehicle: " + vehicle.getClass().getName());
        System.out.println(" Gas: " + format.format(vehicle.getGas()));
        System.out.println(" Size: " + vehicle.getSize());

        if (vehicle instanceof Train train) {
            System.out.println(" Space: " + train.getMaxSpace());
        }

        if (vehicle.getGas() <= 0.1) {
            vehicle.fillGas();
            System.out.println("Employee " + vehicle.getDriver().get().getName() + " has filled the gas/battery.");
        }
    }
}
