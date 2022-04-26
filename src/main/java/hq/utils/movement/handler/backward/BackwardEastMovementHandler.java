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
        Coordinates newCoordinates = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (actualCoordinates.getX() == LOW_EDGE)
            newCoordinates.setX(HIGH_EDGE);
        else
            newCoordinates.decrementX();
        return newCoordinates;
    }
}
