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
    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates actualCoordinates = rover.getCoordinates();
        Coordinates newCoordinates = new Coordinates(actualCoordinates.getX(), actualCoordinates.getY());
        if (actualCoordinates.getY() == 5) {
            newCoordinates.setX((5 - actualCoordinates.getX()) + 1);
            rover.setDirection(Direction.S);
        } else {
            newCoordinates.incrementY();
        }
        return newCoordinates;
    }
}
