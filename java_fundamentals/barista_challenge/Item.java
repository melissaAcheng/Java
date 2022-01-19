class Item {
    private String name;
    private double price;

    // getter
    public String getItemName() {
        return name;
    }

    // setter
    public void setItemName(String name) {
        this.name = name;
    }

    // getter
    public double getPrice() {
        return price;
    }

    // setter
    public void setPrice(double price) {
        this.price = price;
    }

    // Add a constructor to your Item class that takes a String name and double price as arguments to set the name and price for that object on instantiation.
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    

}
