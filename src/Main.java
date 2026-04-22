
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Product> marketplace = new HashMap<>();


        Product milk = new Product("Milk", 3.00, 2);
        Product cabbage = new Product("Cabbage", 1.50, 10);

        marketplace.put(milk.getItem(), milk);
        marketplace.put(cabbage.getItem(), cabbage);

        Seller s1 = new Seller("Farmer John");
        Seller s2 = new Seller("Grocery Guru");
        Seller s3 = new Seller("Market Manager");


        s1.addToCatalog("Milk");
        s1.addToCatalog("Cabbage");

        Buyer b1 = new Buyer("Alice");
        Buyer b2 = new Buyer("Bob");
        Buyer b3 = new Buyer("Charlie");


        System.out.println("--- PROCESSING ORDERS ---");


        Order.placeOrder(b1, milk, 1);
        b1.recordPurchase("Bought 1x Milk");

        Order.placeOrder(b2, milk, 5);


        Order.placeOrder(b3, cabbage, 4);
        b3.recordPurchase("Bought 4x Cabbage");

        Order.placeOrder(b1, cabbage, -2);


        System.out.println("\n--- INVENTORY MANAGEMENT ---");


        if(marketplace.containsKey("Milk")) {
            System.out.println("Market Update: Milk is still available in the registry.");
        }

        marketplace.remove("Cabbage");
        System.out.println("Market Update: Cabbage has been removed from the digital registry.");

        System.out.println("\n--- FINAL COLLECTION SUMMARIES ---");
        b1.viewHistory();
        s1.identifyRole();
    }
}