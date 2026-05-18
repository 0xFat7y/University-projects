package com.mycompany.datastructureproject;

import java.util.Scanner;

public class Registration {
    private static LinkedQueue userQueue = new LinkedQueue();
    private static StaffLinkedList staffList = new StaffLinkedList();

    static {
        staffList.add(new Staff(1, "Ahmed", "Manager",20000));
        staffList.add(new Staff(2, "Omar", "CEO", 15000));
        staffList.add(new Staff(3, "Khaled", "HR", 12000));
        staffList.add(new Staff(4, "Karem", "Employee", 8000));
        staffList.add(new Staff(5, "Mostafa", "Employee", 7000));
        staffList.add(new Staff(6, "Islam", "Employee", 6000));
        
        
    }
    public static User[] getAllUsers() {
    return userQueue.toArray();
}

    public static Staff[] getAllStaff() {
    return staffList.toArray();
}

    public static void registerUser(User user) { userQueue.enqueue(user); }

    public static User loginUser(int userId, String email) { return userQueue.search(userId, email); }

    public static Staff loginStaff(int id) { return staffList.search(id); }

    public static void showAllUsers() { userQueue.displayQueue(); }

    public static void showAllStaff() { staffList.print(); }
}
