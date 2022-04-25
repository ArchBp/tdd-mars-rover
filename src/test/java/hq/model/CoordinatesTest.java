package hq.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static hq.model.Coordinates.X_COORDINATE_COULD_NOT_BE_NULL;
import static hq.model.Coordinates.Y_COORDINATE_COULD_NOT_BE_NULL;

class CoordinatesTest {

    @Test
    void mustCreateExpectedCoordinates() {
        final Coordinates coordinates = new Coordinates(5, 1);

        Assertions.assertThat(coordinates.getX()).isEqualTo(5);
        Assertions.assertThat(coordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustNotAllowNullHorizontalPositionValue() {

        final Throwable throwable = Assertions.catchThrowable(() -> new Coordinates(null, 1));

        Assertions.assertThat(throwable).isExactlyInstanceOf(NullPointerException.class)
                .hasMessage(X_COORDINATE_COULD_NOT_BE_NULL);
    }

    @Test
    void mustNotAllowNullVerticalPositionValue() {

        final Throwable throwable = Assertions.catchThrowable(() -> new Coordinates(1, null));

        Assertions.assertThat(throwable).isExactlyInstanceOf(NullPointerException.class)
                .hasMessage(Y_COORDINATE_COULD_NOT_BE_NULL);
    }
}