public class TestOrders {
    public static void main(String[] args) {
        // Create 2 orders for unspecified guests (without speecifying a name)
        Order order1 = new Order();
        Order order2 = new Order();

        System.out.println(order1.getOrderName());
        System.out.println(order2.getOrderName());

        // Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 = new Order("Melissa");
        Order order4 = new Order("Thomas");
        Order order5 = new Order("Katie");

        System.out.println(order3.getOrderName());
        System.out.println(order4.getOrderName());
        System.out.println(order5.getOrderName());

        // Create 4 Items
        Item item1 = new Item("mocha", 4.5);
        Item item2 = new Item("latte", 4.0);
        Item item3 = new Item("drip coffee", 3.5);
        Item item4 = new Item("capuccino", 3.25);

        // Add at least 2 items to each of the orders using the addItem method you wrote
        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item1);
        order2.addItem(item3);
        order3.addItem(item2);
        order3.addItem(item3);
        order4.addItem(item3);
        order4.addItem(item4);
        order5.addItem(item1);
        order5.addItem(item4);

        // Call the display method on each of the orders
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        // Get the order totals
        System.out.printf("Order1 Total: $%.2f\n", order1.getOrderTotal());
        System.out.printf("Order2 Total: $%.2f\n", order2.getOrderTotal());
        System.out.printf("Order3 Total: $%.2f\n", order3.getOrderTotal());
        System.out.printf("Order4 Total: $%.2f\n", order4.getOrderTotal());
        System.out.printf("Order5 Total: $%.2f\n", order5.getOrderTotal());

        // Set order 1 to ready and print status message
        order1.setReady(true);
        System.out.println(order1.getStatusMessage());

    }
}
