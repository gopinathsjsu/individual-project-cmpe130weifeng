package test;

import test.Flight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// the class for booking and other related services
public class FlightService {

    private static List<Flight> all_flights = new LinkedList<>();

    public static void storeDB(String file)
    {

        String file_name = file;
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file_name));
            line = reader.readLine();
            while((line = reader.readLine())!= null){

                String[] row = line.split(",");
                all_flights.add(new Flight(row[0],row[1], Integer.parseInt(row[2]),
                        Integer.parseInt(row[3]), row[4],row[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
