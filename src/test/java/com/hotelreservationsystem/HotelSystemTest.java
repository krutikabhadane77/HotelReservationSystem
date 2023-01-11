package com.hotelreservationsystem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HotelSystemTest {
    private HotelReservation hotelReservation;
    private Customer cust;

    @Before
    public void init() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 110,90,80,80,3);
        hotelReservation.addHotel("Bridgewood", 160,50,110,50,4);
        hotelReservation.addHotel("Ridgewood", 220,150,100,40,5);
    }

    @Test
    public void whenLakewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Lakewood",110,90,80,80,3));
    }

    @Test
    public void whenBridgewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Bridgewood", 160,50,110,50,4));
    }

    @Test
    public void whenRidgewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Ridgewood", 220,150,100,40,5));
    }

    @Test
    public void whenStayed1Day_CheapestHotelShouldBe_Lakewood()
    {
        cust=hotelReservation.findCheapestHotel("12.05.2020", "13.05.2020");
        assertEquals(110, cust.getBill());
    }

    @Test
    public void whenStayed1Day_CheapestHotelShouldCost_110()
    {
        cust=hotelReservation.findCheapestHotel("12.05.2020", "13.05.2020");
        assertEquals("Lakewood", cust.getHotelName());
    }

    @Test
    public void whenStayed1DayMaxRatedHotelShouldBeRidgeWood()
    {
        cust=hotelReservation.bestRatedHotel("12.05.2020", "13.05.2020");
        assertEquals("Ridgewood", cust.getHotelName());
    }
}