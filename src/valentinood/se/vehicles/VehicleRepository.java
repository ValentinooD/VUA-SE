package valentinood.se.vehicles;

import valentinood.se.models.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    Optional<Vehicle> depart();
    Optional<Vehicle> arrive();

    List<Vehicle> getArrived();
    List<Vehicle> getDeparted();

    void addVehicle(Vehicle vehicle);
    void clearVehicles();
}
