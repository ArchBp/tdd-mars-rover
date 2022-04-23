package hq;

import hq.enums.Direction;
import hq.model.Coordinates;

public class Rover {
    private final Coordinates coordinates;
    private final Direction direction;

    public Rover(Coordinates coordinates, Direction direction) {

        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates move(char command) {
        if ('b' == command) {
            return moveBackward(coordinates, direction);
        }
        return moveForward(coordinates, direction);
    }

    private Coordinates moveForward(Coordinates coordinates, Direction direction) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (Direction.N.equals(direction)) {
            y++;
        } else if (Direction.S.equals(direction)) {
            y--;
        } else if (Direction.E.equals(direction)) {
            if (x == 5)
                x = 1;
            else
                x++;
        } else if (Direction.W.equals(direction)) {
            if (x == 1)
                x = 5;
            else
                x--;
        }
        coordinates.setY(y);
        coordinates.setX(x);
        return coordinates;
    }

    private Coordinates moveBackward(Coordinates coordinates, Direction direction) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (Direction.N.equals(direction))
            y--;
        else if (Direction.S.equals(direction))
            y++;
        else if (Direction.E.equals(direction))
            if (x == 1)
                x = 5;
            else
                x--;
        else if (Direction.W.equals(direction))
            if (x == 5)
                x = 1;
            else
                x++;

        coordinates.setY(y);
        coordinates.setX(x);
        return coordinates;
    }
}
