package com.github.yboug.app.runner;

import com.github.yboug.business.api.MowerRider;
import com.github.yboug.business.domain.Context;
import com.github.yboug.business.domain.Lawn;
import com.github.yboug.business.domain.Mower;
import com.github.yboug.business.domain.MowerCommand;
import com.github.yboug.business.enums.DirectionEnum;
import com.github.yboug.business.enums.RotationEnum;
import com.github.yboug.exceptions.EngineException;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.util.*;

@Log
@AllArgsConstructor
public class MowerRiderImpl implements MowerRider {

    @Override
    public List<Mower> run(Context context) throws EngineException {
        Map<Mower, List<MowerCommand>> mowers = context.getMowers();
        startMowers(mowers);
        Lawn lawn = context.getLawn();
        mowers.forEach(
                (mower, mowerCommands) ->
                        mowerCommands.forEach(
                                (mowerCommand -> {
                                    switch (mowerCommand) {
                                        case FORWARD:
                                            if (lawn.canMove(mower.computeNextPosition(DirectionEnum.FORWARD))) {
                                                try {
                                                    mower.move(DirectionEnum.FORWARD);
                                                } catch (EngineException e) {
                                                    log.info(e.getMessage());
                                                }
                                            }
                                            break;
                                        case ROTATE_LEFT:
                                            mower.rotate(RotationEnum.LEFT);
                                            break;
                                        case ROTATE_RIGHT:
                                            mower.rotate(RotationEnum.RIGHT);
                                            break;
                                    }
                                })
                        )
        );
        return new ArrayList<>(mowers.keySet());
    }

    private void startMowers(Map<Mower, List<MowerCommand>> mowers) throws EngineException {
        for (Mower mower : mowers.keySet()) {
            mower.start();
        }
    }
}
