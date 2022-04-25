package hq.utils.movement.handler.right;

import hq.Rover;
import hq.enums.Direction;
import hq.utils.movement.handler.MovementHandler;

public class RightMovementHandler extends MovementHandler {

    @Override
    public void move(Rover rover) {
        if (Direction.E == rover.getDirection())
            rover.setDirection(Direction.S);
        else if (Direction.S == rover.getDirection())
            rover.setDirection(Direction.W);
        else if (Direction.W == rover.getDirection())
            rover.setDirection(Direction.N);
        else
            rover.setDirection(Direction.E);
    }
}
