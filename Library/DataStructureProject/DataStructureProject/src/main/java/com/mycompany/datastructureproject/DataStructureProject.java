package com.mycompany.datastructureproject;

import java.util.Scanner;

public class DataStructureProject {

    private static Scanner scanner = new Scanner(System.in);
    private static ListOfBooks libraryBooks = new ListOfBooks(50);

    public static void main(String[] args) {

        // Initialize default books
        libraryBooks.initializeDefaultBooks();

        System.out.println("=== Welcome to the Library System ===");

        while (true) {
            System.out.println("\nAre you a: \n1. User\n2. Staff\n3. Exit");
            System.out.print("Choice: ");
            String roleChoice = scanner.nextLine();

            switch (roleChoice) {
                case "1": // User
                    handleUser();
                    break;
                case "2": // Staff
                    handleStaff();
                    break;
                case "3": // Exit
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleUser() {
        System.out.println("\nDo you want to: \n1. Signup\n2. Login");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();

        User user = null;

        if (choice.equals("1")) {
            user = signupUser();
        }

        if (choice.equals("2") || user != null) {
            if (user == null) user = loginUser();
            if (user == null) {
                System.out.println("Login failed.");
                return;
            }

            System.out.println("\nWelcome " + user.getName() + "!");

            boolean userMenu = true;
            while (userMenu) {
                System.out.println("\nUser Menu:\n1. View Books\n2. Buy Book\n3. Logout");
                System.out.print("Choice: ");
                String uChoice = scanner.nextLine();

                switch (uChoice) {
                    case "1":
                        libraryBooks.displayAllBooks();
                        break;
                    case "2":
                        buyBook(user);
                        break;
                    case "3":
                        userMenu = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    private static User signupUser() {
        System.out.println("\n--- Signup ---");
        System.out.print("Enter User ID (number): ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Role (Reader): ");
        String role = "Reader";

        User newUser = new User(id, name, email, phone, role);
        Registration.registerUser(newUser);
        System.out.println("Signup successful!");
        return newUser;
    }

    private static User loginUser() {
        System.out.println("\n--- Login ---");
        System.out.print("User ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Email: ");
        String email = scanner.nextLine();

        User user = Registration.loginUser(id, email);
        if (user != null) System.out.println("Login successful!");
        return user;
    }

    private static void buyBook(User user) {
        libraryBooks.displayAllBooks();
        System.out.print("\nEnter Book ID to buy: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        Book book = libraryBooks.findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }

        Payment payment = new Payment(user.getName(), book.getName(), book.getCost());
        if (payment.processPayment()) {
            PaymentReport report = new PaymentReport(payment);
            report.showReport();
            System.out.println("\nThank you for your purchase!");
        } else {
            System.out.println("Payment failed.");
        }
    }

    private static void handleStaff() {
        System.out.println("\n--- Staff Login ---");
        System.out.print("Enter Staff ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Staff staff = Registration.loginStaff(id);
        if (staff == null) {
            System.out.println("Invalid Staff ID.");
            return;
        }

        System.out.println("\nWelcome " + staff.getName() + "!");

        boolean staffMenu = true;
        while (staffMenu) {
            System.out.println("\nStaff Menu:\n1. View All Books\n2. View Users\n3. View Staff\n4. Logout");
            System.out.print("Choice: ");
            String sChoice = scanner.nextLine();

            switch (sChoice) {
                case "1":
                    libraryBooks.displayAllBooks();
                    break;
                case "2":
                    Registration.showAllUsers();
                    break;
                case "3":
                    Registration.showAllStaff();
                    break;
                case "4":
                    staffMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
