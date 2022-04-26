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
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates newCoordinates = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (actualCoordinates.getY() == 1) {
            newCoordinates.setX((5 - actualCoordinates.getX()) + 1);
            rover.setDirection(Direction.N);
        } else {
            newCoordinates.decrementY();
        }
        return newCoordinates;
    }
}
