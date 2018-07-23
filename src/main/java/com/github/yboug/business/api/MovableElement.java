package com.github.yboug.business.api;


import com.github.yboug.business.domain.Position;
import com.github.yboug.business.enums.DirectionEnum;
import com.github.yboug.business.enums.RotationEnum;
import com.github.yboug.exceptions.EngineException;

/**
 * a MovableElement define movable object
 * 
 * @author Youness
 *
 */
public interface MovableElement {

	/**
	 * compute next position
	 * @param direction
	 * @return Position
	 */
	Position computeNextPosition(DirectionEnum direction);

	/**
	 * move to direction
	 * @param direction
	 */
	void move(DirectionEnum direction) throws EngineException;

	/**
	 * rotate to a new orientation using rotation
	 * 
	 * @param rotation
	 */
	void rotate(RotationEnum rotation);

}
