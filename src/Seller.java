import java.util.HashSet;
import java.util.Set;

class Seller extends User {

    private Set<String> catalog = new HashSet<>();

    public Seller(String name) {
        super(name);
    }

    public void addToCatalog(String itemName) {
        catalog.add(itemName);
    }

    @Override
    public void identifyRole() {
        System.out.println("Role: Seller | Name: " + getName() + " | Unique Items for sale: " + catalog.size());
    }
}