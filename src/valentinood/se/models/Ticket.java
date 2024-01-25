package valentinood.se.models;

public class Ticket {
    private final Vehicle vehicle;
    private final double price;

    public Ticket(Vehicle vehicle, double price) {
        this.vehicle = vehicle;
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPrice() {
        return price;
    }
}
