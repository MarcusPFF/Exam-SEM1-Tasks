package Nr1.Indkobskurven;

public class Food extends Product {
    //Initialising private variables
    private String name;
    private int expireDate;
    private double price;

    //Constructor
    public Food(String name, int expireDate, double price) {
        this.name = name;
        this.expireDate = expireDate;
        this.price = price;

    }

    //Getter
    public int getExpireDate() {
        return expireDate;
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
        return getName() + ", " + expireDate + " January 2025: " + getPrice() + " euro";
    }

}

