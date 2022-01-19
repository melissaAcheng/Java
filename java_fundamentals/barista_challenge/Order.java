import java.util.ArrayList;

class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;
    

    // Add a constructor to your Order class that takes no arguments, but sets the name to "Guest" and initializes the items array to an empty ArrayList<Item>
    public Order() {
        this("Guest");

        //
        //this.name = "Guest";
        //this.items = new ArrayList<Item>();
    }

    // Add an overloaded constructor for Order that takes String name as an argument, so you can create an instance with a name.
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    // Getter
    public String getOrderName() {
        return name;
    }

    // Setter
    public void setOrderName(String name) {
        this.name = name;
    }

    // Getter
    public boolean isReady() {
        return ready;
    }

    // Setter
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    // Create a method called addItem that takes an Item object as an argument and adds the item to the order's items array.

    public void addItem(Item item) {
        items.add(item);
    }

    // Create a method called getStatusMessage that returns a String message. 
    public String getStatusMessage() {
        if(ready) {
            return ("Your order is ready");
        } else {
            return ("Thank you for waiting. Your order will be ready soon");
        }
    }

    // Create a method called display that prints out the order information
    public void display() {
        System.out.printf("Customer Name: %s\n", this.name);
            for (int i = 0; i < items.size(); i++) {
                System.out.printf("%s - $%.2f\n", items.get(i).getItemName(), items.get(i).getPrice());
            }
        System.out.print("------------------------------\n");
    }

    // Create a method called getOrderTotal that sums together each of the item's prices, and returns the total amount. 
    public double getOrderTotal() {

        double totalAmount = 0;

        for (int i = 0; i < items.size(); i++) {
            totalAmount += items.get(i).getPrice();
        }
        return totalAmount;
    }

}

