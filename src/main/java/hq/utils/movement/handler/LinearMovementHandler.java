package hq.utils.movement.handler;

import hq.Rover;
import hq.enums.Direction;

public abstract class LinearMovementHandler extends MovementHandler {
    public static final int HIGH_EDGE = 5;
    public static final int LOW_EDGE = 1;
    private final Direction direction;

    protected LinearMovementHandler(Direction direction) {
        this.direction = direction;
    }

    public void move(Rover rover) {
        if (direction == rover.getDirection()) {
            changePosition(rover);
            if(rover.isObstacleFound()){
                getStepBackMovementHandler().move(rover);
            }
        } else if (getNextMovementHandler() != null) {
            getNextMovementHandler().move(rover);
        }
    }


    public abstract void changePosition(Rover rover);
}
