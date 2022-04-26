package hq.utils.movement.handler.forward;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.movement.handler.LinearMovementHandler;

public class ForwardSouthMovementHandler extends LinearMovementHandler {

    public ForwardSouthMovementHandler() {
        super(Direction.S);
    }

    @Override
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates coordinatesToBeReturned = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (coordinatesToBeReturned.getY() == 1) {
            coordinatesToBeReturned.setX((5 - actualCoordinates.getX()) + 1);
            rover.setDirection(Direction.N);
        } else {
            coordinatesToBeReturned.decrementY();
        }
        return coordinatesToBeReturned;
    }
}
