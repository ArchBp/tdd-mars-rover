package hq.model;

import hq.enums.Direction;

public class Position {
        private final Coordinates coordinates;
        private final Direction direction;

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
    }
