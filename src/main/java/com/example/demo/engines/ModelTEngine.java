package com.example.demo.engines;

import com.example.demo.exceptions.EngineGoBoomException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * This is an implementation that simulates a Model T engine.
 */
@Primary // This tells Spring that if there are multiple implementations of the Engine interface, this is the one to use by default
 @Component // This indicates that it is a "Bean" that Spring could use to inject into other things
public class ModelTEngine implements Engine {
    /**
     * The sound the engine makes when it is revved up
     */
    @Override
    public String revUp(int rpms) {

        if (rpms > 100) {
            throw new EngineGoBoomException("The engine blew up! Good thing it was a cheap engine!");
        }
        return "Putt    Putt   Putt Putt PuttPuttPutt";
    }

    /**
     * The sound the engine makes when it is revved down
     */
    @Override
    public String revDown() {
        return "PuttPuttPutt Putt Putt   Putt        Putt  spshhhhhh";
    }
}
