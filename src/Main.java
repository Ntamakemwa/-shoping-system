import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Map<String, Product> marketplace = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static List<Seller> sellers = new ArrayList<>();
    private static List<Buyer> buyers = new ArrayList<>();
    private static Buyer currentBuyer;

    public static void main(String[] args) {
        initializeUsers();
        FileHandler.loadInventory(marketplace);

        selectBuyer();

        boolean running = true;
        while (running) {
            System.out.println("\n=== MARKETPLACE ===");
            System.out.println("1. Browse Products");
            System.out.println("2. Buy Product");
            System.out.println("3. My Purchase History");
            System.out.println("4. Switch Buyer");
            System.out.println("5. Save & Exit");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> showProducts();
                    case 2 -> buyProduct();
                    case 3 -> showHistory();
                    case 4 -> selectBuyer();
                    case 5 -> {
                        FileHandler.saveInventory(marketplace);
                        running = false;
                    }
                    default -> System.out.println("Try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a number!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void showProducts() {
        System.out.println("\n--- AVAILABLE PRODUCTS ---");
        if (marketplace.isEmpty()) {
            System.out.println("No products available!");
            return;
        }
        int index = 1;
        for (Product p : marketplace.values()) {
            System.out.println(index + ". " + p.getItem() + " - $" + p.getPrice() + " (" + p.getStock() + " in stock)");
            index++;
        }
    }

    private static void buyProduct() {
        showProducts();
        System.out.print("\nEnter product number: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            List<Product> productList = new ArrayList<>(marketplace.values());

            if (choice >= 1 && choice <= productList.size()) {
                Product selectedProduct = productList.get(choice - 1);

                if (selectedProduct.getStock() <= 0) {
                    System.out.println(selectedProduct.getItem() + " is not in stock!");
                    return;
                }

                // Show available sellers for this product
                Seller bestSeller = findBestSeller(selectedProduct);
                System.out.println("\n--- SELLER INFO ---");
                System.out.println(" " + bestSeller.getName() + " (Rating: " + bestSeller.getRating() + " )");
                System.out.println(" Balance: $" + bestSeller.getBalance());
                System.out.println(" Products sold: " + bestSeller.getCatalog().size());

                System.out.print("\nQuantity to buy: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                boolean success = Order.placeOrder(currentBuyer, bestSeller, selectedProduct, quantity);
                if (success) {
                    FileHandler.logTransaction(currentBuyer.getName() + " bought " + quantity + " " + selectedProduct.getItem());
                    FileHandler.saveInventory(marketplace); // Save updated stock immediately
                }

            } else {
                System.out.println("Invalid product number!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter valid numbers!");
        }
    }

    private static Seller findBestSeller(Product product) {
        // Cool surprise: Find seller with highest rating for this product
        Seller best = sellers.get(0);
        for (Seller s : sellers) {
            if (s.getRating() > best.getRating()) {
                best = s;
            }
        }
        return best;
    }

    private static void showHistory() {
        currentBuyer.viewHistory();
    }

    private static void initializeUsers() {
        sellers.add(new Seller("Liam", 1000.0, 4.5));
        sellers.add(new Seller("Ishimwe", 1500.0, 4.8));
        sellers.add(new Seller("Eliab", 800.0, 4.2));

        buyers.add(new Buyer("Paccy", 500.0));
        buyers.add(new Buyer("Jemi", 300.0));
        buyers.add(new Buyer("Steve", 750.0));
    }

    private static void selectBuyer() {
        System.out.println("\n--- SELECT BUYER ---");
        for (int i = 0; i < buyers.size(); i++) {
            System.out.println((i + 1) + ". " + buyers.get(i).getName());
        }
        System.out.print("Choose buyer: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= buyers.size()) {
                currentBuyer = buyers.get(choice - 1);
                System.out.println("Welcome, " + currentBuyer.getName() + "!");
            } else {
                System.out.println("Invalid choice!");
                selectBuyer();
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a number!");
            selectBuyer();
        }
    }
}