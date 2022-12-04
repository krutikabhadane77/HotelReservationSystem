package com.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
    private List<Hotel> hotelList=new ArrayList<Hotel>();
        public boolean addHotel(String hotelName,int regularCustomerRate){
            Hotel hotel=new Hotel(hotelName,regularCustomerRate);
            hotelList.add(hotel);
            return true;
        }

    public static void main(String[] args) {
        HotelReservation hotelReservation=new HotelReservation();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter hotel name : ");
        String hotelName=sc.next();
        System.out.println("Enter regular customer rate : ");
        int regularCustomerRate=sc.nextInt();
        hotelReservation.addHotel(hotelName,regularCustomerRate);
    }
}
