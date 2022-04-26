package hq.utils.movement.handler.forward;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.movement.handler.LinearMovementHandler;

public class ForwardNorthMovementHandler extends LinearMovementHandler {

    public ForwardNorthMovementHandler() {
        super(Direction.N);
    }

    @Override
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates coordinatesToBeReturned = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (coordinatesToBeReturned.getY() == 5) {
            coordinatesToBeReturned.setX((5 - actualCoordinates.getX()) + 1);
            rover.setDirection(Direction.S);
        } else {
            coordinatesToBeReturned.incrementY();
        }
        return coordinatesToBeReturned;
    }
}
