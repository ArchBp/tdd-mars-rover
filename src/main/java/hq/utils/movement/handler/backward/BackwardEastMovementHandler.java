package hq.utils.movement.handler.backward;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.movement.handler.LinearMovementHandler;

public class BackwardEastMovementHandler extends LinearMovementHandler {
    public BackwardEastMovementHandler() {
        super(Direction.E);
    }

    @Override
    public void changePosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (coordinates.getX() == LOW_EDGE)
            coordinates.setX(HIGH_EDGE);
        else
            coordinates.decrementX();
    }
}
