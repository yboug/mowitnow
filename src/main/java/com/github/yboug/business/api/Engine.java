package com.github.yboug.business.api;


import com.github.yboug.exceptions.EngineException;

/**
 * Engine of movable object for starting and stopping
 * 
 * @author Youness
 *
 */
public interface Engine {

	/**
	 * true if the engine Starting well
	 * @throws  EngineException
	 */
	void start() throws EngineException;

	/**
	 * true if the engine stopping well
	 * @throws EngineException
	 */
	void stop() throws EngineException;
	
	/**
	 * true if the engine is started
	 * @return boolean
	 */
	boolean isStarted();
}
