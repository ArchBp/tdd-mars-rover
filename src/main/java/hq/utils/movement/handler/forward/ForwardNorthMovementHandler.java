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
    public void changePosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (coordinates.getY() == 5) {
            coordinates.setX((5 - coordinates.getX()) + 1);
            rover.setDirection(Direction.S);
        } else {
            coordinates.incrementY();
        }
    }
}
