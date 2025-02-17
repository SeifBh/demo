package com.example.testrules;

import java.util.*;
import lombok.*;
import javax.persistence.*;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
@Data  // Redundant with @Getter/@Setter
public class ProcessHandler {  // Vague class name
    // Field naming violations
    private String str;              // Too vague
    private List data;              // Raw type and vague
    private boolean flag;           // Unclear boolean
    private Map<K,V> m;             // Single letter
    private int n;                  // Single letter
    private String tmp;             // Temporary/unclear
    private List<String> list;      // Too generic
    private boolean success;        // Missing 'is' prefix
    private boolean valid;          // Missing 'is' prefix
    private Service s;              // Single letter

    // Collection naming violations
    private List<User> user;        // Should be plural
    private Set<Order> order;       // Should be plural
    private Map<String, Product> productMap;  // Should indicate purpose

    // Service/Component field violations
    private UserLogic userLogic;    // Wrong suffix
    private OrderStuff orderStuff;  // Wrong suffix
    private PaymentThing paymentThing;  // Wrong suffix

    // Method naming violations
    void process() {                // Too vague
        System.out.println("Processing...");
    }

    boolean check() {               // Too vague
        return true;
    }

    void handleStuff() {            // Non-specific
        // code
    }

    void data() {                   // Not a verb
        // code
    }

    void userValidation() {         // Not a verb
        // code
    }

    String stringFormat() {         // Not a verb
        return "";
    }

    void doBusinessLogic() {        // Too vague
        // code
    }

    boolean success() {             // Not a question
        return true;
    }

    // Multiple responsibility violations
    public void processAndSave(Order order) {
        validateOrder(order);
        processOrder(order);
        saveOrder(order);
        sendNotification(order);
        updateCache(order);
    }

    public void validateAndUpdate(User user) {
        if (validateUser(user)) {
            updateUser(user);
            System.out.println("User updated");
        }
    }

    // Query method violations
    User activeUser() {             // Missing verb prefix
        return null;
    }

    List<Order> pendingOrders() {   // Missing verb prefix
        return null;
    }

    Product searchById(String id) { // Should be findById or getById
        return null;
    }

    // Action method violations
    void handle(Event event) {      // Too vague
        // code
    }

    void doUpdate(User user) {      // 'do' is vague
        // code
    }

    // Boolean method violations
    boolean valid(User user) {      // Missing question form
        return true;
    }

    boolean permission(String action) {  // Missing question form
        return true;
    }

    boolean userAccess() {          // Missing question form
        return true;
    }

    // SOLID violations
    public void validateAndSaveAndNotify(Order order) {
        if (order == null) {
            System.out.println("Invalid order");
            return;
        }

        // Database operation
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db");
        PreparedStatement ps = conn.prepareStatement("INSERT INTO orders...");
        ps.executeUpdate();

        // Email notification
        SmtpClient client = new SmtpClient();
        client.send("Order " + order.getId() + " processed");

        // Cache update
        cache.put(order.getId(), order);

        System.out.println("Order processed");
    }

    // Mixed technical concerns
    public void handleUserRegistration(User user) {
        // UI validation
        if (!validateUserInput(user)) {
            System.out.println("Invalid input");
            return;
        }

        // Database operation
        saveToDatabase(user);

        // Email operation
        sendWelcomeEmail(user);

        // Cache operation
        updateUserCache(user);

        // Log operation
        System.out.println("User registered: " + user.getId());
    }

    // Resource management violation
    public void processFile() {
        FileInputStream fis = new FileInputStream("data.txt");
        // No try-with-resources
        byte[] data = fis.readAllBytes();
        // fis not closed
    }

    // Security violation
    @GetMapping("/users")
    public User getUser(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";  // SQL Injection
        return jdbcTemplate.queryForObject(query, User.class);
    }
}