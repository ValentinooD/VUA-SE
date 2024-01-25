package valentinood.se.command;

import valentinood.se.command.commands.*;

import java.util.HashMap;

public final class CommandSingletonRepository {
    private static final HashMap<String, Command> commandsMap = new HashMap<>();
    private static final InvalidCommand INVALID_COMMAND = new InvalidCommand();

    static {
        addCommand(new HelpCommand());
        addCommand(new DepartCommand());
        addCommand(new ArriveCommand());
        addCommand(new TicketCommand());
        addCommand(new EmployeeCommand());
    }

    public static Command getCommand(String command) {
        return commandsMap.getOrDefault(command, INVALID_COMMAND);
    }

    public static void addCommand(Command command) {
        for (String name : command.getNames()) {
            commandsMap.put(name, command);
        }
    }
}
