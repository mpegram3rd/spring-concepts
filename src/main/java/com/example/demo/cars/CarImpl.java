package com.example.demo.cars;

import com.example.demo.engines.Engine;
import com.example.demo.exceptions.EngineGoBoomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is an implementation of the Car interface.
 * It uses an Engine to do its work, but it doesn't know what type of engine it has.
 * The type of engine is injected by Spring at runtime.
 */
@Component  // This indicates that it is a "Bean" that Spring could use to inject into other things
public class CarImpl implements Car {

    private final Engine carEngine;

    // This tells Spring to look for an implementation of the "Engine" interface
    // which is a "dependency" this class has and inject the implementation it finds
    // Dependency Injection happens here.
    @Autowired
    public CarImpl(Engine carEngine) {
        this.carEngine = carEngine;
    }

    /**
     * Do the things a car does when its engine is revved.
     * How the engine actually behaves will depend on WHICH engine is injected by Spring into the CarImpl class.
     * Revs the engine of the car up to the given number of RPMs
     *
     * @param rpms
     *   The number of RPMs to rev the engine to
     * @return boolean indicating if the car is ok (true) or if the engine blew up (false)
     */
    @Override
    public boolean revEngine(int rpms) {

        // Notice this is just working with an interface.
        // It doesn't know anything about what type of engine is being used.
        // If you changed the type of "engine" that is "injected," this code would still work,
        // and it wouldn't know the difference.
        try {
            System.out.println(carEngine.revUp(rpms));

            // Only bother to rev down if the RPMS are above a certain threshold.
            if (rpms > 90) {
                System.out.println(carEngine.revDown());
            }
        }
        catch (EngineGoBoomException ex)
        {
            System.out.println("Bad news! The engine blew up!");
            return false; // Indicates that the engine blew up
        }
        return true;  // Indicates that the engine is still ok
    }

    /**
     * Do the things a car does when its brakes are put on.
     * This doesn't depend on an engine, so it simply just does the same thing all the time.
     */
    @Override
    public void putOnBrakes() {
        System.out.println("skirch");
    }
}
