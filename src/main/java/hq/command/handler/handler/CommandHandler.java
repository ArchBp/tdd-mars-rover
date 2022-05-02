package hq.command.handler.handler;

import hq.Rover;
import hq.model.Coordinates;

import java.util.List;

public abstract class CommandHandler {
    public static final char MOVE_BACKWARD = 'b';
    public static final char MOVE_FORWARD = 'f';
    public static final char TURN_RIGHT = 'r';
    public static final char TURN_LEFT = 'l';
    protected final Character command;

    public CommandHandler(Character command) {
        this.command = command;
    }

    public abstract void execute(char command, Rover rover, List<Coordinates> obstacles);
}
