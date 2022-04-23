package hq.model;

import hq.enums.Direction;

public class Position {
    private Coordinates coordinates;
    private Direction direction;

    public Position(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
