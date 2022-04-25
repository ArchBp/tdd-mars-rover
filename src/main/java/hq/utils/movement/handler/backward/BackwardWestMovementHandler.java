package hq.utils.movement.handler.backward;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.movement.handler.LinearMovementHandler;

public class BackwardWestMovementHandler extends LinearMovementHandler {
    public BackwardWestMovementHandler() {
        super(Direction.W);
    }

    @Override
    public void changePosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (coordinates.getX() == HIGH_EDGE)
            coordinates.setX(LOW_EDGE);
        else
            coordinates.incrementX();
    }
}
