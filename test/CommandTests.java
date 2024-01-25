import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import valentinood.se.command.Command;
import valentinood.se.command.CommandSingletonRepository;
import valentinood.se.command.InvalidCommand;

public class CommandTests {
    private final Command DUMMY_COMMAND = new Command("dummy") {
        @Override
        public void execute(String[] args) {}
    };

    @Test
    public void testProperCalling() {
        CommandSingletonRepository.addCommand(DUMMY_COMMAND);
        assertEquals(CommandSingletonRepository.getCommand(DUMMY_COMMAND.getNames()[0]).getClass(), DUMMY_COMMAND.getClass());
        assertEquals(CommandSingletonRepository.getCommand("jisijfdscds").getClass(), InvalidCommand.class);
    }


}
