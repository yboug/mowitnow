package com.github.yboug.business.domain;

import com.github.yboug.business.enums.OrientationEnum;
import com.github.yboug.business.enums.RotationEnum;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {

    private Orientation orientation;

    @Before
    public void setUp() throws Exception {
        orientation = Orientation.builder()
                .orientationEnum(OrientationEnum.NORTH)
                .build();
    }

    @Test
    public void given_right_rotation_should_rotate_to_east() {
        orientation.rotate(RotationEnum.RIGHT);
        assertThat(orientation.getOrientationEnum()).isEqualTo(OrientationEnum.EAST);
    }

    @Test
    public void given_left_rotation_should_rotate_to_west() {
        orientation.rotate(RotationEnum.LEFT);
        assertThat(orientation.getOrientationEnum()).isEqualTo(OrientationEnum.WEST);
    }

    @Test
    public void given_left_and_left_rotation_should_rotate_to_south() {
        orientation.rotate(RotationEnum.LEFT);
        orientation.rotate(RotationEnum.LEFT);
        assertThat(orientation.getOrientationEnum()).isEqualTo(OrientationEnum.SOUTH);
    }

    @Test
    public void given_right_and_right_rotation_should_rotate_to_south() {
        orientation.rotate(RotationEnum.RIGHT);
        orientation.rotate(RotationEnum.RIGHT);
        assertThat(orientation.getOrientationEnum()).isEqualTo(OrientationEnum.SOUTH);
    }

    @Test
    public void given_right_and_left_rotation_should_rotate_to_north() {
        orientation.rotate(RotationEnum.RIGHT);
        orientation.rotate(RotationEnum.LEFT);
        assertThat(orientation.getOrientationEnum()).isEqualTo(OrientationEnum.NORTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_null_rotation_should_not_rotate() {
        orientation.rotate(null);
    }
}