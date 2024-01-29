package valentinood.se.command.commands;

import valentinood.se.command.Command;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", "h", "?");
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Help: ");
        System.out.println(" arrive - Vehicle arrive");
        System.out.println(" depart - Vehicle depart");
        System.out.println(" employee - Employee data");
        System.out.println(" ticket - Buy ticket");
    }
}
