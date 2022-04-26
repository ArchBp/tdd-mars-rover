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
        Coordinates newCoordinates = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (actualCoordinates.getX() == 5)
            newCoordinates.setX(1);
        else
            newCoordinates.incrementX();
        return newCoordinates;
    }
}
