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
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates coordinatesToBeReturned = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (coordinatesToBeReturned.getX() == 5)
            coordinatesToBeReturned.setX(1);
        else
            coordinatesToBeReturned.incrementX();
        return coordinatesToBeReturned;
    }
}
