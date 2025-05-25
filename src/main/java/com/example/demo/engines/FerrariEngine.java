package com.example.demo.engines;

import com.example.demo.exceptions.EngineGoBoomException;
import org.springframework.stereotype.Component;

/**
 * This is an implementation that simulates a Ferrari engine.
 */
//@Primary // This tells Spring that if there are multiple implementations of the Engine interface, this is the one to use by default
@Component // This indicates that it is a "Bean" that Spring could use to inject into other things
public class FerrariEngine implements Engine {
    /**
     * The sound the engine makes when it is revved up
     */
    @Override
    public String revUp(int rpms) {

        // Yeah.. I checked: https://www.hagerty.com/media/news/ferrari-812-special-edition-revs-to-9500-rpm-belts-out-819-hp/
        if (rpms > 9500)
            throw new EngineGoBoomException("Ooops! That's going to be expensive! The engine blew up!");

        return "VaROOOOOOOOOOOOM";
    }

    /**
     * The sound the engine makes when it is revved down
     */
    @Override
    public String revDown() {
        return "ROOM ROOOOOM ROOOOOOOOOM rum rum rum";
    }
}
