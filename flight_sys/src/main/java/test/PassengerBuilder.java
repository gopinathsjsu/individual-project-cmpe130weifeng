package test;

// the builder class to hold previous Passenger info,
// so that we can use it if we needed
public class PassengerBuilder {

    private String booking_name;
    private String credit_card_number;

    public PassengerBuilder setBooking_name(String booking_name) {
        this.booking_name = booking_name;
        return this;
    }

    public PassengerBuilder setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
        return this;
    }

    public Passenger getPassenger()
    {
        Passenger p = new Passenger(booking_name, credit_card_number);
        return p;
    }

}
