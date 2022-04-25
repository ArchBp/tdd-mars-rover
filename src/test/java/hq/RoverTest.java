package hq;

import hq.enums.Direction;
import hq.exception.UnknownCommandException;
import hq.model.Coordinates;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class RoverTest {

    private static Stream<Arguments> generateMultiRoverCommandsScenarios() {
        return Stream.of(
                Arguments.of(new Position(new Coordinates(1, 1), Direction.N),
                        new char[]{'f', 'f', 'r', 'f', 'f', 'l', 'f'},
                        new Position(new Coordinates(3, 4), Direction.N)),

                Arguments.of(new Position(new Coordinates(1, 1), Direction.E),
                        new char[]{'b', 'b', 'l', 'f', 'f', 'l', 'b', 'b'},
                        new Position(new Coordinates(1, 3), Direction.W)),

                Arguments.of(new Position(new Coordinates(4, 1), Direction.E),
                        new char[]{'f', 'f', 'l', 'f', 'f', 'l', 'f'},
                        new Position(new Coordinates(5, 3), Direction.W)),

                Arguments.of(new Position(new Coordinates(4, 5), Direction.N),
                        new char[]{'f', 'f', 'l', 'f', 'f', 'r', 'f'},
                        new Position(new Coordinates(4, 3), Direction.S)),

                Arguments.of(new Position(new Coordinates(5, 5), Direction.S),
                        new char[]{'b', 'b', 'l', 'f', 'f', 'l', 'f', 'f'},
                        new Position(new Coordinates(4, 2), Direction.S))
        );
    }

    @Test
    void mustMoveRoverForwardInTheNorthDirection() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.N);

        Coordinates newCoordinates = rover.move(new char[]{'f'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(2);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsHeadingWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.W);

        Coordinates newCoordinates = rover.move(new char[]{'f'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(5);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsHeadingEast() {
        Coordinates startingPoint = new Coordinates(5, 1);
        final Rover rover = new Rover(startingPoint, Direction.E);

        Coordinates newCoordinates = rover.move(new char[]{'f'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustMoveRoverForwardInTheSouthDirection() {
        Coordinates startingPoint = new Coordinates(1, 4);
        final Rover rover = new Rover(startingPoint, Direction.S);

        Coordinates newCoordinates = rover.move(new char[]{'f'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(3);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void mustConnectHorizontalEdgeMovingForward() {
        Coordinates startingPoint = new Coordinates(1, 5);
        final Rover rover = new Rover(startingPoint, Direction.N);

        Coordinates newCoordinates = rover.move(new char[]{'f'});

        Assertions.assertThat(newCoordinates.getX()).isEqualTo(5);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(5);
        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.S);
    }

    @Test
    void mustConnectHorizontalEdgeExample2MovingForward() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.S);

        Coordinates newCoordinates = rover.move(new char[]{'f'});

        Assertions.assertThat(newCoordinates.getX()).isEqualTo(5);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.N);
    }

    @Test
    void mustConnectHorizontalEdgeExample3MovingForward() {
        Coordinates startingPoint = new Coordinates(3, 5);
        final Rover rover = new Rover(startingPoint, Direction.N);

        Coordinates newCoordinates = rover.move(new char[]{'f'});

        Assertions.assertThat(newCoordinates.getX()).isEqualTo(3);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(5);
        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.S);
    }

    @Test
    void mustConnectHorizontalEdgeMovingBackward() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.N);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates.getX()).isEqualTo(5);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.S);
    }

    @Test
    void mustConnectHorizontalEdgeExample2MovingBackward() {
        Coordinates startingPoint = new Coordinates(1, 5);
        final Rover rover = new Rover(startingPoint, Direction.S);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates.getX()).isEqualTo(5);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(5);
        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.N);
    }

    @Test
    void mustConnectHorizontalEdgeExample3MovingBackward() {
        Coordinates startingPoint = new Coordinates(3, 5);
        final Rover rover = new Rover(startingPoint, Direction.S);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates.getX()).isEqualTo(3);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(5);
        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.N);
    }

    @Test
    void mustMoveRoverForwardHInTheEastDirection() {
        Coordinates startingPoint = new Coordinates(1, 4);
        final Rover rover = new Rover(startingPoint, Direction.E);
        Coordinates newCoordinates = rover.move(new char[]{'f'});
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(4);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(2);
    }

    @Test
    void mustMoveRoverForwardInTheWestDirection() {
        Coordinates startingPoint = new Coordinates(2, 4);
        final Rover rover = new Rover(startingPoint, Direction.W);

        Coordinates newCoordinates = rover.move(new char[]{'f'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(4);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingNorth() {
        Coordinates startingPoint = new Coordinates(1, 2);
        final Rover rover = new Rover(startingPoint, Direction.N);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingSouth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.S);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(2);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingEast() {
        Coordinates startingPoint = new Coordinates(2, 1);
        final Rover rover = new Rover(startingPoint, Direction.E);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.W);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(2);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsMovingInTheWestDirectionBackward() {
        Coordinates startingPoint = new Coordinates(5, 1);
        final Rover rover = new Rover(startingPoint, Direction.W);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsMovingInTheEastDirectionBackward() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.E);

        Coordinates newCoordinates = rover.move(new char[]{'b'});

        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(5);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustTurnRoverFromNorthToEast() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.N);

        Coordinates returnedCoordinates = rover.move(new char[]{'r'});

        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.E);
        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @Test
    void mustTurnRoverFromEastToSouth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.E);

        Coordinates returnedCoordinates = rover.move(new char[]{'r'});

        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.S);
        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @Test
    void mustTurnRoverFromSouthToWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.S);

        Coordinates returnedCoordinates = rover.move(new char[]{'r'});

        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.W);
        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @Test
    void mustTurnRoverFromWestToNorth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.W);

        Coordinates returnedCoordinates = rover.move(new char[]{'r'});

        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.N);
        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @Test
    void mustTurnRoverFromEastToNorth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.E);

        Coordinates returnedCoordinates = rover.move(new char[]{'l'});

        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.N);
        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @Test
    void mustTurnRoverFromSouthToEast() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.S);

        Coordinates returnedCoordinates = rover.move(new char[]{'l'});

        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.E);
        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @Test
    void mustTurnRoverFromWestToSouth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.W);

        Coordinates returnedCoordinates = rover.move(new char[]{'l'});

        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.S);
        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @Test
    void mustTurnRoverFromNorthToWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.N);

        Coordinates returnedCoordinates = rover.move(new char[]{'l'});

        Assertions.assertThat(rover.getDirection()).isEqualTo(Direction.W);
        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @ParameterizedTest
    @MethodSource("generateMultiRoverCommandsScenarios")
    void mustReturnExpectedPositionAfterMultipleCommands(Position initialPosition, char[] commands, Position expectedFinalPosition) {
        final Rover rover = new Rover(initialPosition.getCoordinates(), initialPosition.getDirection());

        Coordinates newCoordinates = rover.move(commands);

        Assertions.assertThat(newCoordinates).isEqualTo(expectedFinalPosition.getCoordinates());
        Assertions.assertThat(rover.getDirection()).isEqualTo(expectedFinalPosition.getDirection());
    }

    @ParameterizedTest
    @ValueSource(chars = {'e', 'g', '3', 'w', 'F', 'R', ' '})
    void mustThrowUnknownCommandException(char command) {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.N);

        final Throwable throwable = Assertions.catchThrowable(() -> rover.move(new char[]{command}));

        Assertions.assertThat(throwable).isExactlyInstanceOf(UnknownCommandException.class);
    }

    @Test
    void mustHandleNullCommands() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.N);

        final Coordinates returnedCoordinates = rover.move(null);

        Assertions.assertThat(returnedCoordinates).isEqualTo(startingPoint);
    }

    @Test
    void mustNotAllowNullCoordinates() {
        final Throwable throwable = Assertions.catchThrowable(() -> new Rover(null, Direction.E));

        Assertions.assertThat(throwable).isExactlyInstanceOf(NullPointerException.class)
                .hasMessage(Rover.ROVER_COORDINATES_COULD_NOT_BE_NULL);
    }

    @Test
    void mustNotAllowNullDirection() {
        final Throwable throwable = Assertions.catchThrowable(() -> new Rover(new Coordinates(1, 1), null));

        Assertions.assertThat(throwable).isExactlyInstanceOf(NullPointerException.class)
                .hasMessage(Rover.ROVER_DIRECTION_COULD_NOT_BE_NULL);
    }

    public static class Position {
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
}
