package com.mycompany.datastructureproject;

import java.util.Scanner;

public class Payment {
    private String paymentId;
    private String userName;
    private String bookName;
    private double amount;
    private String paymentMethod;
    private boolean isSuccessful;

    private static Scanner scanner = new Scanner(System.in);

    public Payment(String userName, String bookName, double amount) {
        this.paymentId = "PAY" + System.currentTimeMillis();
        this.userName = userName;
        this.bookName = bookName;
        this.amount = amount;
        this.isSuccessful = false;
        this.paymentMethod = "";
    }

    public boolean processPayment() {
        System.out.println("\n=== Payment Process ===");
        if (!choosePaymentMethod()) return false;
        showSummary();
        if (!confirmPayment()) return false;
        return doPayment();
    }

    private boolean choosePaymentMethod() {
        System.out.println("Choose payment method:\n1. Cash\n2. Credit Card");
        System.out.print("Your choice: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) { paymentMethod = "CASH"; return true; }
        else if (choice.equals("2")) { paymentMethod = "CREDIT"; return true; }
        System.out.println("Invalid choice.");
        return false;
    }

    private void showSummary() {
        System.out.println("\nPayment Summary:");
        System.out.println("User: " + userName);
        System.out.println("Book: " + bookName);
        System.out.println("Amount: $" + amount);
        System.out.println("Method: " + paymentMethod);
    }

    private boolean confirmPayment() {
        System.out.print("\nConfirm payment? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        return answer.equals("yes") || answer.equals("y");
    }

    private boolean doPayment() {
        System.out.println("\nProcessing payment...");
        try { Thread.sleep(1000); } catch (Exception e) {}
        if (paymentMethod.equals("CASH")) return handleCash();
        else if (paymentMethod.equals("CREDIT")) return handleCredit();
        return false;
    }

    private boolean handleCash() {
        System.out.print("Cash received? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("yes") || answer.equals("y")) { isSuccessful = true; System.out.println("Cash payment successful."); return true; }
        System.out.println("Cash not received.");
        return false;
    }

    private boolean handleCredit() {
        System.out.println("Please scan your card.\n[Waiting for scan...]");
        try { Thread.sleep(1500); } catch (Exception e) {}
        System.out.print("Card scanned? (yes/no): ");
        String scan = scanner.nextLine().toLowerCase();
        if (!(scan.equals("yes") || scan.equals("y"))) { System.out.println("Scan failed."); return false; }
        try { Thread.sleep(1000); } catch (Exception e) {}
        if (Math.random() > 0.2) { isSuccessful = true; System.out.println("Credit payment approved."); return true; }
        System.out.println("Payment declined."); return false;
    }
    public void processCashPayment() {
    isSuccessful = true; // لأن المستخدم ضغط Yes
    paymentMethod = "CASH";
}

public void processCreditPayment() {
    paymentMethod = "CREDIT";
    if (Math.random() > 0.2) isSuccessful = true;
    else isSuccessful = false;
}

    public String getPaymentId() { return paymentId; }
    public String getUserName() { return userName; }
    public String getBookName() { return bookName; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public boolean isSuccessful() { return isSuccessful; }
}
