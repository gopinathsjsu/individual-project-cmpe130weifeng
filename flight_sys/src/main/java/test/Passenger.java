package test;

public class Passenger {

    private String booking_name; //Person's name
    private String credit_card_number;
    private String credit_card_type;

    public Passenger(){
        //super();
    }

    public Passenger(String booking_name, String credit_card_number) {
        this.booking_name = booking_name;
        this.credit_card_number = credit_card_number;
    }

    public String getBooking_name() {
        return booking_name;
    }

//    public void setBooking_name(String booking_name) {
//        this.booking_name = booking_name;
//    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

//    public void setCredit_card_number(String credit_card_number) {
//        this.credit_card_number = credit_card_number;
//    }

    private void setCreditCardType() {
        String card_number = getCredit_card_number();
        int first_digit = Integer.parseInt(card_number.substring(0, 1));
        int two_digits = Integer.parseInt(card_number.substring(0, 2));
        int three_digits = Integer.parseInt(card_number.substring(0, 3));
        int four_digits = Integer.parseInt(card_number.substring(0, 4));
        int six_digits = Integer.parseInt(card_number.substring(0, 6));

        int length = card_number.length();

        if (first_digit == 4) {
            if (length == 13 || length == 16) {
                this.credit_card_type = "Visa";
            }
        }
        if (two_digits == 34 || two_digits == 37) {
            if (length == 15) {
                this.credit_card_type =  "American Express";
            }
        }
        if (four_digits == 6011
                || (six_digits >= 622126 && six_digits <= 622925)
                || (three_digits >= 644 && three_digits <= 649)
                || two_digits == 65) {
            if (length == 16) {
                this.credit_card_type =  "Discover";
            }
        }
        if (two_digits >= 51 && two_digits <= 55) {
            if (length == 16) {
                this.credit_card_type = "MasterCard";
            }
        }
    }

    public String getCredit_card_type() {
        setCreditCardType();
        return credit_card_type;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "booking_name='" + booking_name + '\'' +
                ", credit_card_type='" + credit_card_type + '\'' +
                '}';
    }
}
