import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("====================================");
        System.out.println("     🎮 NUMBER GUESSING GAME 🎮");
        System.out.println("====================================");

        while (playAgain) {

            int randomNumber = random.nextInt(100) + 1;
            int attempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\n🔢 I have selected a number between 1 and 100.");
            System.out.println("🧠 You have only 5 attempts to guess it!");

            for (int i = 1; i <= attempts; i++) {

                System.out.println("\n------------------------------------");
                System.out.print("👉 Enter your guess: ");

                int guess;

                // Input Validation
                while (!sc.hasNextInt()) {
                    System.out.print("❌ Invalid input! Enter a number: ");
                    sc.next();
                }

                guess = sc.nextInt();

                // Check Guess
                if (guess == randomNumber) {

                    System.out.println("🎉 Correct! You guessed the number!");
                    System.out.println("🏆 You won this round!");

                    totalScore += (attempts - i + 1) * 10;

                    guessedCorrectly = true;
                    break;

                } else if (guess < randomNumber) {

                    System.out.println("📉 Too LOW!");

                } else {

                    System.out.println("📈 Too HIGH!");
                }

                System.out.println("❤️ Attempts left: " + (attempts - i));
            }

            // If user loses
            if (!guessedCorrectly) {

                System.out.println("\n💀 You lost this round!");
                System.out.println("🔐 The correct number was: " + randomNumber);
            }

            // Display Score
            System.out.println("\n⭐ Current Score: " + totalScore);

            // Play Again Option
            System.out.println("\nDo you want to play again?");
            System.out.print("Type YES to continue or NO to exit: ");

            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        // Final Message
        System.out.println("\n====================================");
        System.out.println(" 🎯 FINAL SCORE: " + totalScore);
        System.out.println(" 🙌 Thanks for playing!");
        System.out.println("====================================");

        sc.close();
    }
}