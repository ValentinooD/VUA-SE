package valentinood.se.employees;

public final class EmployeeRepositoryFactory {
    private static final EmployeeRepository repository;

    static {
        repository = new DefaultEmployeeRepository();
    }

    public static EmployeeRepository getRepository() {
        return repository;
    }
}
