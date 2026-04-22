public class Product {
    private String item;
    private double price;
    private int stock;

    public Product(String item, double price, int stock) {
        this.item = item;
        this.price = price;
        this.stock = stock;
    }

    public String getItem() {

        return item;
    }
    public double getPrice() {

        return price;
    }
    public void setItem(String item) {

        this.item = item;
    }
    public void setPrice(double price) {

        this.price = price;
    }
    public int getStock() {

        return stock;
    }
    public void setStock(int stock) {

        this.stock = stock;
    }
    public void checkAndReduceStock(int amount) throws StockError {

        if (amount <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number.");
        }

        if (this.stock < amount) {
            throw new StockError("Not enough " + item + " in inventory.");
        }

        this.stock -= amount;
    }
}

