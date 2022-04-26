package hq.utils.movement.handler;

import hq.Rover;
import hq.enums.Direction;
import hq.model.Coordinates;

public abstract class LinearMovementHandler extends MovementHandler {
    public static final int HIGH_EDGE = 5;
    public static final int LOW_EDGE = 1;
    private final Direction direction;

    protected LinearMovementHandler(Direction direction) {
        this.direction = direction;
    }

    public void move(Rover rover) {
        if (direction == rover.getDirection()) {
            final Coordinates calculatedNewCoordinates = calculateNewCoordinates(rover);
            if(rover.isThereNoObstacleAt(calculatedNewCoordinates)){
                rover.moveTo(calculatedNewCoordinates);
            } else {
                rover.setMessage("Obstacle found at "+ calculatedNewCoordinates);
            }
        } else if (getNextMovementHandler() != null) {
            getNextMovementHandler().move(rover);
        }
    }


    public abstract Coordinates calculateNewCoordinates(Rover rover);
}
