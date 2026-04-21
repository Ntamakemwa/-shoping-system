public class Order {
    public static void placeOrder(Buyer person, Product product, int quantity) {
        // 1. The Receipt (For the Customer)
        System.out.println("\n--- CUSTOMER RECEIPT ---");
        System.out.println("Customer: " + person.getName());

        try {
            product.checkAndReduceStock(quantity);
            System.out.println("Item: " + quantity + "x " + product.getItem());
            System.out.println("Total Paid: $" + (product.getPrice() * quantity));
            System.out.println("Status: CONFIRMED");
        }


        catch (StockError e) {
            System.out.println("Status: TRANSACTION FAILED");
            System.out.println("Reason: " + e.getMessage());
        }


        catch (IllegalArgumentException e) {
            System.out.println("Status: SYSTEM ERROR");
            System.out.println("Reason: " + e.getMessage());
        }


        finally {
            System.out.println("------------------------");
            // 2. The Internal Update (Moved OUTSIDE of the visible receipt area)
            System.out.println("[INTERNAL LOG] Inventory Update: " + product.getItem() + " Stock is now: " + product.getStock());
        }
    }
}

