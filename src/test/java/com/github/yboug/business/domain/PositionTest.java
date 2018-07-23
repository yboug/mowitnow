package com.github.yboug.business.domain;

import com.github.yboug.business.enums.DirectionEnum;
import com.github.yboug.business.enums.OrientationEnum;
import com.github.yboug.exceptions.ParsingException;
import org.junit.Before;
import org.junit.Test;

import static com.github.yboug.Dummy.aDummyPosition;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private Position position;

    @Before
    public void setUp() {
        position = aDummyPosition();
    }

    @Test
    public void given_position_should_go_forward_y_plus_1() {
        position.next(DirectionEnum.FORWARD, OrientationEnum.NORTH);
        assertThat(position.getX()).isEqualTo(4);
        assertThat(position.getY()).isEqualTo(5);
    }

    @Test
    public void given_position_should_go_forward_x_plus_1() {
        position.next(DirectionEnum.FORWARD, OrientationEnum.EAST);
        assertThat(position.getX()).isEqualTo(5);
        assertThat(position.getY()).isEqualTo(4);
    }

    @Test
    public void given_position_should_go_forward_x_minus_1() {
        position.next(DirectionEnum.FORWARD, OrientationEnum.SOUTH);
        assertThat(position.getX()).isEqualTo(4);
        assertThat(position.getY()).isEqualTo(3);
    }

    @Test
    public void given_position_should_go_forward_y_minus_1() {
        position.next(DirectionEnum.FORWARD, OrientationEnum.WEST);
        assertThat(position.getX()).isEqualTo(3);
        assertThat(position.getY()).isEqualTo(4);
    }

    @Test
    public void given_position_should_go_backward_y_minus_1() {
        position.next(DirectionEnum.BACKWARD, OrientationEnum.NORTH);
        assertThat(position.getX()).isEqualTo(4);
        assertThat(position.getY()).isEqualTo(3);
    }

    @Test
    public void given_position_should_go_backward_y_plus_1() {
        position.next(DirectionEnum.BACKWARD, OrientationEnum.SOUTH);
        assertThat(position.getX()).isEqualTo(4);
        assertThat(position.getY()).isEqualTo(5);
    }

    @Test
    public void given_position_should_go_backward_x_minus_1() {
        position.next(DirectionEnum.BACKWARD, OrientationEnum.EAST);
        assertThat(position.getX()).isEqualTo(3);
        assertThat(position.getY()).isEqualTo(4);
    }

    @Test
    public void given_position_should_go_backward_x_plus_1() {
        position.next(DirectionEnum.BACKWARD, OrientationEnum.WEST);
        assertThat(position.getX()).isEqualTo(5);
        assertThat(position.getY()).isEqualTo(4);
    }

    @Test
    public void should_parse_position_from_string() throws ParsingException {
        Position position = Position.parsePositionFromString("5 5");
        assertThat(position.getX()).isEqualTo(5);
        assertThat(position.getY()).isEqualTo(5);
    }

    @Test(expected = ParsingException.class)
    public void given_negate_numbers_should_throw_exception() throws ParsingException {
        Position.parsePositionFromString("-5 -5");
    }
}