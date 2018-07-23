package com.github.yboug.business.domain;

import com.github.yboug.business.enums.DirectionEnum;
import com.github.yboug.business.enums.OrientationEnum;
import com.github.yboug.business.enums.RotationEnum;
import com.github.yboug.exceptions.EngineException;
import org.junit.Before;
import org.junit.Test;

import static com.github.yboug.Dummy.aDummyMower;
import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {

    Mower mower;

    @Before
    public void setUp() throws Exception {
        mower = aDummyMower();
        mower.start();
    }

    @Test
    public void should_start_mower() {
        assertThat(mower.isStarted()).isTrue();
    }

    @Test(expected = EngineException.class)
    public void given_mower_started_should_throw_exception_when_start_mower() throws EngineException {
        mower.start();
    }

    @Test
    public void given_mower_started_should_stop_mower() throws EngineException {
        mower.stop();
        assertThat(mower.isStarted()).isFalse();
    }

    @Test(expected = EngineException.class)
    public void given_mower_stoped_should_throw_exception_when_stop_mower() throws EngineException {
        mower.stop();
        assertThat(mower.isStarted()).isFalse();
        mower.stop();
    }

    @Test
    public void given_mower_should_rotate(){
        mower.rotate(RotationEnum.LEFT);
        assertThat(mower.getCurrentOrientation().getOrientationEnum()).isEqualTo(OrientationEnum.WEST);
    }

    @Test(expected = EngineException.class)
    public void given_stopped_mower_when_move_should_throw_exception() throws EngineException {
        mower.stop();
        mower.move(DirectionEnum.FORWARD);
    }

    @Test
    public void given_started_mower_when_move_should_increment_y() throws EngineException {
        mower.move(DirectionEnum.FORWARD);
        assertThat(mower.getCurrentPosition().getX()).isEqualTo(2);
        assertThat(mower.getCurrentPosition().getY()).isEqualTo(4);
    }

    @Test
    public void given_position_and_direction_should_compute_next_position() {
        Position position = mower.computeNextPosition(DirectionEnum.FORWARD);
        assertThat(position.getX()).isEqualTo(2);
        assertThat(position.getY()).isEqualTo(4);
    }
}