import java.util.Random;
import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);

        boolean playAgain = true;

        System.out.println("Welcome to the Craps Game!");

        while (playAgain) {
            // Roll the two dice
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("\nInitial Roll:");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + sum);

            // Check the initial roll
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                // Establish the point
                int point = sum;
                System.out.println("The point is " + point + ".");

                boolean gameOver = false;

                while (!gameOver) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("\nTrying for point:");
                    System.out.println("Die 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        gameOver = true;55
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        gameOver = true;
                    } else {
                        System.out.println("Trying for point " + point + "...");
                    }
                }
            }

            // Ask whether to play another game
            System.out.print("\nPlay again? (y/n): ");
            String answer = input.nextLine().trim();
            playAgain = answer.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing Craps!");
        input.close();
    }
}