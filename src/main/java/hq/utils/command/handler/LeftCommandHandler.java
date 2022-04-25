package hq.utils.command.handler;

import hq.Rover;

public class LeftCommandHandler extends CommandHandler{

    public LeftCommandHandler() {
        super(TURN_LEFT);
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
