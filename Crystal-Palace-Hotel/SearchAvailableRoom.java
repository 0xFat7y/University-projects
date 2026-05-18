package com.mycompany.crystalpalacehotel;
public class SearchAvailableRoom {

    private int typeRoom, roomNumber;

    public SearchAvailableRoom(int typeRoom) {
        this.typeRoom = typeRoom;

    }

    public int getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(int typeRoom) {
        this.typeRoom = typeRoom;
    }

    public void getRoomNumber(int typeRoom, int numberOfRooms) {

        if (numberOfRooms > 3) {
            System.out.println("[The maximum number of room you can register is 3]");

        } else if (typeRoom > 3 || typeRoom < 1) {
            System.out.println("[Invalid number]");
        } else {

            switch (typeRoom) {
                case 1:
                    roomNumber = 100 * typeRoom + numberOfRooms;
                    System.out.println("[There is available room , your room number is " + roomNumber + "]");

                    break;
                case 2:
                    roomNumber = 100 * typeRoom + numberOfRooms;
                    System.out.println("[There is available room , your room number is" + roomNumber + "]");
                    break;
                case 3:
                    roomNumber = 100 * typeRoom + numberOfRooms;
                    System.out.println("[There is an available room , your room number is " + roomNumber + "]");
                    break;
                default:
                    System.out.println("[Error choose number from choices]");

            }

        }
    }

    public int getRoomNumber() {
        return roomNumber;
    }

}