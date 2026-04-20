
public class Product {
    private String title;
    private double price;
    private int stock;

    public Product(String title, double price, int stock) {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public boolean processPurchase(int qty) {
        if (stock >= qty) {
            stock -= qty;
            return true;
        }
        return false;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
}