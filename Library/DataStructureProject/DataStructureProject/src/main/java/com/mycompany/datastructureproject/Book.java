package com.mycompany.datastructureproject;

public class Book {
    private int id;
    private String name;
    private String author;
    private double cost;
    private boolean isAvailable; 

    public Book(int id, String name, String author, double cost, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.cost = cost;
        this.isAvailable = isAvailable;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String toString() {
        String status = isAvailable ? "Available" : "NOT Available";
        return "ID: " + id + " | Name: " + name + " | Author: " + author + " | Cost: $" + cost + " | Status: " + status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isAvailable() { return isAvailable; }
}
