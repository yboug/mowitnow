package com.github.yboug.business.api;


import com.github.yboug.business.domain.Position;

/**
 *  a ShapeLimit define à limit of Shape.
 * @author Youness
 *
 */
public interface ShapeLimit {

	
	/**
	 * Return true if the movable object can move to Position
	 */
	boolean canMove(Position position);
}
