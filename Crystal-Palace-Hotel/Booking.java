package com.mycompany.crystalpalacehotel;
public class Booking {

    public int type, numberOfRooms;

    public Booking(int type, int numberOfRooms) {
        this.type = type;
        this.numberOfRooms = numberOfRooms;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}