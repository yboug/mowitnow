package com.github.yboug.business.enums;

/**
 * Direction define a direction ( go straight Or go back )
 *       H 1
 *       |
 *       |
 *       B -1
 *       
 * @author Youness
 *
 */
public enum DirectionEnum {

	FORWARD(1),
	BACKWARD(-1);

    private int type;

    DirectionEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
