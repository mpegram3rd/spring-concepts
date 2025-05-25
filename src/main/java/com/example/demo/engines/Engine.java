package com.example.demo.engines;

import com.example.demo.exceptions.EngineGoBoomException;

/**
 * The behaviors of a car engine
 */
public interface Engine {

    /**
     * The sound the engine makes when it is revved up
     * @param rpms the number of revolutions per minute to rev the engine
     */
    String revUp(int rpms) throws EngineGoBoomException;

    /**
     * The sound the engine makes when it is revved down
     */
    String revDown();
}
