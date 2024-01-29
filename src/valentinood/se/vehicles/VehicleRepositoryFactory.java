package valentinood.se.vehicles;

public final class VehicleRepositoryFactory {
    private static final VehicleRepository repository;

    static {
        repository = new DefaultVehicleRepository();
    }

    private VehicleRepositoryFactory() {
    }

    public static VehicleRepository getRepository() {
        return repository;
    }
}
