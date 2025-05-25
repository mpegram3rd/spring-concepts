package com.example.demo.cars;

import com.example.demo.engines.Engine;
import com.example.demo.exceptions.EngineGoBoomException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Ask me about this
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Unit tests for the CarImpl class.
 */
@ExtendWith(MockitoExtension.class)
public class CarImplTest {

    /**
     * This is a mock of the Engine interface.
     * It will be used to simulate the behavior of an engine implementation without needing a real implementation.
     */
    @Mock
    private Engine carEngine;

    /**
     * This is the class under test.
     * It will use the mocked Engine to perform its operations.
     * The @InjectMocks tells Mockito to inject the mock carEngine into this class.
     */
    @InjectMocks
    private CarImpl carImpl;

    /**
     * Verify that when given low RPMs the car does NOT rev down
     * This is because the car only revs down if the RPMS are above 90.
     */
    @Test // Tell the unit test engine this is a test method
    public void revEngine_LowRPMs_ShouldNotRevDown() {

        // Arrange
        int rpms = 50;
        // Mock the behavior of the carEngine
        when(carEngine.revUp(rpms)).thenReturn("Engine revved up to " + rpms + " RPMs");

        // Act
        boolean result = carImpl.revEngine(rpms);

        // Assert

        // Assert car engine did not blow up
        assertThat(result, equalTo(true)); // This is a traditional assert

        // These are BEHAVIORAL asserts using Mockito. They verify that the function used the mock in the expected way.
        // They assert that a certain method was called a certain number of times with specific parameters.

        // Verify that the revUp method was called with the correct RPMs
        verify(carEngine, times(1)).revUp(rpms);
        // Verify that the revDown method was NOT called because RPMS were too low
        verify(carEngine, never()).revDown();
    }

    /**
     * Verify that when given higher RPMs the car does a rev down.
     */
    @Test // Tell the unit test engine this is a test method
    public void revEngine_HighRPMs_ShouldRevDown() {

        // Arrange
        int rpms = 1000;
        // Mock the behavior of the carEngine
        when(carEngine.revUp(rpms)).thenReturn("Engine revved up to " + rpms + " RPMs");

        // Act
        boolean result = carImpl.revEngine(rpms);

        // Assert

        // Assert car engine did not blow up
        assertThat(result, equalTo(true));

        // These are BEHAVIORAL asserts using Mockito. They verify that the function used the mock in the expected way.
        // They assert that a certain method was called a certain number of times with specific parameters.

        // Verify that the revUp method was called with the correct RPMs
        verify(carEngine, times(1)).revUp(rpms);
        // Verify that the revDown method WAS called because RPMS were high enough
        verify(carEngine, times(1)).revDown();
    }

    /**
     * Verify that the revEngine method returns FALSE if the engine blows up.
     */
    @Test // Tell the unit test engine this is a test method
    public void revEngine_CarExplodes_ShouldReturnFalse() {

        // Arrange
        int rpms = 1000;
        // Mock the behavior of the carEngine. Mock throwing the EngineGoBoomException
        when(carEngine.revUp(rpms)).thenThrow(new EngineGoBoomException("Engine blew up!"));

        // Act
        boolean result = carImpl.revEngine(rpms);

        // Assert

        // Assert car engine did not blow up
        assertThat(result, equalTo(false));

        // These are BEHAVIORAL asserts using Mockito. They verify that the function used the mock in the expected way.
        // They assert that a certain method was called a certain number of times with specific parameters.

        // Verify that the revUp method was called with the correct RPMs
        verify(carEngine, times(1)).revUp(rpms);
        // Verify that the revDown method was NOT called because the engine blew up
        verify(carEngine, never()).revDown();
    }

}
