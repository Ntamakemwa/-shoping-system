import java.util.HashSet;
import java.util.Set;

class Seller extends User {

    private Set<String> catalog = new HashSet<>();
    private double balance;
    private double rating;

    public Seller(String name, double initialBalance, double rating) {
        super(name);
        this.balance = initialBalance;
        this.rating = rating;
    }

    public void addToCatalog(String itemName) {
        catalog.add(itemName);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public void deductFromBalance(double amount) throws InsufficientFundsException {
        if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient funds for seller " + getName() + ". Available: $" + balance + ", Required: $" + amount);
        }
        this.balance -= amount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Set<String> getCatalog() {
        return catalog;
    }

    @Override
    public void identifyRole() {
        System.out.println("Role: Seller | Name: " + getName() + " | Rating: " + rating + " | Balance: $" + balance + " | Unique Items for sale: " + catalog.size());
    }
}