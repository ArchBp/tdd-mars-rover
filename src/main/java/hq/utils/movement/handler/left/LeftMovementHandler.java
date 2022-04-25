package hq.utils.movement.handler.left;

import hq.Rover;
import hq.enums.Direction;
import hq.utils.movement.handler.MovementHandler;

public class LeftMovementHandler extends MovementHandler {

    @Override
    public void move(Rover rover) {
        if (Direction.N == rover.getDirection())
            rover.setDirection(Direction.W);
        else if (Direction.W == rover.getDirection())
            rover.setDirection(Direction.S);
        else if (Direction.S == rover.getDirection())
            rover.setDirection(Direction.E);
        else
            rover.setDirection(Direction.N);
    }
}
