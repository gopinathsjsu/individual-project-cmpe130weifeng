package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;
import static org.junit.Assert.*;

public class FlightFactoryTest {

    @Test
    public void should_get_null()
    {
        FlightFactory obj = new FlightFactory();
        Flight temp = obj.getFlight("","");
        Assert.assertNull(temp);
    }

    @Test
    public void should_get_SJ456()
    {
        FlightFactory obj = new FlightFactory();
        Flight temp = obj.getFlight("Economy","SJ456");
        Assert.assertEquals(5, temp.getAvailable_seats());
        Assert.assertEquals("Seattle", temp.getArrival_city());
        Assert.assertEquals("San Jose", temp.getDeparture_city());
        Assert.assertEquals(250, temp.getPrice());
    }

    @Test
    public void should_get_BY110_Preminum()
    {
        FlightFactory obj = new FlightFactory();
        Flight temp = obj.getFlight("Premium Economy","BY110");
        Assert.assertEquals(5, temp.getAvailable_seats());
        Assert.assertEquals("San Francisco", temp.getArrival_city());
        Assert.assertEquals("New York", temp.getDeparture_city());
        Assert.assertEquals(500, temp.getPrice());
    }

    @Test
    public void should_get_BY110_Business()
    {
        FlightFactory obj = new FlightFactory();
        Flight temp = obj.getFlight("Business","BY110");
        Assert.assertEquals(5, temp.getAvailable_seats());
        Assert.assertEquals("San Francisco", temp.getArrival_city());
        Assert.assertEquals("New York", temp.getDeparture_city());
        Assert.assertEquals(2000, temp.getPrice());
    }

    @Test
    public void should_get_CA453_Economy()
    {
        FlightFactory obj = new FlightFactory();
        Flight temp = obj.getFlight("Economy","CA453");
        Assert.assertEquals(5, temp.getAvailable_seats());
        Assert.assertEquals("Seattle", temp.getArrival_city());
        Assert.assertEquals("San Jose", temp.getDeparture_city());
        Assert.assertEquals(300, temp.getPrice());
    }

    @Test
    public void should_get_CA453_Business()
    {
        FlightFactory obj = new FlightFactory();
        Flight temp = obj.getFlight("Business","CA453");
        Assert.assertEquals(5, temp.getAvailable_seats());
        Assert.assertEquals("Seattle", temp.getArrival_city());
        Assert.assertEquals("San Jose", temp.getDeparture_city());
        Assert.assertEquals(1500, temp.getPrice());
    }

}