package hq;

import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.command.CommandExecutor;

import java.util.Objects;

public class Rover {
    public static final String ROVER_COORDINATES_COULD_NOT_BE_NULL = "Rover coordinates could not be null";
    public static final String ROVER_DIRECTION_COULD_NOT_BE_NULL = "Rover direction could not be null";
    private final Coordinates coordinates;
    private final CommandExecutor commandExecutor = CommandExecutor.getInstance();
    private Direction direction;


    public Rover(Coordinates coordinates, Direction direction) {
        Objects.requireNonNull(coordinates, ROVER_COORDINATES_COULD_NOT_BE_NULL);
        Objects.requireNonNull(direction, ROVER_DIRECTION_COULD_NOT_BE_NULL);
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates move(char[] commands) {
        if (commands != null && commands.length > 0)
            for (char command : commands) {
                commandExecutor.execute(command, this);
            }
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
