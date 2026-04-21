
public class Main {
            public static void main(String[] args) {

                Seller s1 = new Seller("Farmer John");
                Seller s2 = new Seller("Grocery Guru");
                Seller s3 = new Seller("Market Manager");

                Buyer b1 = new Buyer("Alice");
                Buyer b2 = new Buyer("Bob");
                Buyer b3 = new Buyer("Charlie");


                Product milk = new Product("Milk", 3.00, 2);
                Product cabbage = new Product("Cabbage", 1.50, 10);


                Order.placeOrder(b1, milk, 1);

                Order.placeOrder(b2, milk, 5);

                Order.placeOrder(b3, cabbage, 4);

                Order.placeOrder(b1, cabbage, -2);
            }
        }

