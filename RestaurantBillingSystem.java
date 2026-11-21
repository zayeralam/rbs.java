import java.util.Scanner;

class MenuItem {
    private int code;
    private String name;
    private double price;

    MenuItem(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    int getCode() { return code; }
    String getName() { return name; }
    double getPrice() { return price; }
}

public class RestaurantBillingSystem {
    static Scanner sc = new Scanner(System.in);

    static MenuItem[] menu = {
        new MenuItem(101, "Classic Selection", 120.00),
        new MenuItem(102, "Signature Selection", 180.00),
        new MenuItem(103, "Premium Selection", 250.00),
        new MenuItem(104, "Special Selection", 300.00),
        new MenuItem(105, "Executive Selection", 400.00)
    };
    static int[] quantities = new int[menu.length];

    static int readNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\n--------------- MENU ---------------");
        System.out.printf("%-8s %-24s %s%n", "Code", "Selection", "Price (Rs.)");
        for (MenuItem item : menu) {
            System.out.printf("%-8d %-24s %.2f%n", item.getCode(), item.getName(), item.getPrice());
        }
        System.out.println("----------------------------------");
    }

    static int findItemIndex(int code) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].getCode() == code) return i;
        }
        return -1;
    }

    static void placeOrder() {
        displayMenu();
        int code = readNumber("Enter item code (0 to cancel): ");
        if (code == 0) return;
        int index = findItemIndex(code);
        if (index == -1) {
            System.out.println("Item code not found.");
            return;
        }
        int quantity = readNumber("Enter quantity: ");
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }
        if (quantities[index] > Integer.MAX_VALUE - quantity) {
            System.out.println("Quantity is too large.");
            return;
        }
        quantities[index] += quantity;
        System.out.println("Selection added to order.");
    }

    static double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < menu.length; i++) {
            total += menu[i].getPrice() * quantities[i];
        }
        return total;
    }

    static boolean hasOrder() {
        for (int quantity : quantities) if (quantity > 0) return true;
        return false;
    }

    static void viewOrder() {
        if (!hasOrder()) {
            System.out.println("\nYour order is currently empty.");
            return;
        }
        System.out.println("\n------------- CURRENT ORDER -------------");
        System.out.printf("%-24s %-10s %-12s%n", "Selection", "Quantity", "Amount (Rs.)");
        for (int i = 0; i < menu.length; i++) {
            if (quantities[i] > 0) {
                double amount = menu[i].getPrice() * quantities[i];
                System.out.printf("%-24s %-10d %-12.2f%n", menu[i].getName(), quantities[i], amount);
            }
        }
        System.out.printf("Total: Rs. %.2f%n", calculateTotal());
        System.out.println("---------------------------------------");
    }

    static void generateBill() {
        if (!hasOrder()) {
            System.out.println("No order to bill.");
            return;
        }
        System.out.println("\n============= RESTORA BILL =============");
        System.out.printf("%-24s %-8s %-12s%n", "Selection", "Quantity", "Amount (Rs.)");
        for (int i = 0; i < menu.length; i++) {
            if (quantities[i] > 0) {
                double amount = menu[i].getPrice() * quantities[i];
                System.out.printf("%-24s %-8d %-12.2f%n", menu[i].getName(), quantities[i], amount);
            }
        }
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL AMOUNT: Rs. %.2f%n", calculateTotal());
        System.out.println("========================================");
        clearOrder();
        System.out.println("Bill generated. Order cleared for the next customer.");
    }

    static void clearOrder() {
        for (int i = 0; i < quantities.length; i++) quantities[i] = 0;
    }

    static void mainMenu() {
        System.out.println("\n========================================");
        System.out.println("                 RESTORA");
        System.out.println("        RESTAURANT BILLING SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Display Menu");
        System.out.println("2. Place Order");
        System.out.println("3. View Current Order");
        System.out.println("4. Generate Bill");
        System.out.println("5. Clear Current Order");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        int choice;
        do {
            mainMenu();
            choice = readNumber("Enter your choice: ");
            switch (choice) {
                case 1: displayMenu(); break;
                case 2: placeOrder(); break;
                case 3: viewOrder(); break;
                case 4: generateBill(); break;
                case 5:
                    if (hasOrder()) {
                        int confirm = readNumber("Clear the order? Enter 1 for Yes, 2 for No: ");
                        if (confirm == 1) { clearOrder(); System.out.println("Order cleared."); }
                        else System.out.println("Order retained.");
                    } else System.out.println("No order to clear.");
                    break;
                case 6: System.out.println("Thank you for using RESTORA."); break;
                default: System.out.println("Choose a number from 1 to 6.");
            }
        } while (choice != 6);
        sc.close();
    }
}