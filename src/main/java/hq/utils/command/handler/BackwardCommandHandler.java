package hq.utils.command.handler;

import hq.Rover;

public class BackwardCommandHandler extends CommandHandler{

    public BackwardCommandHandler() {
        super(MOVE_BACKWARD);
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
