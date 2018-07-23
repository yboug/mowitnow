package com.github.yboug.business.domain;


import com.github.yboug.business.enums.DirectionEnum;
import com.github.yboug.business.enums.OrientationEnum;
import com.github.yboug.exceptions.ParsingException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Position represent a position of movable and offer some method of moving to
 * next position
 *
 * @author Youness
 */
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Position {

    private int x;
    private int y;

    /**
     * Return the next position after moving
     *
     * @param direction
     * @param orientation
     */
    public void next(DirectionEnum direction, OrientationEnum orientation) {

        if (direction == null) {
            throw new IllegalArgumentException("Unknown direction: ");
        }
        if (orientation == null) {
            throw new IllegalArgumentException("Unknown orientation: ");
        }
        switch (orientation.getType()) {
            case 1:
                y = y + direction.getType();
                break;
            case 2:
                x = x + direction.getType();
                break;
            case 3:
                y = y - direction.getType();
                break;
            case 4:
                x = x - direction.getType();
                break;
        }
    }

    /**
     * Return Position from String (5 5)
     *
     * @throws ParsingException
     */
    public static Position parsePositionFromString(String line)
            throws ParsingException {

        Pattern paternPositionMatcher = Pattern.compile("^(\\d+)[ ](\\d+)$");
        Matcher m = paternPositionMatcher.matcher(line);
        if (m.matches()) {
            return Position.builder()
                    .x(Integer.parseInt(m.group(1)))
                    .y(Integer.parseInt(m.group(2)))
                    .build();
        }
        throw new ParsingException("Parsing position error of line :" + line);
    }

}
