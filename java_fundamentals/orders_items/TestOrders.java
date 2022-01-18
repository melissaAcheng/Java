import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        
        // Create 4 item variables of type Item and instantiate each as an Item object. Name them item1, item2 etc.
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 4.5;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 4.0;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 3.5;
        
        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 3.25;

        // Create 4 order variables of type Order and instantiate each as an Order object. Name them order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        System.out.println(order1);

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";
        

        // Application Simulations
        System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Order: %s\n", order1.items);
        // System.out.printf("Ready: %s\n", order1.ready);

        // Add item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
        order2.total += item1.price;

        System.out.printf("Order2 : %s\n", order2.items); // prints out object
        System.out.printf("Order2 Total: $%.2f\n", order2.total);

        // order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
        order3.items.add(item4);
        order3.total += item4.price;
        System.out.printf("Order3 Total: $%.2f\n", order3.total);

        // order4 ordered a latte
        order4.items.add(item2);
        order4.total += item2.price;
        System.out.printf("Order4 Total: $%.2f\n", order4.total);

        // order1 is now ready
        order1.ready = true;

        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += ((item2.price)*2);
        System.out.printf("Order4 Total: $%.2f\n", order4.total);

        // Jimmy's order is now ready
        order2.ready = true;

    }
}
