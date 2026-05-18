package com.mycompany.datastructureproject;

public class PaymentReport {
    private Payment payment;
    private String reportId;

    public PaymentReport(Payment payment) {
        this.payment = payment;
        this.reportId = "REP" + System.currentTimeMillis();
    }

    public void showReport() {
        System.out.println("\n=== Transaction Report ===");
        System.out.println("Report ID: " + reportId);
        System.out.println("Payment ID: " + payment.getPaymentId());
        System.out.println("User: " + payment.getUserName());
        System.out.println("Book: " + payment.getBookName());
        System.out.println("Amount: $" + payment.getAmount());
        System.out.println("Method: " + payment.getPaymentMethod());
        System.out.println("Status: " + (payment.isSuccessful() ? "SUCCESSFUL" : "UNSUCCESSFUL"));
        if (!payment.isSuccessful()) System.out.println("Payment was not successful!");
        System.out.println("Thank You for Using Our System");
    }
}
