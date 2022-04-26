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
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates coordinatesToBeReturned = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (coordinatesToBeReturned.getX() == LOW_EDGE)
            coordinatesToBeReturned.setX(HIGH_EDGE);
        else
            coordinatesToBeReturned.decrementX();
        return coordinatesToBeReturned;
    }
}
