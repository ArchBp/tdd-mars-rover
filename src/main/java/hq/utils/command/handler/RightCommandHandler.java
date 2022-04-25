package hq.utils.command.handler;

import hq.Rover;

public class RightCommandHandler extends CommandHandler{

    public RightCommandHandler() {
        super(TURN_RIGHT);
    }

    @Override
    public void execute(char command, Rover rover) {
        if(this.command == command){
            this.movementHandler.move(rover);
        } else {
            if(nextCommandHandler != null){
                nextCommandHandler.execute(command, rover);
            }
        }
    }
}
