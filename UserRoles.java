
class Seller extends User {
    public Seller(String name) {
        super(name);
    }

    @Override
    public void identifyRole() {
        System.out.println("Role: Seller | Name: " + getName() + " | Action: Managing Inventory");
    }
}
class Buyer extends User {
    public Buyer(String name) {
        super(name);
    }
    @Override
    public void identifyRole() {
        System.out.println("Role: Buyer | Name: " + getName() + " | Action: Browsing Marketplace");
    }
}
