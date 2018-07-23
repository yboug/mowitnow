package com.github.yboug.business.enums;

/**
 * RotationEnum define a type of Rotation.
 * 
 *     -1 LEFT          +1  RIGHT
 *  
 * @author Youness
 */
public enum RotationEnum {

	RIGHT(1),
	LEFT(-1);

	private int type;

	RotationEnum(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}
}
