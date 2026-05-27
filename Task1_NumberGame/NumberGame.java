import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean keepPlaying = true;

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"); 
        System.out.println("  Welcome to Number Game - Guess the Secret Number!");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // Asking player name
        System.out.print("Before we start, what's your Good name? ");
        String playerName = sc.nextLine();

        int bestScore = 0;

        while (keepPlaying) {

            System.out.println("\nAlright " + playerName + ", choose your difficulty Level:");

            System.out.println("1. Easy level   (10 tries)");
            System.out.println("2. Medium level (7 tries)");
            System.out.println("3. Hard level   (5 tries)");

            System.out.print(" Your choice is : ");

            // Difficulty input validation
            while (!sc.hasNextInt()) {

                System.out.print("Please enter 1, 2, or 3: ");
                sc.next();
            }

            int difficulty = sc.nextInt();

            while (difficulty < 1 || difficulty > 3) {

                System.out.print(" Pick only 1, 2, or 3: ");
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
            System.out.println("Let's see if you can crack it!good luck!");

            for (int attempt = 1; attempt <= maxTries; attempt++) {

                System.out.println("\n------------------------------------");
                System.out.print("Guess #" + attempt + ": ");

                // Guess input validation
                while (!sc.hasNextInt()) {

                    System.out.print("Try again! Please enter a valid number: ");
                    sc.next();
                }

                int guess = sc.nextInt();

                // Correct Guess
                if (guess == secretNumber) {

                    System.out.println("\n🎉 Congratulations!");
                    System.out.println("You guessed correctly!You are a true number detective!");

                    int roundPoints = (maxTries - attempt + 1) * 10;

                    totalScore += roundPoints;

                    if (totalScore > bestScore) {

                        bestScore = totalScore;
                    }

                    System.out.println("You earned " + roundPoints + " points!");

                    guessedIt = true;

                    break;

                } else if (guess < secretNumber) {

                    System.out.println("Too low! Think bigger number.");

                    // Hint system
                    if (secretNumber - guess <= 10) {

                        System.out.println("Hint: You're close 👀");
                    }

                } else {

                    System.out.println("Too high! Think smaller number.");

                    // Hint system
                    if (guess - secretNumber <= 10) {

                        System.out.println("Hint for you : you're close 👀 !");
                    }
                }

                System.out.println("Remaining tries: " + (maxTries - attempt));
            }

            // Losing condition
            if (!guessedIt) {

                System.out.println("\n Unlucky this time!Try again to crack the code!");
                System.out.println("The secret number was: " + secretNumber);
            }

            // Score section
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(" Your Current Score : " + totalScore);
            System.out.println(" Your Best Score    : " + bestScore);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

            // Replay option
            System.out.print("\nWanna play another round and want to try again?\n Type YES to continue: ");

            String answer = sc.next();

            keepPlaying = answer.equalsIgnoreCase("YES");
        }

        // Ending message
        System.out.println("\n====================================");
        System.out.println("         THE GAME IS OVER");
        System.out.println("====================================");
        System.out.println("Player Name : " + playerName);
        System.out.println("Final Score : " + totalScore);
        System.out.println("Best Score  : " + bestScore);
        System.out.println("Thanks for playing, Please come back again, " + playerName + "!");
        System.out.println("See you next time!👋");
        System.out.println("====================================");

        sc.close();
    }
}