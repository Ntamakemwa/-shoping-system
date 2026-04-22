import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {

    private List<String> history;

    public Buyer(String name) {
        super(name);
        this.history = new ArrayList<>();
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

    @Override
    public void identifyRole() {
        System.out.println("Role: Buyer | Name: " + getName() + " | Action: Browsing Marketplace");
    }
}