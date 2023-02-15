import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //winning numbers in range 1 ot 49
        List<Integer> winningNumbers = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            while (true) {
                int winingNumber = random.nextInt(49) + 1; //range 1 ot 49
                if (!winningNumbers.contains(winingNumber)) {
                    winningNumbers.add(winingNumber);
                    break;
                }
            }
        }
        //  System.out.println(winningNumbers);

        System.out.println("Please enter your 6 numbers between 1 and 49 (inclusive)");

        Scanner scanner = new Scanner(System.in);
        List<Integer> guessedNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            System.out.println("Your current numbers are " + guessedNumbers);
            System.out.println("Please enter a number (1-49):");
            while (true) {
                try {
                    String numbersSting = scanner.nextLine();
                    int number = Integer.parseInt(numbersSting);
                    if (number >= 1 && number <= 49) {
                        guessedNumbers.add(number);
                        break;
                    } else {
                        System.out.println(number + " is not between 1 and 49. Please try again.");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("That's not a number ! Please try again.");
                }
            }
        }

        System.out.println("The winning numbers were: " + winningNumbers);
        System.out.println("Your numbers are: " + guessedNumbers);

        guessedNumbers.retainAll(winningNumbers);

        System.out.println("Your matched numbers are: " + guessedNumbers);

        if (guessedNumbers.containsAll(winningNumbers)) {
            System.out.println("Congratulations you win!");
        } else {
            System.out.println("Sorry, you lost.");
        }

        scanner.close();
    }
}
