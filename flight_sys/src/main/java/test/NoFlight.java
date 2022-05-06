package test;

// Null object class to get either real or null object based on flight number
public class NoFlight {

    public static final String[] flight_numbers = {"SJ456", "BY110", "CA453"};

    public static Flight getFlight(String num){

        for (int i = 0; i < flight_numbers.length; i++) {
            if (flight_numbers[i].equalsIgnoreCase(num)){
                return new Flight();
            }
        }
        return null;
    }
}
