package com.mycompany.datastructureproject;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI extends JFrame {

    private ListOfBooks books = new ListOfBooks(50);

    // ===== Theme =====
    private final Color BG = new Color(245, 242, 235);
    private final Color BTN = new Color(93, 64, 55);
    private final Color TXT = Color.WHITE;

    private final Font TITLE = new Font("Serif", Font.BOLD, 18);
    private final Font NORMAL = new Font("SansSerif", Font.PLAIN, 14);

    public LibraryGUI() {
        books.initializeDefaultBooks();
        showMainMenu();
    }

    // ===== Button Style =====
    private JButton styledButton(String text) {
        JButton b = new JButton(text);
        b.setBackground(BTN);
        b.setForeground(TXT);
        b.setFont(NORMAL);
        b.setFocusPainted(false);
        return b;
    }

    // ================= MAIN MENU =================
    private void showMainMenu() {
        getContentPane().removeAll();
        setTitle("Library System");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("Library System", SwingConstants.CENTER);
        title.setFont(TITLE);

        JButton userBtn = styledButton("User");
        JButton staffBtn = styledButton("Staff");
        JButton exitBtn = styledButton("Exit");

        JPanel p = new JPanel(new GridLayout(4,1,10,10));
        p.setBackground(BG);
        p.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        p.add(title);
        p.add(userBtn);
        p.add(staffBtn);
        p.add(exitBtn);

        add(p);

        userBtn.addActionListener(e -> showUserLogin());
        staffBtn.addActionListener(e -> showStaffLogin());
        exitBtn.addActionListener(e -> System.exit(0));

        revalidate();
        repaint();
        setVisible(true);
    }

    // ================= USER LOGIN =================
    private void showUserLogin() {
        getContentPane().removeAll();
        setTitle("User Login");
        setSize(400, 280);

        JTextField idField = new JTextField();
        JTextField emailField = new JTextField();

        JButton login = styledButton("Login");
        JButton signup = styledButton("Signup");
        JButton back = styledButton("Back");

        JPanel p = new JPanel(new GridLayout(5,2,10,10));
        p.setBackground(BG);
        p.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));

        p.add(new JLabel("User ID"));
        p.add(idField);
        p.add(new JLabel("Email"));
        p.add(emailField);
        p.add(login);
        p.add(signup);
        p.add(back);

        add(p);

        login.addActionListener(e -> {
            try {
                User u = Registration.loginUser(
                        Integer.parseInt(idField.getText()),
                        emailField.getText()
                );
                if (u != null) showUserMenu(u);
                else JOptionPane.showMessageDialog(this,"Invalid data");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Invalid input");
            }
        });
        for (java.awt.event.ActionListener al : login.getActionListeners()) {
        login.removeActionListener(al);
        }

       login.addActionListener(e -> {
    String idText = idField.getText().trim();
    String emailText = emailField.getText().trim();

    if (idText.isEmpty() || emailText.isEmpty()) {
        JOptionPane.showMessageDialog(this,"All fields required");
        return;
    }

    if (!emailText.contains("@")) {
        JOptionPane.showMessageDialog(this,"Email must contain @");
        return;
    }

    int userId;
    try {
        userId = Integer.parseInt(idText);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this,"ID must be numbers only");
        return;
    }

    User u = Registration.loginUser(userId, emailText);
    if (u != null) {
        showUserMenu(u);
    } else {
        JOptionPane.showMessageDialog(this,"Invalid data");
    }
    });


        signup.addActionListener(e -> showSignup());
        back.addActionListener(e -> showMainMenu());
        allowOnlyNumbers(idField);

        revalidate();
        repaint();
    }

    // ================= SIGNUP =================
    private void showSignup() {
    getContentPane().removeAll();
    setTitle("Signup");
    setSize(400, 330);

    JTextField id = new JTextField();
    JTextField name = new JTextField();
    JTextField email = new JTextField();
    JTextField phone = new JTextField();

    JButton create = styledButton("Create");
    JButton back = styledButton("Back");

    JPanel p = new JPanel(new GridLayout(6,2,10,10));
    p.setBackground(BG);
    p.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));

    p.add(new JLabel("ID"));
    p.add(id);
    p.add(new JLabel("Name"));
    p.add(name);
    p.add(new JLabel("Email"));
    p.add(email);
    p.add(new JLabel("Phone"));
    p.add(phone);
    p.add(create);
    p.add(back);

    add(p);

    create.addActionListener(e -> {
        String idText = id.getText();
        String nameText = name.getText();
        String emailText = email.getText();
        String phoneText = phone.getText();

        // تحقق من كل الحقول
        if (idText == null || idText.trim().isEmpty() ||
            nameText == null || nameText.trim().isEmpty() ||
            emailText == null || emailText.trim().isEmpty() ||
            phoneText == null || phoneText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"All fields are required");
            return;
        }

        if (!emailText.contains("@")) {
            JOptionPane.showMessageDialog(this,"Invalid email");
            return;
        }

        int userId;
        try {
            userId = Integer.parseInt(idText.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"ID must be numbers only");
            return;
        }

        // كل شيء صح، إنشاء الـ User
        User u = new User(userId, nameText.trim(), emailText.trim(), phoneText.trim(), "Reader");
        Registration.registerUser(u);

        JOptionPane.showMessageDialog(this,"Account created");
        showUserLogin();
    });

    back.addActionListener(e -> showUserLogin());
    allowOnlyNumbers(id);
    allowOnlyNumbers(phone);

    revalidate();
    repaint();
}


    // ================= USER MENU =================
    private void showUserMenu(User u) {
        getContentPane().removeAll();
        setTitle("Welcome " + u.getName());
        setSize(350, 280);

        JButton view = styledButton("View Books");
        JButton buy = styledButton("Buy Book");
        JButton logout = styledButton("Logout");

        JPanel p = new JPanel(new GridLayout(4,1,10,10));
        p.setBackground(BG);
        p.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        p.add(view);
        p.add(buy);
        p.add(logout);

        add(p);

        view.addActionListener(e -> showBooks());
        buy.addActionListener(e -> askBookId(u));
        logout.addActionListener(e -> showMainMenu());

        revalidate();
        repaint();
    }

    // ================= BOOKS =================
    private void showBooks() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(NORMAL);

        StringBuilder sb = new StringBuilder();
        for (int i = 101; i <= 112; i++) {
            Book b = books.findBookById(i);
            if (b != null) sb.append(b).append("\n");
        }
        area.setText(sb.toString());

        JOptionPane.showMessageDialog(this,new JScrollPane(area));
    }

    // ================= BUY FLOW =================
    private void askBookId(User user) {
        String input = JOptionPane.showInputDialog(this,"Enter Book ID");
        try {
            int id = Integer.parseInt(input);
            Book b = books.findBookById(id);

            if (b == null || !b.isAvailable()) {
                JOptionPane.showMessageDialog(this,"Book not available");
                return;
            }
            showPaymentScene(user, b);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Invalid ID");
        }
    }

// ================= PAYMENT SCENE =================
private void showPaymentScene(User user, Book book) {
    getContentPane().removeAll();
    setTitle("Payment");
    setSize(400, 300);

    JLabel title = new JLabel("Library Payment", SwingConstants.CENTER);
    title.setFont(TITLE);

    JRadioButton cash = new JRadioButton("Cash");
    JRadioButton card = new JRadioButton("Credit Card");

    ButtonGroup g = new ButtonGroup();
    g.add(cash);
    g.add(card);

    JLabel info = new JLabel("Book: " + book.getName() + " | $" + book.getCost());

    JButton next = styledButton("Next");
    JButton back = styledButton("Back");

    JPanel p = new JPanel(new GridLayout(6,1,8,8));
    p.setBackground(BG);
    p.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));

    p.add(title);
    p.add(info);
    p.add(cash);
    p.add(card);
    p.add(next);
    p.add(back);

    add(p);

    next.addActionListener(e -> {
        if (!cash.isSelected() && !card.isSelected()) {
            JOptionPane.showMessageDialog(this,"Choose payment method");
            return;
        }
        String method = cash.isSelected() ? "CASH" : "CREDIT";
        showPaymentQuestions(user, book, method);
    });

    back.addActionListener(e -> showUserMenu(user));

    revalidate();
    repaint();
}

// ================= PAYMENT QUESTIONS =================
private void showPaymentQuestions(User user, Book book, String method) {
    getContentPane().removeAll();
    setTitle("Confirm Payment");
    setSize(400, 300);

    JLabel title = new JLabel("Confirm Payment", SwingConstants.CENTER);
    title.setFont(TITLE);

    JTextArea summary = new JTextArea(
        "User: " + user.getName() + "\n" +
        "Book: " + book.getName() + "\n" +
        "Amount: $" + book.getCost() + "\n" +
        "Method: " + method
    );
    summary.setEditable(false);
    summary.setFont(NORMAL);
    summary.setBackground(BG);

    JLabel question = new JLabel("", SwingConstants.CENTER);

    JButton yesBtn = styledButton("Yes");
    JButton noBtn = styledButton("No");

    JPanel btnPanel = new JPanel(new GridLayout(1,2,10,10));
    btnPanel.setBackground(BG);
    btnPanel.add(yesBtn);
    btnPanel.add(noBtn);

    JPanel mainPanel = new JPanel(new BorderLayout(10,10));
    mainPanel.setBackground(BG);
    mainPanel.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));
    mainPanel.add(title, BorderLayout.NORTH);
    mainPanel.add(summary, BorderLayout.CENTER);
    mainPanel.add(question, BorderLayout.SOUTH);

    add(mainPanel, BorderLayout.CENTER);
    add(btnPanel, BorderLayout.SOUTH);

    // المرحلة الأولى: تأكيد الدفع
    question.setText("Confirm payment?");
    yesBtn.addActionListener(e -> {
        if (method.equals("CASH")) showCashQuestions(user, book);
        else showCreditQuestions(user, book);
    });
    noBtn.addActionListener(e -> showUserMenu(user));

    revalidate();
    repaint();
}

// ================= CASH QUESTIONS =================
private void showCashQuestions(User user, Book book) {
    getContentPane().removeAll();
    setTitle("Cash Payment");
    setSize(400, 250);

    JLabel title = new JLabel("Cash Payment", SwingConstants.CENTER);
    title.setFont(TITLE);

    JLabel question = new JLabel("Cash received?", SwingConstants.CENTER);

    JButton yesBtn = styledButton("Yes");
    JButton noBtn = styledButton("No");

    JPanel btnPanel = new JPanel(new GridLayout(1,2,10,10));
    btnPanel.setBackground(BG);
    btnPanel.add(yesBtn);
    btnPanel.add(noBtn);

    JPanel mainPanel = new JPanel(new BorderLayout(10,10));
    mainPanel.setBackground(BG);
    mainPanel.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));
    mainPanel.add(title, BorderLayout.NORTH);
    mainPanel.add(question, BorderLayout.CENTER);

    add(mainPanel, BorderLayout.CENTER);
    add(btnPanel, BorderLayout.SOUTH);

    yesBtn.addActionListener(e -> {
        Payment payment = new Payment(user.getName(), book.getName(), book.getCost());
        payment.processCashPayment(); // سنضيف دالة خاصة بالكاش داخل Payment
        showPaymentReportScene(payment);
    });
    noBtn.addActionListener(e -> showUserMenu(user));

    revalidate();
    repaint();
}

// ================= CREDIT QUESTIONS =================
private void showCreditQuestions(User user, Book book) {
    getContentPane().removeAll();
    setTitle("Credit Payment");
    setSize(400, 300);

    JLabel title = new JLabel("Credit Payment", SwingConstants.CENTER);
    title.setFont(TITLE);

    JLabel question1 = new JLabel("Card scanned?", SwingConstants.CENTER);
    JButton yesBtn1 = styledButton("Yes");
    JButton noBtn1 = styledButton("No");

    JPanel btnPanel1 = new JPanel(new GridLayout(1,2,10,10));
    btnPanel1.setBackground(BG);
    btnPanel1.add(yesBtn1);
    btnPanel1.add(noBtn1);

    add(title, BorderLayout.NORTH);
    add(question1, BorderLayout.CENTER);
    add(btnPanel1, BorderLayout.SOUTH);

    yesBtn1.addActionListener(e -> {
        Payment payment = new Payment(user.getName(), book.getName(), book.getCost());
        payment.processCreditPayment(); // سنضيف دالة خاصة بالكريدت داخل Payment
        showPaymentReportScene(payment);
    });
    noBtn1.addActionListener(e -> showUserMenu(user));

    revalidate();
    repaint();
}

    // ================= PAYMENT REPORT =================
    private void showPaymentReportScene(Payment p) {
        getContentPane().removeAll();
        setTitle("Report");
        setSize(400, 300);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(NORMAL);
        area.setBackground(BG);

        area.setText(
            "Payment ID: " + p.getPaymentId() + "\n" +
            "User: " + p.getUserName() + "\n" +
            "Book: " + p.getBookName() + "\n" +
            "Amount: $" + p.getAmount() + "\n" +
            "Method: " + p.getPaymentMethod() + "\n" +
            "Status: " + (p.isSuccessful() ? "SUCCESS" : "FAILED")
        );

        JButton back = styledButton("Main Menu");

        add(new JScrollPane(area),BorderLayout.CENTER);
        add(back,BorderLayout.SOUTH);

        back.addActionListener(e -> showMainMenu());

        revalidate();
        repaint();
    }

    // ================= STAFF =================
    private void showStaffLogin() {
        getContentPane().removeAll();
        setTitle("Staff Login");
        setSize(300,200);

        JTextField id = new JTextField();
        JButton login = styledButton("Login");
        JButton back = styledButton("Back");

        JPanel p = new JPanel(new GridLayout(3,2,10,10));
        p.setBackground(BG);
        p.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        p.add(new JLabel("Staff ID"));
        p.add(id);
        p.add(login);
        p.add(back);

        add(p);

        login.addActionListener(e -> {
            try {
                Staff s = Registration.loginStaff(Integer.parseInt(id.getText()));
                if (s != null) showStaffMenu(s);
                else JOptionPane.showMessageDialog(this,"Invalid ID");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Invalid input");
            }
        });

        back.addActionListener(e -> showMainMenu());

        revalidate();
        repaint();
    }

    private void showStaffMenu(Staff s) {
        getContentPane().removeAll();
        setTitle("Staff Menu");
        setSize(300,260);

        JButton books = styledButton("View Books");
        JButton users = styledButton("View Users");
        JButton staff = styledButton("View Staff");
        JButton logout = styledButton("Logout");

        JPanel p = new JPanel(new GridLayout(4,1,10,10));
        p.setBackground(BG);
        p.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));

        p.add(books);
        p.add(users);
        p.add(staff);
        p.add(logout);

        add(p);

        books.addActionListener(e -> showBooks());
        users.addActionListener(e -> showUsersGUI(s));
        staff.addActionListener(e -> showStaffGUI(s));
        logout.addActionListener(e -> showMainMenu());

        revalidate();
        repaint();
    }
    private void showUsersGUI(Staff staff) {
    getContentPane().removeAll();
    setTitle("All Users");
    setSize(500,300);

    User[] users = Registration.getAllUsers();

    String[] cols = {"ID","Name","Email","Phone","Role"};
    Object[][] data = new Object[users.length][5];

    for (int i = 0; i < users.length; i++) {
        data[i][0] = users[i].getUserId();
        data[i][1] = users[i].getName();
        data[i][2] = users[i].getEmail();
        data[i][3] = users[i].getPhone();
        data[i][4] = users[i].getRole();
    }

    JTable table = new JTable(data, cols);
    JScrollPane pane = new JScrollPane(table);

    JButton back = styledButton("Back");
    back.addActionListener(e -> showStaffMenu(staff));

    add(pane, BorderLayout.CENTER);
    add(back, BorderLayout.SOUTH);

    revalidate();
    repaint();
}
private void showStaffGUI(Staff staff) {
    getContentPane().removeAll();
    setTitle("All Staff");
    setSize(500,300);

    Staff[] staffList = Registration.getAllStaff();

    String[] cols = {"ID","Name","Role","Salary"};
    Object[][] data = new Object[staffList.length][4];

    for (int i = 0; i < staffList.length; i++) {
        data[i][0] = staffList[i].getId();
        data[i][1] = staffList[i].getName();
        data[i][2] = staffList[i].getRole();
        data[i][3] = staffList[i].getSalary();
    }

    JTable table = new JTable(data, cols);
    JScrollPane pane = new JScrollPane(table);

    JButton back = styledButton("Back");
    back.addActionListener(e -> showStaffMenu(staff));

    add(pane, BorderLayout.CENTER);
    add(back, BorderLayout.SOUTH);

    revalidate();
    repaint();
}
private void allowOnlyNumbers(JTextField field) {
    field.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) {
                e.consume();
            }
        }
    });
}


    // ================= MAIN =================
    public static void main(String[] args) {
        new LibraryGUI();
    }
}
