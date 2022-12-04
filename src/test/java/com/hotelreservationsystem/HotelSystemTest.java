package com.hotelreservationsystem;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HotelSystemTest {
    @Test
    public void hotelAddedShouldReturnTrue(){
        HotelReservation hotelReservation=new HotelReservation();
        boolean hotelAdded=hotelReservation.addHotel("Lakewood",110);
        assertTrue(hotelAdded);
    }
}
