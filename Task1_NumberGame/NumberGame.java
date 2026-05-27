import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean keepPlaying = true;

        System.out.println("====================================");
        System.out.println("  Hey there! Welcome to Number Game");
        System.out.println("====================================");

        // Asking player name
        System.out.print("Before we start, what's your name? ");
        String playerName = sc.nextLine();

        int bestScore = 0;

        while (keepPlaying) {

            System.out.println("\nAlright " + playerName + ", choose your difficulty:");

            System.out.println("1. Easy Mode   (10 tries)");
            System.out.println("2. Medium Mode (7 tries)");
            System.out.println("3. Hard Mode   (5 tries)");

            System.out.print("Your choice: ");

            // Difficulty input validation
            while (!sc.hasNextInt()) {

                System.out.print("Please enter 1, 2, or 3: ");
                sc.next();
            }

            int difficulty = sc.nextInt();

            while (difficulty < 1 || difficulty > 3) {

                System.out.print("Oops! Pick only 1, 2, or 3: ");
                difficulty = sc.nextInt();
            }

            int maxTries;

            if (difficulty == 1) {

                maxTries = 10;

            } else if (difficulty == 2) {

                maxTries = 7;

            } else {

                maxTries = 5;
            }

            int secretNumber = random.nextInt(100) + 1;

            boolean guessedIt = false;

            System.out.println("\nI've picked a secret number between 1 and 100.");
            System.out.println("Let's see if you can crack it!");

            for (int attempt = 1; attempt <= maxTries; attempt++) {

                System.out.println("\n------------------------------------");
                System.out.print("Guess #" + attempt + ": ");

                // Guess input validation
                while (!sc.hasNextInt()) {

                    System.out.print("That doesn't look like a number. Try again: ");
                    sc.next();
                }

                int guess = sc.nextInt();

                // Correct Guess
                if (guess == secretNumber) {

                    System.out.println("\n🎉 Congratulations!");
                    System.out.println("You guessed the number correctly!");

                    int roundPoints = (maxTries - attempt + 1) * 10;

                    totalScore += roundPoints;

                    if (totalScore > bestScore) {

                        bestScore = totalScore;
                    }

                    System.out.println("You earned " + roundPoints + " points!");

                    guessedIt = true;

                    break;

                } else if (guess < secretNumber) {

                    System.out.println("Too low! Try a bigger number.");

                    // Hint system
                    if (secretNumber - guess <= 10) {

                        System.out.println("Hint: You're super close 👀");
                    }

                } else {

                    System.out.println("Too high! Try a smaller number.");

                    // Hint system
                    if (guess - secretNumber <= 10) {

                        System.out.println("Hint: You're super close 👀");
                    }
                }

                System.out.println("Remaining tries: " + (maxTries - attempt));
            }

            // Losing condition
            if (!guessedIt) {

                System.out.println("\nAhhh unlucky this time!");
                System.out.println("The secret number was: " + secretNumber);
            }

            // Score section
            System.out.println("\n====================================");
            System.out.println("Current Score : " + totalScore);
            System.out.println("Best Score    : " + bestScore);
            System.out.println("====================================");

            // Replay option
            System.out.print("\nWanna play another round? Type YES to continue: ");

            String answer = sc.next();

            keepPlaying = answer.equalsIgnoreCase("YES");
        }

        // Ending message
        System.out.println("\n====================================");
        System.out.println("             GAME OVER");
        System.out.println("====================================");
        System.out.println("Player Name : " + playerName);
        System.out.println("Final Score : " + totalScore);
        System.out.println("Best Score  : " + bestScore);
        System.out.println("Thanks for playing, " + playerName + "!");
        System.out.println("Catch you next time 😄");
        System.out.println("====================================");

        sc.close();
    }
}