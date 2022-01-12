// All methods go in this file
import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {
    // Sum together every consecutive integer from 1 to 10 
    // Return the Sum

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    // Loop through an array of item prices
    // Sum the prices
    // Return the total

    public double getOrderTotal(double[] lineItems) {
        double total = 0;
        for (int i = 0; i < lineItems.length; i++) {
            total += lineItems[i];
        }
        return total;
    }

    // Loop through ArrayList
    // Print out the index and menu item
    public boolean displayMenu(ArrayList<String> menu, ArrayList<Double> prices) {
        
        if (menu.size() != prices.size()) {
            return false;
        } else {
            for (int i = 0; i < menu.size(); i++) {
                System.out.printf("%d %s -- $%.2f\n", i, menu.get(i), prices.get(i));
            }
            return true;
        }
    }
    
    public void addCustomer(ArrayList<String> customers) {
        // Collect user input name and store in variable userName
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();

        // Print userName to the console  
        System.out.printf("Hello, %s\n", userName);

        // Print number of items currently in array
        System.out.printf("There are %d people in front of you.\n", customers.size());

        // Add customer's name to the array
        customers.add(userName);

        // Print array
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        // Print the product name
        System.out.println(product);

        // Loop through array
            // Print the cost for buying 1, etc. and the price
        System.out.printf("1 - $%.2f\n", price);

        double totalCost = price;
        for (int i = 1; i < maxQuantity; i++) {
            totalCost += (price-0.5);
            if (i > 0) {
                System.out.printf("%d - $%.2f\n",(i+1), totalCost);
            }
        }        
    }

    // Hint: You can use a while loop and ask the user to type "q" when they are finished entering names.
    public void addCustomers(ArrayList<String> customerList) {
        boolean finished = false;
        String input;
        while(!finished) {
            System.out.println("Please enter a customer name or press q to quit:");
            input = System.console().readLine();
            if (input.equals("q") || input.equals("Q")) {
                finished = true;
                return;
            }
            customerList.add(input);
            System.out.printf("%s was added to the list.", input);
            System.out.println(customerList);
        }
        
    }


}
