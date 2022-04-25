package hq.utils.command.handler;

import hq.Rover;
import hq.utils.movement.handler.MovementHandler;

public abstract class CommandHandler {
    public static final char MOVE_BACKWARD = 'b';
    public static final char MOVE_FORWARD = 'f';
    public static final char TURN_RIGHT = 'r';
    public static final char TURN_LEFT = 'l';

    protected CommandHandler nextCommandHandler;
    protected MovementHandler movementHandler;
    protected final Character command;

    public CommandHandler(Character command) {
        this.command = command;
    }

    public abstract void execute(char command, Rover rover);

    public void next(CommandHandler nextCommandHandler){
        this.nextCommandHandler = nextCommandHandler;
    }

    public void child(MovementHandler movementHandler){
        this.movementHandler = movementHandler;
    }
}
