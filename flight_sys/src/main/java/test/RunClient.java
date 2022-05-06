package test;

import com.opencsv.CSVWriter;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.List;

public class RunClient {

    public static List<Passenger> passenger_list = new ArrayList<>();
    public static List<Integer> price_list = new ArrayList<>();
    public static List<String> flight_number_list = new ArrayList<>();
    public static List<String> category_list = new ArrayList<>();
    public static List<Integer> seat_list = new ArrayList<>();

    public static void main(String[] args) {


        read_Sample_csv();

        // To show the output on terminal
        System.out.println("Booking Name | flight Number | Category | Number of seat | Total Price");
        for(int i=0 ; i < passenger_list.size(); i++)
        {
            System.out.printf("%s,%s,%s,%d,%4d", passenger_list.get(i).getBooking_name(),
                    flight_number_list.get(i), category_list.get(i), seat_list.get(i),
                    price_list.get(i));
            System.out.println();
        }

        //--------------------------------------------------------------------------
        // for saving the output
        //save_output_as_txt();
        save_output_as_csv();
    }


    public static void read_Sample_csv()
    {
        String file_name = "C:\\Users\\ray\\Desktop\\flight_sys\\src\\main\\resources\\Sample.csv";
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file_name));
            line = reader.readLine();
            while((line = reader.readLine())!= null){

                String[] row = line.split(",");
                double in_double_datatype = Double.parseDouble(row[4]);
                String credit_card_number =  remove_E_notation(in_double_datatype);
                Passenger temp = new Passenger(row[0], credit_card_number);
                if((temp.getCredit_card_type()) != null &&
                        (FlightService.find_flight(row[1])) != null)
                {
                    passenger_list.add(temp);
                    price_list.add(FlightService.get_total_price(row[1], row[2], Integer.parseInt(row[3])));
                    flight_number_list.add(row[1]);
                    category_list.add(row[2]);
                    seat_list.add(Integer.parseInt(row[3]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String remove_E_notation(double value)
    {
        DecimalFormat formatter;

        if(value - (int)value > 0.0)
            formatter = new DecimalFormat("0");
        else
            formatter = new DecimalFormat("0.0");

        return formatter.format(value);
    }

    public static void save_output_as_txt()
    {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\ray\\Desktop\\flight_sys\\src\\main\\resources\\Output.txt");

            myWriter.write("Booking Name,flight Number,Category,Number of seat,Total Price\n");
            for(int i=0 ; i < passenger_list.size(); i++)
            {
                myWriter.write(passenger_list.get(i).getBooking_name()+","+
                        flight_number_list.get(i)+","+category_list.get(i)+","+seat_list.get(i)+","+
                        price_list.get(i));
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void save_output_as_csv()
    {
        File file = new File("C:\\Users\\ray\\Desktop\\flight_sys\\src\\main\\resources\\Output.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = {"Booking Name","flight Number","Category","Number of seat","Total Price"};
            writer.writeNext(header);

            // add data to csv
            String[] data1 = { passenger_list.get(0).getBooking_name(), flight_number_list.get(0), category_list.get(0),
                    (seat_list.get(0)).toString(),(price_list.get(0)).toString()};
            writer.writeNext(data1);

            String[] data2 = { passenger_list.get(1).getBooking_name(), flight_number_list.get(1), category_list.get(1),
                    (seat_list.get(1)).toString(),(price_list.get(1)).toString()};
            writer.writeNext(data2);

            String[] data3 = { passenger_list.get(2).getBooking_name(), flight_number_list.get(2), category_list.get(2),
                    (seat_list.get(2)).toString(),(price_list.get(2)).toString()};
            writer.writeNext(data3);
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

