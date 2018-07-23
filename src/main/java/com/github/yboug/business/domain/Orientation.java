package com.github.yboug.business.domain;

import com.github.yboug.business.enums.OrientationEnum;
import com.github.yboug.business.enums.RotationEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Orientation of movable EAST, NORTH, WEST, SOUTH
 *
 * @author Youness
 */
@AllArgsConstructor
@Getter
@Builder
public class Orientation {

    private OrientationEnum orientationEnum;

    /**
     * Return a new orientation after a rotation
     *
     * @param rotation to apply
     * @return new orientation
     */
    public Orientation rotate(RotationEnum rotation) {

        if (rotation == null) {
            throw new IllegalArgumentException("Unknown rotation");
        }

        int result = ((this.orientationEnum.getType() + rotation
                .getType()) % 4);
        if (result == 0)
            result = 4;
        switch (result) {
            case 1:
                this.orientationEnum = OrientationEnum.NORTH;
                break;
            case 2:
                this.orientationEnum = OrientationEnum.EAST;
                break;
            case 3:
                this.orientationEnum = OrientationEnum.SOUTH;
                break;
            case 4:
                this.orientationEnum = OrientationEnum.WEST;
                break;
        }
        return this;
    }

}
