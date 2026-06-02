import java.util.Scanner;

public class ATMInterface {
    private static final String CURRENCY = "₹";
    private static int transactionCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double balance = 10000.00;
        boolean isRunning = true;

        printWelcomeMessage();

        while (isRunning) {

            printMenu();

            int choice = readMenuChoice(scanner);

            switch (choice) {

                case 1:
                    checkBalance(balance);
                    break;

                case 2:
                    balance = depositMoney(scanner, balance);
                    break;

                case 3:
                    balance = withdrawMoney(scanner, balance);
                    break;

                case 4:
                    isRunning = false;
                    printExitMessage(balance);
                    break;

                default:
                    System.out.println("Please select a valid option from the menu.");
            }
        }

        scanner.close();
    }

    private static void printWelcomeMessage() {

        System.out.println("========================================");
        System.out.println("          WELCOME TO SMART ATM");
        System.out.println("========================================");
        System.out.println("Your simple and secure banking assistant.");
    }

    private static void printMenu() {

        System.out.println();
        System.out.println("============== ATM MENU ===============");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.println("========================================");
    }

    private static int readMenuChoice(Scanner scanner) {

        while (true) {

            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println("Invalid input. Please enter a number from 1 to 4.");
            scanner.next();
        }
    }

    private static void checkBalance(double balance) {

        System.out.println();
        System.out.printf("Available Balance: %s%.2f%n", CURRENCY, balance);
    }

    private static double depositMoney(Scanner scanner, double balance) {

        double amount = readAmount(scanner, "Enter deposit amount: " + CURRENCY);

        if (amount <= 0) {

            System.out.println("Deposit amount must be greater than zero.");
            return balance;
        }

        balance += amount;
        transactionCount++;

        System.out.printf("%s%.2f deposited successfully.%n", CURRENCY, amount);
        System.out.printf("Updated Balance: %s%.2f%n", CURRENCY, balance);

        return balance;
    }

    private static double withdrawMoney(Scanner scanner, double balance) {

        double amount = readAmount(scanner, "Enter withdrawal amount: " + CURRENCY);

        if (amount <= 0) {

            System.out.println("Withdrawal amount must be greater than zero.");
            return balance;
        }

        if (amount > balance) {

            System.out.println("Transaction failed. Insufficient balance.");
            System.out.printf("Available Balance: %s%.2f%n", CURRENCY, balance);
            return balance;
        }

        balance -= amount;
        transactionCount++;

        System.out.printf("%s%.2f withdrawn successfully.%n", CURRENCY, amount);
        System.out.printf("Updated Balance: %s%.2f%n", CURRENCY, balance);

        return balance;
    }

    private static double readAmount(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }

            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.next();
        }
    }

    private static void printExitMessage(double balance) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Thank you for using Smart ATM.");
        System.out.println("Have a safe and wonderful day!");
        System.out.println("----------------------------------------");
        System.out.printf("Final Balance      : %s%.2f%n", CURRENCY, balance);
        System.out.println("Total Transactions : " + transactionCount);
        System.out.println("========================================");
    }
}