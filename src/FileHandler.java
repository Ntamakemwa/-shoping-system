import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
import java.util.Date;

public class FileHandler {
    private static final String INVENTORY_FILE = "inventory.txt";
    private static final String LOG_FILE = "transactions.txt";
    public static void saveInventory(Map<String, Product> marketplace) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(INVENTORY_FILE))) {
            for (Product p : marketplace.values()) {
                writer.println(p.getItem() + "," + p.getPrice() + "," + p.getStock());
            }
            writer.flush(); // Force immediate write to file
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    public static void loadInventory(Map<String, Product> marketplace) {
        File file = new File(INVENTORY_FILE);
        System.out.println("Loading inventory from: " + file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("Inventory file does not exist!");
            return;
        }

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println("Reading line: " + line);
                if (line.trim().isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    double price = Double.parseDouble(data[1]);
                    int stock = Integer.parseInt(data[2]);
                    marketplace.put(name, new Product(name, price, stock));
                    System.out.println("Loaded product: " + name + ", price: " + price + ", stock: " + stock);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
        System.out.println("Total products loaded: " + marketplace.size());
    }

    public static void logTransaction(String entry) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(LOG_FILE, true)))) {
            out.println("[" + new Date() + "] " + entry);
            out.flush(); // Force immediate write to file
        } catch (IOException e) {
            System.out.println("Error logging transaction: " + e.getMessage());
        }
    }
}