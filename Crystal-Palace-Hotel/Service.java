package com.mycompany.crystalpalacehotel;
public class Service {

    private int breakfast, lunch, dinner, houseKeeping, b, l, d, h;

    public Service(int b, int l, int d, int h) {
        this.b = b;
        switch (b) {
            case 1:
                breakfast = 10;
                break;
            case 2:
                breakfast = 0;
                break;

        }
        switch (l) {
            case 1:
                lunch = 20;
                break;
            case 2:
                lunch = 0;
                break;

        }
        switch (d) {
            case 1:
                dinner = 15;
                break;
            case 2:
                dinner = 0;
                break;

        }
        switch (h) {
            case 1:
                houseKeeping = 15;
                break;
            case 2:
                houseKeeping = 0;
                break;

        }
    }

    public int totalservicebill() {
        return breakfast + lunch + dinner + houseKeeping;
    }
}