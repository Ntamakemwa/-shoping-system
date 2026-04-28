public class Product {
    private String item;
    private double price;
    private int stock;

    public Product(String item, double price, int stock) {
        this.item = item;
        this.price = price;
        this.stock = stock;
    }

    public String getItem() { return item; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void checkAndReduceStock(int amount) throws StockException {
        if (amount <= 0) throw new IllegalArgumentException("Quantity must be positive!");
        if (this.stock < amount) throw new StockException("Insufficient stock for " + item);
        this.stock -= amount;
    }
}