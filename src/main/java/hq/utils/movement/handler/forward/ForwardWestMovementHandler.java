package hq.utils.movement.handler.forward;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.movement.handler.LinearMovementHandler;

public class ForwardWestMovementHandler extends LinearMovementHandler {
    public ForwardWestMovementHandler() {
        super(Direction.W);
    }

    @Override
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates coordinatesToBeReturned = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (coordinatesToBeReturned.getX() == 1)
            coordinatesToBeReturned.setX(5);
        else
            coordinatesToBeReturned.decrementX();
        return coordinatesToBeReturned;
    }
}
