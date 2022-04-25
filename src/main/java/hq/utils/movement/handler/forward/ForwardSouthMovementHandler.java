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
    public void changePosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (coordinates.getY() == 1) {
            coordinates.setX((5 - coordinates.getX()) + 1);
            rover.setDirection(Direction.N);
        } else {
            coordinates.decrementY();
        }
    }
}
