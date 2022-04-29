package hq.command.handler;

import hq.Rover;
import hq.command.handler.handler.*;
import hq.model.Coordinates;

import java.util.List;

public final class CommandChainExecutor {
    public static final int HIGH_EDGE = 5;
    public static final int LOW_EDGE = 1;
    private static CommandChainExecutor instance;
    private final List<CommandHandler> commandHandlers = List.of(
            new ForwardCommandHandler(),
            new BackwardCommandHandler(),
            new RightCommandHandler(),
            new LeftCommandHandler(),
            new UnknownCommandHandler()

    );

    private CommandChainExecutor(){}

    public static CommandChainExecutor getInstance() {
        if (instance == null) {
            instance = new CommandChainExecutor();
        }
        return instance;
    }

    public void execute(char command, Rover rover, List<Coordinates> obstacles) {
        commandHandlers.forEach(commandHandler ->
                commandHandler.execute(command, rover, obstacles));
    }
}
