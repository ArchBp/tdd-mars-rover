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
        Coordinates newCoordinates = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (actualCoordinates.getX() == HIGH_EDGE)
            newCoordinates.setX(LOW_EDGE);
        else
            newCoordinates.incrementX();
        return newCoordinates;
    }
}
