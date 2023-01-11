package com.hotelreservationsystem;

public class HotelObject {
    public String hotelName;
    public int rateWeekdayRegular;
    public int rateWeekendRegular;
    public int totalBill=0;
    public HotelObject(String hotelName, int rate_regular) {
        this.hotelName = hotelName;
        this.rateWeekdayRegular = rate_regular;
    }

    public HotelObject(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "Hotel Object "+hotelName+" created";
    }

    public void setWeekendRates(int rateWeekend) {
        this.rateWeekendRegular=rateWeekend;
        System.out.println("Weekend Rates Updated");
    }

    public void display() {

        System.out.println("------------------------------------------------------");
        System.out.println("Hotel Name: "+hotelName);
        System.out.println("Regular Weekday Rate: "+rateWeekdayRegular);
        System.out.println("Regular Weekend Rate: "+rateWeekendRegular);
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getrateWeekdayRegular() {
        return rateWeekdayRegular;
    }

    public void setrateWeekdayRegular(int rate_regular) {
            this.rateWeekdayRegular = rate_regular;
    }

    public int getTotalBill() {
        return totalBill;
    }
}