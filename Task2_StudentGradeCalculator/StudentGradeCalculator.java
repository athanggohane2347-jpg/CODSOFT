package Task2_StudentGradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        printHeader();

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine().trim();

        while (studentName.isEmpty()) {
            System.out.print("Student name cannot be empty. Please enter the name: ");
            studentName = scanner.nextLine().trim();
        }

        int subjectCount = readPositiveNumber(scanner, "Enter number of subjects: ");

        int totalMarks = 0;

        for (int i = 1; i <= subjectCount; i++) {
            int marks = readMarks(scanner, "Enter marks for Subject " + i + " (0-100): ");
            totalMarks += marks;
        }

        double percentage = (double) totalMarks / subjectCount;

        String grade = calculateGrade(percentage);

        String remark = getRemark(grade);

        printResult(
                studentName,
                subjectCount,
                totalMarks,
                percentage,
                grade,
                remark);

        scanner.close();
    }

    private static void printHeader() {

        System.out.println("========================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("========================================");
        System.out.println("Let's calculate the student's performance.");
        System.out.println();
    }

    private static int readPositiveNumber(Scanner scanner, String message) {

        int number;

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                number = scanner.nextInt();

                if (number > 0) {
                    return number;
                }

                System.out.println("Number of subjects must be greater than 0.");

            } else {

                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static int readMarks(Scanner scanner, String message) {

        int marks;

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                marks = scanner.nextInt();

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println("Marks should be between 0 and 100.");

            } else {

                System.out.println("Invalid input. Please enter numeric marks only.");
                scanner.next();
            }
        }
    }

    private static String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    private static String getRemark(String grade) {

        switch (grade) {

            case "A+":
                return "Outstanding performance!";

            case "A":
                return "Excellent work!";

            case "B":
                return "Very good effort!";

            case "C":
                return "Good, but there is room to improve.";

            case "D":
                return "Needs more practice and focus.";

            default:
                return "Work harder and do not give up.";
        }
    }

    private static void printResult(
            String studentName,
            int subjectCount,
            int totalMarks,
            double percentage,
            String grade,
            String remark) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("              REPORT CARD");
        System.out.println("========================================");
        System.out.println("Student Name     : " + studentName);
        System.out.println("Subjects         : " + subjectCount);
        System.out.println("Total Marks      : " + totalMarks + " / " + (subjectCount * 100));
        System.out.printf("Percentage       : %.2f%%\n", percentage);
        System.out.println("Grade            : " + grade);
        System.out.println("Remark           : " + remark);
        System.out.println("========================================");
    }
}