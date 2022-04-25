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
    public void changePosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (coordinates.getY() == HIGH_EDGE) {
            coordinates.setX((HIGH_EDGE - coordinates.getX()) + 1);
            rover.setDirection(Direction.N);
        } else {
            coordinates.incrementY();
        }
    }
}
