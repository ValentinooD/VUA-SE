package valentinood.se.vehicles;

import valentinood.se.employees.EmployeeRepository;
import valentinood.se.employees.EmployeeRepositoryFactory;
import valentinood.se.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultVehicleRepository implements VehicleRepository {
    private final EmployeeRepository employeeRepository;

    private final List<Vehicle> departed = new ArrayList<>();
    private final List<Vehicle> arrived = new ArrayList<>();

    DefaultVehicleRepository() {
        employeeRepository = EmployeeRepositoryFactory.getRepository();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        arrived.add(vehicle);
    }

    @Override
    public Optional<Vehicle> depart() {
        try {
            Vehicle vehicle = arrived.remove(0);
            departed.add(vehicle);

            if (vehicle.getDriver().isEmpty()) {
                Optional<Employee> random = employeeRepository.getRandom();

                random.ifPresent(vehicle::setDriver);
            }

            if (vehicle.getDriver().isPresent()) {
                for (Ticket ticket : vehicle.getTickets()) {
                    Employee driver = vehicle.getDriver().get();
                    driver.pay(ticket.getPrice() * driver.getSalary());
                }
            }

            return Optional.of(vehicle);
        } catch (IndexOutOfBoundsException ex) {
            return Optional.empty(); // i don't care
        }
    }

    @Override
    public Optional<Vehicle> arrive() {
        try {
            Vehicle vehicle = departed.remove(0);
            arrived.add(vehicle);
            vehicle.drive();
            return Optional.of(vehicle);
        } catch (IndexOutOfBoundsException ex) {
            return Optional.empty(); // i don't care
        }
    }

    @Override
    public List<Vehicle> getDeparted() {
        return new ArrayList<>(departed);
    }

    @Override
    public List<Vehicle> getArrived() {
        return new ArrayList<>(arrived);
    }

    @Override
    public void clearVehicles() {
        arrived.clear();
        departed.clear();
    }
}
