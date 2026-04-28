import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {

    private List<String> history;
    private double balance;

    public Buyer(String name, double initialBalance) {
        super(name);
        this.history = new ArrayList<>();
        this.balance = initialBalance;
    }

    public void recordPurchase(String item) {
        history.add(item);
    }

    public void viewHistory() {
        System.out.println("History for " + getName() + ": " + history);
    }

    public void showHistory() {
        System.out.println("History for " + getName() + ": " + history);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deductFromBalance(double amount) throws InsufficientFundsException {
        if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient funds for buyer " + getName() + ". Available: $" + balance + ", Required: $" + amount);
        }
        this.balance -= amount;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    @Override
    public void identifyRole() {
        System.out.println("Role: Buyer | Name: " + getName() + " | Balance: $" + balance + " | Action: Browsing Marketplace");
    }
}