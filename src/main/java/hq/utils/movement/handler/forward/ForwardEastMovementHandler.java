package hq.utils.movement.handler.forward;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.movement.handler.LinearMovementHandler;

public class ForwardEastMovementHandler extends LinearMovementHandler {
    public ForwardEastMovementHandler() {
        super(Direction.E);
    }

    @Override
    public void changePosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (coordinates.getX() == 5)
            coordinates.setX(1);
        else
            coordinates.incrementX();
    }
}
