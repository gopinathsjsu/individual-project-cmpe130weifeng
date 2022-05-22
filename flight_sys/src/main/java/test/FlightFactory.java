package test;

import test.Flight;

// a Factory to generate object of concrete class
// based on seat category and flight number
public class FlightFactory {

    public Flight getFlight(String seat_category, String flight_num)
    {
        if(seat_category == null || flight_num == null)
            return null;
        // SJ456
        if((seat_category.equalsIgnoreCase("Economy")) &&
                (flight_num.equalsIgnoreCase("SJ456")))
        {
            return new Flight("Economy", "SJ456",
                    5, 250, "Seattle", "San Jose");
        }
        // BY110
        if((seat_category.equalsIgnoreCase("Premium Economy")) &&
                (flight_num.equalsIgnoreCase("BY110")))
        {
            return new Flight("Premium Economy", "BY110",
                    5, 500, "San Francisco", "New York");
        }
        if((seat_category.equalsIgnoreCase("Business")) &&
                (flight_num.equalsIgnoreCase("BY110")))
        {
            return new Flight("Business", "BY110",
                    5, 2000, "San Francisco", "New York");
        }
        // CA453
        if((seat_category.equalsIgnoreCase("Economy")) &&
                (flight_num.equalsIgnoreCase("CA453"))) {
            return new Flight("Economy", "SJ456",
                    5, 300, "Seattle", "San Jose");
        }
        if((seat_category.equalsIgnoreCase("Business")) &&
                (flight_num.equalsIgnoreCase("CA453"))) {
            return new Flight("Economy", "SJ456",
                    5, 1500, "Seattle", "San Jose");
        }
        return null;
    }
}
