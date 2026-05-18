package com.mycompany.crystalpalacehotel;

import java.util.Scanner;

public class CrystalPalaceHotel {

    public static void main(String[] args) {
        System.out.println("[Welcome To Crystal Palace Hotel]\n");
        Scanner input = new Scanner(System.in);
        //Sign up codes
        System.out.println("[let's create a new account]");
        System.out.println("\n[Enter your username]");
        String u = input.next().toLowerCase();//u is the username
        System.out.println("[Enter your phone number]");
        int p = input.nextInt();//p is the phone number
        System.out.println("[Enter your email]");
        String e = input.next().toLowerCase();//e the is email    
        System.out.println("[Create your password]");
        String a = input.next().toLowerCase();//a is the password
        System.out.println("\n[Your account is created successfully, let's login]");
        LogIn L1 = new LogIn(u, a, e, p);
        System.out.println("\n[Enter your username]");
        String u1 = input.next().toLowerCase();// u1 is the username confirmation
        System.out.println("[Enter your password]");
        String a1 = input.next().toLowerCase();//a1 is the password confirmation
        if (u1.equals(u) && a1.equals(a)) {
            System.out.println("[Welcome " + L1.UserName() + "]");
            //Start Booking
            System.out.println("\n[Welcome to the booking system]\n");
            System.out.println("[How many rooms do you want ?]");
            //number of the rooms
            int n = input.nextInt();
            int t = 0;
            if (n >= 1 && n < 4) {
                int i;
                System.out.println("[how many nights do you want to spend?]");
                int nights = input.nextInt();
                int x = 0;
                if (nights > 0) {
                    for (i = 1; i <= n; i++) {
                        while (true) {
                            System.out.println("[What is the type of the room number] " + i + "?\n1-Single\n2-Double\n3-Suite");
                            t = input.nextInt();
                            if (t >= 1 && t <= 3) {
                                break;
                            } else {
                                System.out.println("[Invalid number, please try again]");
                            }
                        }
                        System.out.println("\n[Wait a minute , I will search for an available room]\n.....\n.....");
                        SearchAvailableRoom s1 = new SearchAvailableRoom(t);
                        s1.getRoomNumber(t, i);
                        switch (t) {
                            case 1:
                                x = 1500 + x;//x is the room fee
                                break;
                            case 2:
                                x = 3000 + x;
                                break;
                            case 3:
                                x = 4500 + x;
                                break;
                            default:
                                break;
                        }
                    }
                    System.out.println("\n[Welcome To our Service]\n");
                    System.out.println("[Do you want a breakfast ?]\n1-Yes \n2-No");
                    int b = input.nextInt();
                    if (b < 1 || b > 2) {
                        System.out.println("[Error invalid number this service won't be added]\n");
                        b = 2;
                    }
                    System.out.println("[Do you want a lunch ?]\n1-Yes\n2-No");
                    int l = input.nextInt();
                    if (l < 1 || l > 2) {
                        System.out.println("[Error invalid number this service won't be added]\n");
                        l = 2;
                    }
                    System.out.println("[Do you want a dinner ?]\n1.Yes\n2.No");
                    int d = input.nextInt();
                    if (d < 1 || d > 2) {
                        System.out.println("[Error invalid number this service won't be added]\n");
                        d = 2;
                    }
                    System.out.println("[Do you want housekeeping ?]\n1.Yes\n2.No");
                    int h = input.nextInt();
                    if (h < 1 || h > 2) {
                        System.out.println("[Error invalid number this service won't be added]");
                        h = 2;
                    }
                    Service s2 = new Service(b, l, d, h);
                    System.out.println("[What do you want to do?]\n1-Check in \n2-Cancel booking");
                    int w = input.nextInt();
                    if (w == 1 || w == 2) {
                        switch (w) {
                            case 1:
                                System.out.println("[Welcome to check in]\n[Your informations:]\n[Username] " + L1.UserName());
                                System.out.println("[Phone number] 0" + L1.phoneNumber() + "\n[Email] " + L1.Email() + "\n[Number of rooms] " + n);
                                break;
                            case 2:
                                System.out.println("[Your booking is cancelled succesfully]");
                                break;
                        }

                        //Check out
                        System.out.println("[Welcome to checkout system]");
                        Bill b1 = new Bill(nights, t, n);
                        System.out.println("[you have spent " + b1.getNights() + " days in our hotel]\n[your total bill] " + b1.totalBill(s2.totalservicebill(), x));
                        System.out.println("Before you leave, please enter your feedback");

                        System.out.println("Enter Food Rate from one to five");
                        int m = input.nextInt();
                        System.out.println("Enter Housekeeping rate from one to five");
                        int q = input.nextInt();
                        System.out.println("Enter Service rate from one to five");
                        int r = input.nextInt();

                        Rate r1 = new Rate(m, q, r);
                        if (r1.getRate() > 0 && r1.getRate() <= 5) {
                            System.out.println("Your Rate is " + r1.getRate() + "/5");
                        }
                        System.out.println("\n\n[Thanks for choosing our hotel. We look forward to welcoming you again soon.]\n\nStaySafe!");

                    } else {

                        System.out.println("[Error invalid number]");
                    }
                } else {

                    System.out.println("[Error invalid number]");
                }

            } else if (n > 3) {
                System.out.println("[Sorry the maxiumum number of rooms you can book is 3]");
            } else {
                System.out.println("[Please enter a positive value]");
            }
        } else {
            System.out.println("[Error wrong username or password]");

        }
    }
}
