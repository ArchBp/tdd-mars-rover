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
    public void changePosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (coordinates.getY() == LOW_EDGE) {
            coordinates.setX((HIGH_EDGE - coordinates.getX()) + 1);
            rover.setDirection(Direction.S);
        } else {
            coordinates.decrementY();
        }
    }
}
