package com.github.yboug.business.domain;

import org.junit.Before;
import org.junit.Test;

import static com.github.yboug.Dummy.aDummyLawn;
import static org.assertj.core.api.Assertions.assertThat;

public class LawnTest {

    @Before
    public void setUp() {
    }

    @Test
    public void given_position_should_ba_able_to_move() {
        Lawn lawn = aDummyLawn();
        Position destinationPosition = Position.builder()
                .x(2)
                .y(2)
                .build();
        assertThat(lawn.canMove(destinationPosition)).isTrue();
    }

    @Test
    public void given_position_should_not_be_able_to_move() {
        Lawn lawn = aDummyLawn();
        Position destinationPosition = Position.builder()
                .x(3)
                .y(5)
                .build();
        assertThat(lawn.canMove(destinationPosition)).isFalse();
    }
}