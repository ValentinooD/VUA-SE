import org.junit.jupiter.api.Test;
import valentinood.se.models.LargeTrain;
import valentinood.se.models.Vehicle;
import valentinood.se.vehicles.VehicleRepository;
import valentinood.se.vehicles.VehicleRepositoryFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrivalDepartureTests {
    private VehicleRepository repository;

    private void prepare() {
        repository = VehicleRepositoryFactory.getRepository();
        repository.clearVehicles();
        repository.addVehicle(new LargeTrain());
    }

    @Test
    public void testDepartureAndArrival() {
        prepare();

        assertTrue(repository.arrive().isEmpty());

        Vehicle vehicle = repository.depart().get();
        assertTrue(repository.getArrived().isEmpty());
        assertTrue(repository.depart().isEmpty()); // can't depart if there's nothing

        Vehicle arrived = repository.arrive().get();

        assertEquals(vehicle, arrived);

        assertTrue(repository.arrive().isEmpty());
        assertTrue(repository.getDeparted().isEmpty());
    }

    @Test
    public void testGasConsumption() {
        prepare();

        Vehicle vehicle = repository.getArrived().getFirst();
        double gasBefore = vehicle.getGas();

        repository.depart();
        repository.arrive();

        double gasAfter = vehicle.getGas();

        assertTrue(gasBefore > gasAfter);
    }
}
