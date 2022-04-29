package hq.command.handler.handler;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;

import java.util.List;

public class RightCommandHandler extends CommandHandler{

    public RightCommandHandler() {
        super(TURN_RIGHT);
    }

    @Override
    public void execute(char command, Rover rover, List<Coordinates> obstacles) {
        final Direction direction = rover.getDirection();
        if(this.command == command){
            if (Direction.E == direction)
                rover.setDirection(Direction.S);
            else if (Direction.S == direction)
                rover.setDirection(Direction.W);
            else if (Direction.W == direction)
                rover.setDirection(Direction.N);
            else
                rover.setDirection(Direction.E);
        }
    }
}
