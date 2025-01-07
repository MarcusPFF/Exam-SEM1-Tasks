package Nr1.Indkobskurven;

//Import libraries

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basket {
    //Declaring private variables
    private List<Product> products;
    private List<Product> basket;
    private Scanner scanner;

    //Constructor
    public Basket() {
        //Initializing the variables as an ArrayList
        this.products = new ArrayList<>();
        this.basket = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    //Method to with a while (running) loop. As long as running = true the program continues.
    public void runProgram() {
        //Declaring local variables
        int numberGoingUp;
        int itemChoice;
        boolean running = true;

        //Loading the products into
        loadProducts();
        while (running) {
            // Prints out options in the console
            System.out.println("------Marcus Online Shopping------");
            System.out.println("1. Shop items");
            System.out.println("2. Your basket");
            System.out.println("3. Remove item from basket");
            System.out.println("4. Exit");

            //Scans for user input
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //Give options to user
                    System.out.println("Which category would you like to look at?");
                    System.out.println("1. Clothes");
                    System.out.println("2. Electronics");
                    System.out.println("3. Food");
                    System.out.println("4. Back");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();
                    //Switch with different category choices
                    switch (categoryChoice) {
                        case 1:
                            System.out.println("----Clothes----");
                            System.out.println("      Name, Color, Size, Price");
                            numberGoingUp = 1;
                            for (Product product : products) {
                                if (product instanceof Clothes) {
                                    System.out.println(numberGoingUp + ". " + product);
                                    numberGoingUp++;
                                }
                            }

                            // Ask user to choose an item
                            System.out.println("Please choose an item by number:");
                            itemChoice = scanner.nextInt();
                            scanner.nextLine();
                            String Clothes = "Clothes";
                            addItemToBasket(itemChoice, Clothes);
                            break;

                        case 2:
                            System.out.println("----Electronics----");
                            System.out.println("      Name, WarrantyOfMonths, Price");
                            numberGoingUp = 1;
                            for (Product product : products) {
                                if (product instanceof Electronic) {
                                    System.out.println(numberGoingUp + ". " + product);
                                    numberGoingUp++;
                                }
                            }
                            // Ask user to choose an item
                            System.out.println("Please choose an item by number:");
                            itemChoice = scanner.nextInt();
                            scanner.nextLine();
                            String Electronics = "Electronics";
                            addItemToBasket(itemChoice, Electronics);
                            break;

                        case 3:
                            System.out.println("----Food----");
                            System.out.println("      Name, Expiry Date, Price");
                            numberGoingUp = 1;
                            for (Product product : products) {
                                if (product instanceof Food) {
                                    System.out.println(numberGoingUp + ". " + product);
                                    numberGoingUp++;
                                }
                            }
                            // Ask user to choose an item
                            System.out.println("Please choose an item by number:");
                            itemChoice = scanner.nextInt();
                            scanner.nextLine();
                            String Food = "Food";
                            addItemToBasket(itemChoice, Food);
                            break;

                        case 4:
                            //back button
                            break;
                    }
                    break;

                case 2:
                    //Show your basket
                    if (basket.isEmpty()) {
                        System.out.println("There are no items in your basket");
                    } else {
                        viewBasket();
                    }
                    break;

                case 3:
                    //Showing your basket and letting you choose which items to delete
                    if (basket.isEmpty()) {
                        System.out.println("There are no items in your basket");
                    } else {
                        System.out.println("Your basket contains:");
                        numberGoingUp = 1;
                        for (Product product : basket) {
                            System.out.println(numberGoingUp + ". " + product);
                            numberGoingUp++;
                        }
                        System.out.println("Please choose the item you want to remove from your basket by number");
                        itemChoice = scanner.nextInt();
                        scanner.nextLine();
                        removeItemFromBasket(itemChoice);
                    }
                    break;

                case 4:
                    //Exiting
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //Method to loadProducts into product ArrayList when program runs
    public void loadProducts() {
        // Adding Clothes to the products list
        products.add(new Clothes("Sweater", "grey", "M", 35.50));
        products.add(new Clothes("Jacket", "navy", "L", 120.00));
        products.add(new Clothes("Jeans", "blue", "S", 60.00));
        products.add(new Clothes("Dress", "red", "M", 75.00));
        products.add(new Clothes("Shorts", "beige", "L", 30.00));
        products.add(new Clothes("Socks", "black", "M", 5.50));
        products.add(new Clothes("Skirt", "black", "S", 40.00));
        products.add(new Clothes("Blouse", "white", "L", 50.00));
        products.add(new Clothes("Coat", "brown", "XL", 150.00));
        products.add(new Clothes("Scarf", "purple", "M", 12.50));

        // Adding Electronics to the products list
        products.add(new Electronic("Smartphone", 24, 799.99));
        products.add(new Electronic("Smartwatch", 18, 199.99));
        products.add(new Electronic("Bluetooth Speaker", 12, 45.00));
        products.add(new Electronic("Laptop", 36, 1200.00));
        products.add(new Electronic("Smart TV", 24, 500.00));
        products.add(new Electronic("Camera", 18, 350.00));
        products.add(new Electronic("Keyboard", 24, 80.00));
        products.add(new Electronic("Mouse", 12, 25.00));
        products.add(new Electronic("Charger", 6, 15.00));
        products.add(new Electronic("Smart Glasses", 24, 350.00));

        // Adding Foods to the products list
        products.add(new Food("Bread", 3, 2.50));
        products.add(new Food("Apple", 7, 1.00));
        products.add(new Food("Banana", 5, 0.60));
        products.add(new Food("Chicken", 12, 5.00));
        products.add(new Food("Rice", 24, 2.80));
        products.add(new Food("Cereal", 18, 4.50));
        products.add(new Food("Yogurt", 10, 3.20));
        products.add(new Food("Orange", 6, 1.20));
        products.add(new Food("Pasta", 36, 1.50));
        products.add(new Food("Tomato", 7, 2.00));
    }

    //Method for adding an item to the basket. Taking to paramters (int itemChoice , String category)
    public void addItemToBasket(int itemChoice, String category) {
        int adduktion = 1;
        for (Product product : products) {
            if (product instanceof Clothes) {
                if (adduktion == itemChoice && category.equals("Clothes")) {
                    if (!basket.contains(product)) {
                        basket.add(product);
                        System.out.println("Added to basket: " + product);
                        return;
                    }
                }
                adduktion++;
            }
        }

        adduktion = 1;
        for (Product product : products) {
            if (product instanceof Electronic) {
                if (adduktion == itemChoice && category.equals("Electronics")) {
                    if (!basket.contains(product)) {
                        basket.add(product);
                        System.out.println("Added to basket: " + product);
                        return;
                    }
                }
                adduktion++;
            }
        }

        adduktion = 1;
        for (Product product : products) {
            if (product instanceof Food) {
                if (adduktion == itemChoice && category.equals("Food")) {
                    if (!basket.contains(product)) {
                        basket.add(product);
                        System.out.println("Added to basket: " + product);
                        return;
                    }
                }
                adduktion++;
            }
        }
        System.out.println("Invalid choice. Please try again.");
    }

    /* Method for viewing the current basket and then calling a calcTotal(basket) method
    to calculate the value of the basket
     */
    public void viewBasket() {
        System.out.println("Your basket contains:");
        for (Product product : basket) {
            System.out.println(product);
        }
        calcTotal(basket);
    }

    //Method to removing an item from the basket, taking (int itemChoice) has a parameter
    public void removeItemFromBasket(int itemChoice) {
        if (itemChoice >= 1 && itemChoice <= basket.size()) {
            Product product = basket.get(itemChoice - 1);
            basket.remove(product);
            System.out.println("Removed item: " + product);
        } else {
            System.out.println("Invalid item choice. Please try again.");
        }
    }

    //calc total method
    public void calcTotal(List<Product> basket) {
        double total = 0;
        for (Product product : basket) {
            total = total + product.getPrice();
        }
        System.out.println("Total basket price: " + total + " euro");
    }
}
