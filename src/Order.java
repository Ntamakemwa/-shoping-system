public class Order {
    public static boolean placeOrder(Buyer buyer, Seller seller, Product product, int quantity) {
        System.out.println("\nORDER CONFIRMATION");
        System.out.println("Customer: " + buyer.getName());
        System.out.println("Seller: " + seller.getName() + " (Rating: " + seller.getRating() + ")");
        System.out.println("Product: " + product.getItem());
        System.out.println("Quantity: " + quantity);
        System.out.println("Unit Price: $" + product.getPrice());
        double totalCost = product.getPrice() * quantity;
        System.out.println("Total Cost: $" + totalCost);

        try {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive! You entered: " + quantity);
            }

            buyer.deductFromBalance(totalCost);
            seller.addToBalance(totalCost);

            product.checkAndReduceStock(quantity);

            buyer.recordPurchase(product.getItem() + " x" + quantity + " from " + seller.getName());
            seller.addToCatalog(product.getItem());

            System.out.println("SUCCESS: Order completed successfully!");
            System.out.println("You paid $" + totalCost + " for " + quantity + " " + product.getItem() + " to " + seller.getName());
            System.out.println("Thank you " + buyer.getName() + " for your purchase!");
            System.out.println("Your order has been recorded in your purchase history.");
            System.out.println("\nNOTIFICATION FOR " + seller.getName().toUpperCase() + ":");
            System.out.println("You received $" + totalCost + " for " + quantity + " " + product.getItem() + " from " + buyer.getName());

            return true;

        } catch (StockException e) {
            System.out.println("STOCK ERROR: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("INPUT ERROR: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("FINANCIAL ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("SYSTEM ERROR: " + e.getMessage());
        } finally {
            System.out.println("------------------------");
            System.out.println("[LOG] " + product.getItem() + " Stock: " + product.getStock());
            System.out.println("[LOG] Seller Balance: $" + seller.getBalance());
        }

        return false;
    }
}