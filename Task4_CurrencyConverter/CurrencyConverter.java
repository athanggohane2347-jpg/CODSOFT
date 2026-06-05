import java.util.Scanner;

public class CurrencyConverter {

    private static final double INR_TO_USD = 0.012;
    private static final double INR_TO_EUR = 0.011;
    private static final double INR_TO_GBP = 0.0095;

    private static final double USD_TO_INR = 83.00;
    private static final double EUR_TO_INR = 90.00;
    private static final double GBP_TO_INR = 105.00;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        showWelcomeMessage();

        while (isRunning) {
            showMenu();

            int choice = getValidInteger(scanner, "Enter your choice: ");

            if (choice == 7) {
                isRunning = false;
                continue;
            }

            if (choice < 1 || choice > 7) {
                System.out.println("Invalid choice. Please select an option from 1 to 7.");
                continue;
            }

            double amount = getValidAmount(scanner, "Enter amount: ");
            convertCurrency(choice, amount);
        }

        System.out.println("\nThank you for using Currency Converter. Have a great day!");
        scanner.close();
    }

    private static void showWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("          CURRENCY CONVERTER");
        System.out.println("========================================");
        System.out.println("Convert currencies quickly and easily.");
    }

    private static void showMenu() {
        System.out.println("\nChoose Conversion:");
        System.out.println("1. INR to USD");
        System.out.println("2. INR to EUR");
        System.out.println("3. INR to GBP");
        System.out.println("4. USD to INR");
        System.out.println("5. EUR to INR");
        System.out.println("6. GBP to INR");
        System.out.println("7. Exit");
    }

    private static int getValidInteger(Scanner scanner, String message) {
        System.out.print(message);

        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private static double getValidAmount(Scanner scanner, String message) {
        System.out.print(message);

        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid amount: ");
            scanner.next();
        }

        double amount = scanner.nextDouble();

        while (amount <= 0) {
            System.out.print("Amount must be greater than zero. Enter again: ");

            while (!scanner.hasNextDouble()) {
                System.out.print("Please enter a valid amount: ");
                scanner.next();
            }

            amount = scanner.nextDouble();
        }

        return amount;
    }

    private static void convertCurrency(int choice, double amount) {
        double convertedAmount;
        String result;

        switch (choice) {
            case 1:
                convertedAmount = amount * INR_TO_USD;
                result = String.format("Converted Amount: $%.2f USD", convertedAmount);
                break;

            case 2:
                convertedAmount = amount * INR_TO_EUR;
                result = String.format("Converted Amount: €%.2f EUR", convertedAmount);
                break;

            case 3:
                convertedAmount = amount * INR_TO_GBP;
                result = String.format("Converted Amount: £%.2f GBP", convertedAmount);
                break;

            case 4:
                convertedAmount = amount * USD_TO_INR;
                result = String.format("Converted Amount: ₹%.2f INR", convertedAmount);
                break;

            case 5:
                convertedAmount = amount * EUR_TO_INR;
                result = String.format("Converted Amount: ₹%.2f INR", convertedAmount);
                break;

            case 6:
                convertedAmount = amount * GBP_TO_INR;
                result = String.format("Converted Amount: ₹%.2f INR", convertedAmount);
                break;

            default:
                result = "Invalid conversion option.";
        }

        System.out.println(result);
    }
}