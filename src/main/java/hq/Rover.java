package hq;

import hq.enums.Direction;
import hq.model.Coordinates;
import hq.utils.command.CommandExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rover {
    public static final String ROVER_COORDINATES_COULD_NOT_BE_NULL = "Rover coordinates could not be null";
    public static final String ROVER_DIRECTION_COULD_NOT_BE_NULL = "Rover direction could not be null";

    private Coordinates coordinates;
    private String message;
    private final CommandExecutor commandExecutor = CommandExecutor.getInstance();
    private final List<Coordinates> obstacles = new ArrayList<>();
    private Direction direction;

    public Rover(Coordinates coordinates, Direction direction) {
        Objects.requireNonNull(coordinates, ROVER_COORDINATES_COULD_NOT_BE_NULL);
        Objects.requireNonNull(direction, ROVER_DIRECTION_COULD_NOT_BE_NULL);
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Rover(Coordinates coordinates, Direction direction, List<Coordinates> obstacles){
        this(coordinates, direction);
        this.obstacles.addAll(obstacles);
    }

    public Coordinates move(char[] commands) {
        if (commands != null && commands.length > 0)
            for (char command : commands) {
                commandExecutor.execute(command, this);
            }
        return coordinates;
    }

    public boolean isThereNoObstacleAt(Coordinates calculatedNewCoordinates){
        return !obstacles.contains(calculatedNewCoordinates);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveTo(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
