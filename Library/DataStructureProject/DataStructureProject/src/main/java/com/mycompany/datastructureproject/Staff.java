package com.mycompany.datastructureproject;

public class Staff {
    private int id;
    private String name;
    private String role;
    private double salary;

    public Staff(int id, String name, String role, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void increaseSalary(double amount) { this.salary += amount; }
    public void changeRole(String newRole) { this.role = newRole; }

    @Override
    public String toString() {
        return "Staff{id=" + id + ", name='" + name + "', role='" + role + "', salary=" + salary + "}";
    }
}

class StaffNode {
    Staff data;
    StaffNode next;

    public StaffNode(Staff data) { this.data = data; this.next = null; }
}

class StaffLinkedList {
    private StaffNode head;

    public StaffLinkedList() { head = null; }

    public void add(Staff s) {
        StaffNode newNode = new StaffNode(s);
        if (head == null) { head = newNode; return; }
        StaffNode current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    public void print() {
        if (head == null) { System.out.println("List is empty"); return; }
        StaffNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    public Staff[] toArray() {
    int count = 0;
    StaffNode temp = head;
    while (temp != null) {
        count++;
        temp = temp.next;
    }

    Staff[] arr = new Staff[count];
    temp = head;
    int i = 0;
    while (temp != null) {
        arr[i++] = temp.data;
        temp = temp.next;
    }
    return arr;
}


    public Staff search(int id) {
        StaffNode current = head;
        while (current != null) {
            if (current.data.getId() == id) return current.data;
            current = current.next;
        }
        return null;
    }

    public void delete(int id) {
        if (head == null) return;
        if (head.data.getId() == id) { head = head.next; return; }
        StaffNode current = head;
        while (current.next != null) {
            if (current.next.data.getId() == id) { current.next = current.next.next; return; }
            current = current.next;
        }
    }
}
