package hq.command.handler.handler;

import hq.Rover;
import hq.exception.UnknownCommandException;
import hq.model.Coordinates;

import java.util.List;

public class UnknownCommandHandler extends CommandHandler{

    private final List<Character> authorizedCommands = List.of(MOVE_FORWARD, MOVE_BACKWARD, TURN_RIGHT, TURN_LEFT);

    public UnknownCommandHandler() {
        super(null);
    }

    @Override
    public void execute(char command, Rover rover, List<Coordinates> obstacles) {
        if(!authorizedCommands.contains(command))
        throw new UnknownCommandException();
    }
}
