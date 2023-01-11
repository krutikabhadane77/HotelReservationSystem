package com.hotelreservationsystem;

public class Customer extends HotelObject{
    public String cust_type="regular";
    public int DaysStayed;
    public int bill;

    public Customer(String hotelName,int DaysStayed, int bill) {
        super(hotelName);
        this.DaysStayed=DaysStayed;
        this.bill = bill;
    }

    public void showBill() {

        System.out.println("Hotel Found: "+hotelName);
        System.out.println("Days Stayed: "+DaysStayed);
        System.out.println("Total Bill: "+bill);
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public int getDaysStayed() {
        return DaysStayed;
    }

    public void setDaysStayed(int daysStayed) {
        DaysStayed = daysStayed;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
}
