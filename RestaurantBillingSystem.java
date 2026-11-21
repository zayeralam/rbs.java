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

    int getCode() {
        return code;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }
}

public class RestaurantBillingSystem {

    static Scanner sc = new Scanner(System.in);

    static MenuItem[] menu = {
        new MenuItem(101, "Classic Selection", 120),
        new MenuItem(102, "Signature Selection", 180),
        new MenuItem(103, "Premium Selection", 250),
        new MenuItem(104, "Special Selection", 300),
        new MenuItem(105, "Executive Selection", 400)
    };

    static int[] quantities = new int[menu.length];

    static int readNumber() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void displayMenu() {
        System.out.println("\n========== MENU ==========");

        for (int i = 0; i < menu.length; i++) {
            System.out.println(
                menu[i].getCode() + "  " +
                menu[i].getName() + "  Rs. " +
                menu[i].getPrice()
            );
        }
    }

    static void placeOrder() {
        displayMenu();

        System.out.print("\nEnter item code: ");
        int code = readNumber();

        int index = -1;

        for (int i = 0; i < menu.length; i++) {
            if (menu[i].getCode() == code) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Invalid item code.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = readNumber();

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        quantities[index] += quantity;

        System.out.println("Order added successfully.");
    }

    static double calculateTotal() {
        double total = 0;

        for (int i = 0; i < menu.length; i++) {
            total += menu[i].getPrice() * quantities[i];
        }

        return total;
    }

    static void generateBill() {
        double total = calculateTotal();

        if (total == 0) {
            System.out.println("\nNo items ordered.");
            return;
        }

        System.out.println("\n========== BILL ==========");
        System.out.println("Item             Qty       Amount");

        for (int i = 0; i < menu.length; i++) {
            if (quantities[i] > 0) {
                double amount =
                    menu[i].getPrice() * quantities[i];

                System.out.println(
                    menu[i].getName() + "   " +
                    quantities[i] + "   Rs. " +
                    amount
                );
            }
        }

        System.out.println("-------------------------");
        System.out.println("Total Amount: Rs. " + total);
        System.out.println("=========================");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("             RESTORA");
            System.out.println("    RESTAURANT BILLING SYSTEM");
            System.out.println("================================");
            System.out.println("1. Display Menu");
            System.out.println("2. Place Order");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = readNumber();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;

                case 2:
                    placeOrder();
                    break;

                case 3:
                    generateBill();
                    break;

                case 4:
                    System.out.println("Thank you.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}