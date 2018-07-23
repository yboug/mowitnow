package com.github.yboug.business.domain;

import com.github.yboug.business.api.Engine;
import com.github.yboug.business.api.MovableElement;
import com.github.yboug.business.enums.DirectionEnum;
import com.github.yboug.business.enums.RotationEnum;
import com.github.yboug.exceptions.EngineException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 * Mower is movable element
 *
 * @author Youness
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@Log
public class Mower implements MovableElement, Engine {

    private int id;
    private Position currentPosition;
    private Orientation currentOrientation;
    private boolean engineStarted;

    @Override
    public Position computeNextPosition(DirectionEnum direction){

        Position position = Position.builder()
                .x(currentPosition.getX())
                .y(currentPosition.getY())
                .build();
        position.next(direction, this.currentOrientation
                        .getOrientationEnum());
        return position;
    }

    public void move(DirectionEnum direction) throws EngineException {
        if (!isStarted()) {
            throw new EngineException("Engine not started");

        }
        currentPosition.next(direction, currentOrientation
                .getOrientationEnum());
    }

    public void rotate(RotationEnum rotation) {
        currentOrientation = currentOrientation.rotate(rotation);
    }

    public void start() throws EngineException {
        if (isStarted()) {
            throw new EngineException("Engine already started");
        }
        engineStarted = true;
        log.info("Engine Started ok");
    }

    public void stop() throws EngineException {
        if (!isStarted()) {
            throw new EngineException("Engine already stopped");
        }
        engineStarted = false;
        log.info("Engine Stopped ok");
    }

    public boolean isStarted() {
        return engineStarted;
    }

}
