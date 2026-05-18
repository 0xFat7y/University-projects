package com.mycompany.crystalpalacehotel;

public class Bill extends Booking {

    private int nights, bill, price;

    public Bill(int nights, int type, int numberOfRooms) {
        super(type, numberOfRooms);
        this.nights = nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public int getNights() {
        return nights;
    }

    public int totalBill(int serviceBill, int RoomCost) {

        int totalBill = serviceBill + RoomCost * nights;

        return totalBill;
    }

}
