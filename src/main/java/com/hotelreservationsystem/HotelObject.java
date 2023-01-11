package com.hotelreservationsystem;

public class HotelObject {
    public String hotelName;
    public int rate_regular;
    public HotelObject(String hotelName, int rate_regular) {
        this.hotelName = hotelName;
        this.rate_regular = rate_regular;
    }

    public HotelObject(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "Hotel Object "+hotelName+" created";
    }

    public void display() {

        System.out.println("------------------------------------------------------");
        System.out.println("Hotel Name: "+hotelName);
        System.out.println("Regular Rate: "+rate_regular);
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRate_regular() {
        return rate_regular;
    }

    public void setRate_regular(int rate_regular) {
        this.rate_regular = rate_regular;
    }
}