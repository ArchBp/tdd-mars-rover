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
        Coordinates newCoordinates = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (actualCoordinates.getY() == LOW_EDGE) {
            newCoordinates.setX((HIGH_EDGE - actualCoordinates.getX()) + 1);
            rover.setDirection(Direction.S);
        } else {
            newCoordinates.decrementY();
        }
        return newCoordinates;
    }
}
