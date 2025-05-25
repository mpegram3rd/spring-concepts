package com.example.demo.exceptions;

/**
 * This exception is thrown when the engine of a car goes boom.
 * It extends RuntimeException, meaning it is an unchecked exception.
 */
public class EngineGoBoomException extends RuntimeException {

    /**
     * Constructs a new EngineGoBoomException with the specified detail message.
     *
     * @param message the detail message
     */
    public EngineGoBoomException(String message) {
        super(message);
    }

    /**
     * Constructs a new EngineGoBoomException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public EngineGoBoomException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new EngineGoBoomException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the cause of the exception
     */
    public EngineGoBoomException(String message, Throwable cause) {
        super(message, cause);
    }
}
