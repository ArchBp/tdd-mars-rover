package hq.utils.command.handler;

import hq.Rover;
import hq.exception.UnknownCommandException;

public class UnknownCommandHandler extends CommandHandler{

    public UnknownCommandHandler() {
        super(null);
    }

    @Override
    public void execute(char command, Rover rover) {
        throw new UnknownCommandException();
    }
}
