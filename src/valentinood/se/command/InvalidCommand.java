package valentinood.se.command;

public class InvalidCommand extends Command {
    InvalidCommand() {
        super(null);
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Invalid command");
    }
}
