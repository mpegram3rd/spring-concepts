package com.example.demo;

import com.example.demo.cars.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main application class for the Spring Boot application.
 * It uses dependency injection to get an instance of a Car implementation
 * and runs the application logic.
 */
@SpringBootApplication
public class SpringConceptsApplication implements CommandLineRunner {

	private final Car car;

	/**
	 * Constructor for the application indicates it needs a Car implementation.
	 * @param car
	 *  An instance of a class that implements the Car interface.
	 */
	@Autowired   // Tells spring to inject a class that implements the Car interface into this applcication
	public SpringConceptsApplication(Car car) {
		this.car = car;
	}

	// Initializes Spring Boot which goes out and figures out what classes are available and does the depenndency injection
	/**
	 * The main method is the entry point of the Spring Boot application.
	 * It initializes the application context and starts the application.
	 *
	 * @param args
	 *   Command line arguments (not used in this example)
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringConceptsApplication.class, args);
	}

	// This is the method that really runs the code.
	/**
	 * This method is called after the application context is loaded. (IE: Dependency Injection is done)
	 * It contains the main logic of the application.
	 *
	 * @param args
	 *   Command line arguments (not used in this example)
	 */
	public void run(String... args) throws Exception {

		// Revs the engine the given number of RPMs
		// The return "boolean" result indicates if the car is ok or if the engine blew up.
		boolean didItGoBoom = car.revEngine(1000);

		// If it didn't go boom, you can still put on the brakes
		if (!didItGoBoom) {
			car.putOnBrakes();
		}
	}
}
