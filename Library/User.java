package com.mycompany.datastructureproject;

public class User {

    private int userId;
    private String name;
    private String email;
    private String phone;
    private String role; // Reader, Librarian, Admin

    public User(int userId, String name, String email, String phone, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getRole() { return role; }

    public void displayUserInfo() {
        System.out.println("User ID: " + userId + " | Name: " + name + " | Email: " + email + " | Phone: " + phone + " | Role: " + role);
    }
}

// LinkedQueue for Users
class LinkedQueue {
    private class Node {
        User data;
        Node next;

        Node(User data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(User user) {
        if (user == null) return;
        Node newNode = new Node(user);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    public User[] toArray() {
    int count = 0;
    Node temp = front;
    while (temp != null) {
        count++;
        temp = temp.next;
    }

    User[] arr = new User[count];
    temp = front;
    int i = 0;
    while (temp != null) {
        arr[i++] = temp.data;
        temp = temp.next;
    }
    return arr;
}

    public User dequeue() {
        if (isEmpty()) return null;
        User u = front.data;
        front = front.next;
        if (front == null) rear = null;
        return u;
    }

    public void displayQueue() {
        Node current = front;
        System.out.println("\n--- User Queue ---");
        while (current != null) {
            current.data.displayUserInfo();
            current = current.next;
        }
    }

    public User search(int userId, String email) {
        Node current = front;
        while (current != null) {
            if (current.data.getUserId() == userId && current.data.getEmail().equals(email)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
}
