package valentinood.se.models;

import java.util.List;
import java.util.Optional;

public interface Vehicle {
    void fillGas();
    double getGas();
    VehicleSize getSize();
    void board(Ticket ticket);
    List<Ticket> getTickets();

    Optional<Employee> getDriver();
    void setDriver(Employee employee);

    int getId();

    void drive();
}
