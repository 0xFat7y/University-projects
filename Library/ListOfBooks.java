package com.mycompany.datastructureproject;

public class ListOfBooks {
    private Book[] booksList;
    private int count;

    public ListOfBooks(int capacity) {
        booksList = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < booksList.length) { booksList[count++] = book; }
        else { System.out.println("Library is full!"); }
    }

    public void initializeDefaultBooks() {
        addBook(new Book(101, "Java Programming", "James Gosling", 50.0, true));
        addBook(new Book(102, "Data Structures", "Robert Lafore", 45.5, true));
        addBook(new Book(103, "Clean Code", "Robert Martin", 40.0, true));
        addBook(new Book(104, "Algorithm Design", "Eva Tardos", 60.0, true));
        addBook(new Book(105, "Harry Potter", "J.K. Rowling", 30.0, true));
        addBook(new Book(106, "The Alchemist", "Paulo Coelho", 25.0, true));
        addBook(new Book(107, "Intro to AI", "Stuart Russell", 70.0, true));
        addBook(new Book(108, "Database Systems", "Navathe", 55.0, true));
        addBook(new Book(109, "Operating Systems", "Tanenbaum", 65.0, true));
        addBook(new Book(110, "Computer Networks", "Kurose", 58.0, true));
        addBook(new Book(111, "Advanced Physics", "Einstein", 100.0, false));
        addBook(new Book(112, "Ancient History", "Herodotus", 20.0, false));
    }

    public void displayAllBooks() {
        System.out.println("\n--- List of Books ---");
        for (int i = 0; i < count; i++) { System.out.println(booksList[i]); }
    }

    public Book findBookById(int id) {
        for (int i = 0; i < count; i++) if (booksList[i].getId() == id) return booksList[i];
        return null;
    }

    
}
