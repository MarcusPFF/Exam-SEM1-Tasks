package Nr1.Indkobskurven;

public class Clothes extends Product {
    //Initialising private variables
    private String name;
    private String color;
    private String size;
    private double price;

    //Constructor
    public Clothes(String name, String color, String size, double price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    //Getter
    public String getColor() {
        return color;

    }

    public String getSize() {
        return size;

    }

    public void setPrice(){
        if(price < 0){
            this.price = price;
        } else {
            System.out.println("Must be positive");
        }
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
        return getName() + ", " + color + ", " + "size " + size + ": " + getPrice() + " euro";
    }
}
