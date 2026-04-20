public class Main {
    public static void main(String[] args) {

        Buyer customer = new Buyer("Alice");
        Seller merchant = new Seller("TechWorld");
        Product laptop = new Product("MacBook Pro", 1299.99, 1);


        customer.identifyRole();
        merchant.identifyRole();

        Order.placeOrder(customer, laptop);
        Order.placeOrder(customer, laptop);
    }
}
