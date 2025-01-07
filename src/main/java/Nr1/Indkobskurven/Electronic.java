package Nr1.Indkobskurven;

public class Electronic extends Product {
    //Initialising private variables
    private String name;
    private int warrantyNoOfMonths;
    private double price;

    //Constructor
    public Electronic(String name, int warrantyNoOfMonths, double price) {
        this.name = name;
        this.warrantyNoOfMonths = warrantyNoOfMonths;
        this.price = price;
    }

    //Getter
    public int getWarrantyNoOfMonths() {
        return warrantyNoOfMonths;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ", " + warrantyNoOfMonths + " months warranty: " + getPrice() + " euro";
    }
}
