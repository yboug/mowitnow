package com.github.yboug.business.domain;


import com.github.yboug.business.api.Shape;
import com.github.yboug.business.api.ShapeLimit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Lawn is rectangular Shape with limit defined by topRight position
 * @author Youness
 *
 */
@Getter
@AllArgsConstructor
@Builder
public class Lawn implements Shape, ShapeLimit {

	private Position topRight;

	public boolean canMove(Position position) {
		return (position.getX() <= topRight.getX())
				&& ((position.getY() <= topRight.getY())
				&& (position.getX() >= 0)
				&& (position.getY() >= 0));
	}

}
