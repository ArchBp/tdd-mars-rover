package hq;

import hq.enums.Direction;
import hq.model.Coordinates;
import hq.command.handler.CommandChainExecutor;
import hq.model.Position;

import java.util.List;
import java.util.Objects;

public class Rover {
    public static final String ROVER_COORDINATES_COULD_NOT_BE_NULL = "Rover coordinates could not be null";
    public static final String ROVER_DIRECTION_COULD_NOT_BE_NULL = "Rover direction could not be null";

    private Coordinates coordinates;
    private String message;
    private final CommandChainExecutor commandChainExecutor = CommandChainExecutor.getInstance();
    private Direction direction;

    public Rover(Coordinates coordinates, Direction direction) {
        Objects.requireNonNull(coordinates, ROVER_COORDINATES_COULD_NOT_BE_NULL);
        Objects.requireNonNull(direction, ROVER_DIRECTION_COULD_NOT_BE_NULL);
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates move(char[] commands, List<Coordinates> obstacles) {
        if (commands != null && commands.length > 0)
            for (char command : commands) {
                commandChainExecutor.execute(command, this, obstacles);
            }
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveTo(Position position, List<Coordinates> obstacles) {
        if(isObstacleDetectedAt(position.getCoordinates(), obstacles)) {
            this.setMessage("Obstacle found at " + position.getCoordinates());
        } else {
            this.coordinates = position.getCoordinates();
            this.direction = position.getDirection();
        }
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

    private boolean isObstacleDetectedAt(Coordinates coordinates, List<Coordinates> obstacles) {
        if(Objects.isNull(obstacles) || obstacles.isEmpty())
            return false;
        return obstacles.contains(coordinates);
    }
}
