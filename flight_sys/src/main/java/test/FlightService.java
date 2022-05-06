package test;

import test.Flight;

import java.util.LinkedList;
import java.util.List;

// the class for booking and other related services
public class FlightService {

    private static List<Flight> all_flights = new LinkedList<>();

    // run automatically; behaves like a static database
    static {
        all_flights.add(new Flight("Economy", "SJ456",
                5, 250, "Seattle", "San Jose"));
        all_flights.add(new Flight("Premium Economy", "BY110",
                5, 500, "San Francisco", "New York"));
        all_flights.add(new Flight("Business", "BY110",
                5, 2000, "San Francisco", "New York"));
        all_flights.add(new Flight("Economy", "CA453",
                5, 300, "Seattle", "San Jose"));
        all_flights.add(new Flight("Business", "CA453",
                5, 1500, "Seattle", "San Jose"));
    }

    // find the target flight based on flight number
    public static Flight find_flight(String target)
    {
        Flight temp = null;
        for(Flight fight: all_flights)
        {
            if(fight.getFlight_number().equals(target))
            {
                temp = fight;
                break;
            }
        }
        return temp;
    }

    // find the cities based on given flight number
    public static void find_cities(String flightNumber)
    {
        Flight temp = find_flight(flightNumber);
        if(temp != null) {
            System.out.println("Arrival city:" + temp.getArrival_city());
            System.out.println("Departure city:" + temp.getDeparture_city());
        }else
        {
            System.out.println("Not a valid flight number.");
        }
    }

    public static int get_total_price(String flight_number, String seatCategory,
                                      int number_of_seats)
    {
        int totalFare = 0;
        for(Flight flight: all_flights)
        {
            if((flight.getFlight_number().equals(flight_number)) &&
                    (flight.getSeat_category().equals(seatCategory))
                    &&(flight.getAvailable_seats() >= number_of_seats))
            {
                //
                totalFare = flight.getPrice() * number_of_seats;
                // subtract the number of seats that are being booked,
                // from the actual available tickets.
                flight.setAvailable_seats(flight.getAvailable_seats() - number_of_seats);
            }
        }

        return totalFare;
    }

    /*
    // find available flights based on cities info
    public static void search_by_cities(String arrival_city, String departure_city,
                                             int number_of_seats)
    {
        List<Flight> flight_list = new LinkedList<>();
        for(Flight flight: all_flights)
        {
            if(flight.getArrival_city().equals(arrival_city) && flight.getDeparture_city().equals(departure_city)
                    && flight.getAvailable_seats() > number_of_seats)
            {
                flight_list.add(flight);
            }
        }

        if(flight_list.size() == 0)
        {
            System.out.println("No matching Flights found.");
        }else
        {
            System.out.println("Flight number | Arrival city | Departure city | Available seats | Price of Seat");
            for(Flight flight: flight_list) {
                System.out.printf("%s\t%s\t\t%s%4d\t%5d\n", flight.getFlight_number(),
                        flight.getArrival_city(), flight.getDeparture_city(),
                        flight.getAvailable_seats(), flight.getPrice());
            }
        }
    }*/

}
