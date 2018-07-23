package com.github.yboug.business.enums;


import com.github.yboug.exceptions.ParsingException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * OrientationEnum define orientation of movable N 1 W 4 E 2 S 3
 * 
 * @author Youness
 *
 */
@Getter
@AllArgsConstructor
public enum OrientationEnum {

	NORTH(1), EAST(2), SOUTH(3), WEST(4);

	private int type;

	public static OrientationEnum parseOrientation(String c)
			throws ParsingException {
		for (OrientationEnum cmd : values()) {
			if (cmd.toString().substring(0, 1).equals(c)) {
				return cmd;
			}
		}
		throw new ParsingException("Parse orientation error: " + c);
	}

}
