package com.example.demo.cars;

/**
 * A car interface featuring things a car can generically do
 * HOW they get done is determined by the individual implementations
 */
public interface Car {

    /**
     * Revs the engine of the car up to the given number of RPMs
     * @param rpms
     *   The number of RPMs to rev the engine to
     * @return boolean indicating if the car is ok (true) or if the engine blew up (false)
     */
    boolean revEngine(int rpms);

    /**
     * Applies the brakes to the car
     */
    void putOnBrakes();

}
