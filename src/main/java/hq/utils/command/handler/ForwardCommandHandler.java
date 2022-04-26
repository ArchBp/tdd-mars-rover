package hq.utils.command.handler;

import hq.Rover;

public class ForwardCommandHandler extends CommandHandler {

    public ForwardCommandHandler() {
        super(MOVE_FORWARD);
    }

    @Override
    public void execute(char command, Rover rover) {
        if (this.command == command) {
            this.movementHandler.move(rover);
        } else {
            if (nextCommandHandler != null) {
                nextCommandHandler.execute(command, rover);
            }
        }
    }
}
