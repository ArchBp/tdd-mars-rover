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
    public void changePosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (coordinates.getX() == 1)
            coordinates.setX(5);
        else
            coordinates.decrementX();
    }
}
