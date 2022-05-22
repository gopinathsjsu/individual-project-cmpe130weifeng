package test;

public class Flight {

    private String seat_category;
    private String flight_number;
    private int available_seats;
    private int price;  // price of seat
    private String arrival_city;
    private String departure_city;

    public Flight() {
        //super();
    }

    public Flight(String seat_category, String flight_number,
                  int available_seats, int price,
                  String arrival_city, String departure_city) {
        this.seat_category = seat_category;
        this.flight_number = flight_number;
        this.available_seats = available_seats;
        this.price = price;
        this.arrival_city = arrival_city;
        this.departure_city = departure_city;
    }

    public String getSeat_category() {
        return seat_category;
    }

    public void setSeat_category(String seat_category) {
        this.seat_category = seat_category;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "seat_category='" + seat_category + '\'' +
                ", flight_number='" + flight_number + '\'' +
                ", available_seats=" + available_seats +
                ", price=" + price +
                ", arrival_city='" + arrival_city + '\'' +
                ", departure_city='" + departure_city + '\'' +
                '}';
    }

}
