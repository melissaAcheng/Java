// Test file that has the main method and runs the code

import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {
        
    /* 
      You will need add 1 line to this file to create an instance 
      of the CafeUtil class. 
      Hint: it will need to correspond with the variable name used below..
    */
        CafeUtil appTest = new CafeUtil();
    	
        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week %d: %s \n\n", appTest.getStreakGoal(15), 15);
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");

        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(1.50);
        prices.add(3.50);
        prices.add(4.50);
        prices.add(3.50);

        appTest.displayMenu(menu, prices);
    
        // System.out.println("\n----- Add Customer Test-----");
        // ArrayList<String> customers = new ArrayList<String>();
        // // --- Test 4 times ---
        // for (int i = 0; i < 4; i++) {
        //     appTest.addCustomer(customers);
        //     System.out.println("\n");
        // }

        System.out.println("\n----- Print Price Chart Test-----");
        ArrayList<Double> priceChart = new ArrayList<Double>();
        String product = "Columbian Coffee Grounds";
        double price = 2.00;
        int maxQuantity = 4;
        appTest.printPriceChart(product, price, maxQuantity);

        System.out.println("\n----- Barista Adding Customers List Test-----");
        ArrayList<String> newCustomers = new ArrayList<String>();
        appTest.addCustomers(newCustomers); 






    }
}

