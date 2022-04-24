package hq;

import hq.enums.Direction;
import hq.model.Coordinates;
import hq.model.Position;

public class Rover {
    public static final char MOVE_BACKWARD = 'b';
    public static final char MOVE_FORWARD = 'f';
    public static final char TURN_RIGHT = 'r';
    public static final char TURN_LEFT = 'l';
    private final Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position move(char... commands) {
        for (char command : commands) {
            if (TURN_RIGHT == command) {
                turnRight();
            } else if (TURN_LEFT == command) {
                turnLeft();
            } else if (MOVE_BACKWARD == command) {
                moveBackward();
            } else if (MOVE_FORWARD == command) {
                moveForward();
            }
        }
        return position;
    }

    private void turnRight() {
        if (Direction.E == position.getDirection())
            position.setDirection(Direction.S);
        else if (Direction.S == position.getDirection())
            position.setDirection(Direction.W);
        else if (Direction.W == position.getDirection())
            position.setDirection(Direction.N);
        else
            position.setDirection(Direction.E);
    }

    private void turnLeft() {
        if (Direction.N == position.getDirection())
            position.setDirection(Direction.W);
        else if (Direction.W == position.getDirection())
            position.setDirection(Direction.S);
        else if (Direction.S == position.getDirection())
            position.setDirection(Direction.E);
        else
            position.setDirection(Direction.N);
    }

    private void moveForward() {
        Coordinates coordinates = position.getCoordinates();
        Direction direction = position.getDirection();
        if (Direction.N.equals(direction)) {
            coordinates.incrementY();
        } else if (Direction.S.equals(direction)) {
            coordinates.decrementY();
        } else if (Direction.E.equals(direction)) {
            if (coordinates.getX() == 5)
                coordinates.setX(1);
            else
                coordinates.incrementX();
        } else if (Direction.W.equals(direction)) {
            if (coordinates.getX() == 1)
                coordinates.setX(5);
            else
                coordinates.decrementX();
        }
    }

    private void moveBackward() {
        Coordinates coordinates = position.getCoordinates();
        Direction direction = position.getDirection();
        if (Direction.N.equals(direction))
            coordinates.decrementY();
        else if (Direction.S.equals(direction))
            coordinates.incrementY();
        else if (Direction.E.equals(direction))
            if (coordinates.getX() == 1)
                coordinates.setX(5);
            else
                coordinates.decrementX();
        else if (Direction.W.equals(direction))
            if (coordinates.getX() == 5)
                coordinates.setX(1);
            else
                coordinates.incrementX();
    }
}
