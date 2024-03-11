/*
TASK 1

NUMBER GAME

1. Generate a random number within a specified range, such as 1 to 100.

2. Prompt the user to enter their guess for the generated number.

3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.

4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.

*/

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Game!");

        boolean playAgain = true;
        int totalAttempts = 0;
        int totalRounds = 0;
        int roundsWon = 0; // Move this line outside the loop

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nNew Round! Try to guess the number between 1 and 100.");

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    roundsWon++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            totalAttempts += attempts;
            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Rounds Won: " + roundsWon);

        scanner.close();
    }
}
