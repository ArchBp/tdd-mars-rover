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
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates coordinatesToBeReturned = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (coordinatesToBeReturned.getX() == HIGH_EDGE)
            coordinatesToBeReturned.setX(LOW_EDGE);
        else
            coordinatesToBeReturned.incrementX();
        return coordinatesToBeReturned;
    }
}
