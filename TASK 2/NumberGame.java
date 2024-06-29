import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int score = 0;
        int roundsWon = 0;
        int totalAttempts = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // generate a random number between 1 and 100
            int attempts = 0;

            System.out.println("Welcome to the Number Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have 6 attempts to guess the number.");

            while (attempts < 6) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println(" Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += 6 - attempts;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == 6) {
                System.out.println("Sorry, you didn't guess the number. The correct answer was " + numberToGuess);
            }

            totalAttempts += attempts;

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }

        System.out.println("Game over!");
        System.out.println("Your final score is " + score + " out of " + totalAttempts);
        System.out.println("You won " + roundsWon + " rounds.");
    }
}