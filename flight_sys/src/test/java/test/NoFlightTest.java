package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static test.NoFlight.getFlight;

class NoFlightTest {
    // BeforeAll must be static
    @BeforeAll
    public static void setupAll() {
        System.out.println("This test is built for testing null object pattern.");
    }

    @Test
    public void shouldCreateFlight() {
        assertNull(getFlight("AK470"));
        assertNotNull(getFlight("SJ456"));
    }
}