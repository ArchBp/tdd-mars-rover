package hq.command.handler.handler;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;

import java.util.List;

public class LeftCommandHandler extends CommandHandler{

    public LeftCommandHandler() {
        super(TURN_LEFT);
    }

    @Override
    public void execute(char command, Rover rover, List<Coordinates> obstacles) {
        final Direction direction = rover.getDirection();
        if(this.command == command){
            if (Direction.N == direction)
                rover.setDirection(Direction.W);
            else if (Direction.W == direction)
                rover.setDirection(Direction.S);
            else if (Direction.S == direction)
                rover.setDirection(Direction.E);
            else
                rover.setDirection(Direction.N);
        }
    }
}
