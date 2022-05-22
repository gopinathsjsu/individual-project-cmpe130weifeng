package test;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerBuilderTest {

    @Test
    public void should_getPassenger() {

        PassengerBuilder b = new PassengerBuilder();
        Assert.assertNotNull(b.getPassenger());
    }
}