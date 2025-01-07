package Nr5.FindChauffor;
import java.util.Scanner;

public class TextUI {
    private Scanner scan;

    public TextUI() {
        scan = new Scanner(System.in);
    }


    public int promptNumeric(String msg) {
        System.out.println(msg);
        String input = scan.nextLine();
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please type a number");
            number = promptNumeric(msg);
        }
        return number;
    }
    //Good for switch cases
    public int promptNumeric(String msg, int min, int max) {
        int number = promptNumeric(msg);
        if (number < min || number > max) {
            return promptNumeric("Pick number between " + min + " and " + max, min, max);
        } else {
            return number;
        }
    }

    public String promptText(String msg) {
        System.out.println(msg);
        String input = scan.nextLine();
        return input;
    }
}
