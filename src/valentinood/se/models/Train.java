package valentinood.se.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public abstract class Train implements Vehicle {
    private static final Random random = new Random();
    private static int counter = 0;
    private final List<Ticket> tickets = new ArrayList<>();
    private final VehicleSize size;
    private double gas = 1;
    private Employee driver = null;
    private int id = -1;

    public Train(VehicleSize size) {
        this.size = size;
        this.id = counter++;
    }

    public abstract int getMaxSpace();

    @Override
    public void drive() {
        gas -= random.nextDouble(0.1, 0.4);
    }

    @Override
    public void board(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public void fillGas() {
        gas = 1;
    }

    @Override
    public double getGas() {
        return gas;
    }

    @Override
    public VehicleSize getSize() {
        return size;
    }

    @Override
    public Optional<Employee> getDriver() {
        if (driver == null) return Optional.empty();
        return Optional.of(driver);
    }

    @Override
    public void setDriver(Employee employee) {
        this.driver = employee;
    }

    @Override
    public int getId() {
        return id;
    }
}
