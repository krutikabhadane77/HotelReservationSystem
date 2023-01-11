package com.hotelreservationsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<HotelObject> hotelList;

    public HotelReservation() {
        hotelList = new ArrayList<HotelObject>();
    }

    public void addToList(HotelObject hotel) {
        hotelList.add(hotel);
    }

    public boolean addHotel(String hotelName, int rateWeekdayRegular,int rateWeekendRegular,int rateWeekdayReward,int rateWeekendReward, int rating)  {

        HotelObject hotel = new HotelObject(hotelName,rateWeekdayRegular);
        hotel.setWeekendRates(rateWeekendRegular);
        hotel.addRewardRate(rateWeekdayReward,rateWeekendReward);
        hotel.addRating(rating);
        addToList(hotel);
        return true;
    }

    public void display() {
        for (HotelObject hotel : hotelList) {
            hotel.display();
        }
    }
    public Date[] stringDateConvereter(String start_date, String end_date) {
        try {
            Date dateArr[]=new Date[2];
            dateArr[0]= new SimpleDateFormat("DD.MM.yyyy").parse(start_date);
            dateArr[1]= new SimpleDateFormat("DD.MM.yyyy").parse(end_date);
            return dateArr;
        }catch(ParseException exception){
            exception.printStackTrace();
        }
        return null;
    }

    public int daysRented(Date startDate, Date endDate) {

        long time_diff = startDate.getTime() - endDate.getTime();
        return (int) (2+(time_diff / (1000 * 60 * 60 * 24)));
    }

    public int[] checkWeekdayWeekend(Date startDate, Date endDate) {

        int weekArr[] = {0,0};
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }else System.out.println("Incorrect format.");
        do {
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                weekArr[0]++;
            }else weekArr[1]++;
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());
        return weekArr;
    }

    public Customer bestRatedHotel(String type,String start_date, String end_date) {

        Customer cust=new Customer("", 0, 0);

        Date dateArr[]=stringDateConvereter(start_date, end_date);
        Date startDate= dateArr[0];
        Date endDate= dateArr[1];

        int daysStayed=daysRented(startDate, endDate);
        int noOfWeekdays=checkWeekdayWeekend(startDate, endDate)[0];
        int noOfWeekends=checkWeekdayWeekend(startDate, endDate)[1];
        for(HotelObject hotel: hotelList) {
            cust.setCustType(type, hotel);
            int totalBill = noOfWeekdays*cust.rateWeekday+noOfWeekends*cust.rateWeekend;
            cust.setCustType(type, hotel);
            hotel.totalBill=totalBill;
        }
        Optional<HotelObject> cheapestHotelOpt = hotelList.stream().max((Comparator
                .comparingInt(HotelObject::getRating))
        );

        HotelObject cheapestHotel = cheapestHotelOpt.get();
        cust.bill=cheapestHotel.totalBill;
        cust.setHotelName(cheapestHotel.hotelName);
        cust.setDaysStayed(daysStayed);

        return null;
    }


    public Customer findCheapestHotel(String type,String start_date, String end_date) {
        Customer cust=new Customer("", 0, 0);
        Date dateArr[]=stringDateConvereter(start_date, end_date);
        Date startDate= dateArr[0];
        Date endDate= dateArr[1];

        int daysStayed=daysRented(startDate, endDate);
        int noOfWeekdays=checkWeekdayWeekend(startDate, endDate)[0];
        int noOfWeekends=checkWeekdayWeekend(startDate, endDate)[1];

        for(HotelObject hotel: hotelList) {
            cust.setCustType(type, hotel);
            int totalBill = noOfWeekdays*cust.rateWeekday+noOfWeekends*cust.rateWeekend;
            cust.setCustType(type, hotel);
            hotel.totalBill=totalBill;
        }

        Optional<HotelObject> cheapestHotelOpt = hotelList.stream().min((Comparator.comparingInt(
                        HotelObject::getTotalBill)
                .thenComparing(HotelObject::getRating))
        );

        HotelObject cheapestHotel = cheapestHotelOpt.get();
        cust.bill=cheapestHotel.totalBill;
        cust.setHotelName(cheapestHotel.hotelName);
        cust.setDaysStayed(daysStayed);
        return cust;
    }


    public static void main(String[] args) {

        HotelReservation buildObj = new HotelReservation();
        buildObj.addHotel("Lakewood", 110,90,80,80,3);
        buildObj.addHotel("Bridgewood", 160,50,110,50,4);
        buildObj.addHotel("Ridgewood", 220,150,100,40,5);

        System.out.println( "Welcome to Hotel Reservation Program" );

        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();

        System.out.println("What do you want to do?");
        System.out.println("1. Add Hotel Entry.");
        System.out.println("2. Find Cheapest Hotel.");
        System.out.println("3. Find Best Rated Hotel.");
        String user_input=sc.next();

        //Initializing main program
        switch(user_input) {

            case "1": {
                System.out.println("Please add hotel.");
                System.out.println();
                System.out.print("Enter hotel name: ");
                String hotelName = sc.next();
                System.out.print("Enter regular rate of rooms: ");
                int rateWeekdayRegular = sc.nextInt();
                System.out.print("Enter Weekend rate of rooms: ");
                int rateWeekendRegular = sc.nextInt();
                System.out.print("Enter reward Weekday rate of rooms: ");
                int rateWeekdayReward = sc.nextInt();
                System.out.print("Enter reward Weekend rate of rooms: ");
                int rateWeekendReward = sc.nextInt();
                System.out.print("Enter Rating of Hotel: ");
                int rating = sc.nextInt();

                buildObj.addHotel(hotelName, rateWeekdayRegular, rateWeekendReward,rateWeekdayRegular,rateWeekendReward, rating);
                break;
            }
            case "2": {
                System.out.println("Please enter Customer Type-Reward/Regular");
                String type = sc.next().toLowerCase();
                System.out.println("Enter date range to find hotel in format(DD.MM.yyyy)");
                System.out.println("Enter Check-In date: ");
                String start_date = sc.next();
                System.out.println("Enter Check-Out date: ");
                String end_date = sc.next();
                Customer cust = buildObj.findCheapestHotel(type,start_date,end_date);

                cust.showBill();
                break;
            }
            case "3": {
                System.out.println("Please enter Customer Type-Reward/Regular");
                String type = sc.next().toLowerCase();
                System.out.println("Enter date range to find hotel in format(DD.MM.yyyy)");
                System.out.println("Enter Check-In date: ");
                String start_date = sc.next();
                System.out.println("Enter Check-Out date: ");
                String end_date = sc.next();
                Customer cust = buildObj.bestRatedHotel(type,start_date,end_date);

                cust.showBill();
                break;
            }
            default:
                System.out.println("Unknown input.");
        }
    }
}
