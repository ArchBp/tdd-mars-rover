package hq.utils.movement.handler.backward;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.movement.handler.LinearMovementHandler;

public class BackwardNorthMovementHandler extends LinearMovementHandler {

    public BackwardNorthMovementHandler() {
        super(Direction.N);
    }

    @Override
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates coordinatesToBeReturned = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (coordinatesToBeReturned.getY() == LOW_EDGE) {
            coordinatesToBeReturned.setX((HIGH_EDGE - actualCoordinates.getX()) + 1);
            rover.setDirection(Direction.S);
        } else {
            coordinatesToBeReturned.decrementY();
        }
        return coordinatesToBeReturned;
    }
}
