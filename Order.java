public class Order {

    public static void placeOrder(Buyer buyer, Product product) {
        System.out.println("\n Order Receipt ");
        System.out.println("Customer: " + buyer.getName());

        if (product.processPurchase(1)) {
            System.out.println("Item Purchased: " + product.getTitle());
            System.out.println("Total Paid: $" + product.getPrice());
            System.out.println("Status: Confirmed");
        } else {
            System.out.println("Status: Failed - Out of Stock");
        }




        System.out.println("  The End");
    }
}
