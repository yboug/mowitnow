package com.github.yboug.business.api;

import com.github.yboug.business.domain.Context;
import com.github.yboug.business.domain.Mower;
import com.github.yboug.exceptions.EngineException;

import java.util.List;

/**
 * a Mower rider
 *
 * @author Youness
 *
 */

public interface MowerRider {

    List<Mower> run(Context context) throws EngineException;
}
