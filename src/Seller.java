class Seller extends User {
    public Seller(String name) {

        super(name);
    }
    @Override
    public void identifyRole() {
        System.out.println("Role: Seller | Name: " + getName() + " | Action: Managing Inventory");
    }
}

