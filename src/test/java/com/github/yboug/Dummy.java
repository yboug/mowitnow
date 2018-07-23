package com.github.yboug;

import com.github.yboug.business.domain.Lawn;
import com.github.yboug.business.domain.Mower;
import com.github.yboug.business.domain.Orientation;
import com.github.yboug.business.domain.Position;
import com.github.yboug.business.enums.OrientationEnum;

public class Dummy {

    public static Position aDummyPosition(){
        return Position.builder()
                .x(4)
                .y(4)
                .build();
    }

    public static Lawn aDummyLawn(){
        return Lawn.builder()
                .topRight(aDummyPosition())
                .build();
    }

    public static Mower aDummyMower(){
        return Mower.builder()
                .currentOrientation(Orientation.builder()
                        .orientationEnum(OrientationEnum.NORTH)
                        .build())
                .currentPosition(Position.builder()
                        .x(2)
                        .y(3)
                        .build())
                .build();
    }
}
