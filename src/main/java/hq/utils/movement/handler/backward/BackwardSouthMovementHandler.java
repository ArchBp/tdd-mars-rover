package hq.utils.movement.handler.backward;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.movement.handler.LinearMovementHandler;

public class BackwardSouthMovementHandler extends LinearMovementHandler {

    public BackwardSouthMovementHandler() {
        super(Direction.S);
    }

    @Override
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates coordinatesToBeReturned = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (coordinatesToBeReturned.getY() == HIGH_EDGE) {
            coordinatesToBeReturned.setX((HIGH_EDGE - actualCoordinates.getX()) + 1);
            rover.setDirection(Direction.N);
        } else {
            coordinatesToBeReturned.incrementY();
        }
        return coordinatesToBeReturned;
    }
}
