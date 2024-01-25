package valentinood.se.command;

public abstract class Command {
    private final String[] names;

    public Command(String... names) {
        this.names = names;
    }

    public abstract void execute(String[] args);

    public String[] getNames() {
        return names;
    }
}
