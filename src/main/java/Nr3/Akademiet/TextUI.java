package Nr3.Akademiet;

//Import libraries

import java.util.Scanner;

public class TextUI {
    //Initialising new scanner object
    private final Scanner scanner = new Scanner(System.in);

    //Method for displaying a message
    public void displayMsg(String message) {
        System.out.println(message);
    }

    //Method for asking the user for input (text)
    public String promptText(String message) {
        displayMsg(message);
        return scanner.nextLine().trim();
    }

    //Method for asking the user for input (numeric)
    public int promptNumeric(String msg) {
        System.out.println(msg);
        String input = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            displayMsg("Please type a number");
            number = promptNumeric(msg);
        }
        return number;
    }
}