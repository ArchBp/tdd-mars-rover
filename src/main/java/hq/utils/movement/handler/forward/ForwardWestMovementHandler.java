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
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates newCoordinates = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (newCoordinates.getX() == 1)
            newCoordinates.setX(5);
        else
            newCoordinates.decrementX();
        return newCoordinates;
    }
}
