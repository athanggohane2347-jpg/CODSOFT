import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void updateDetails(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void display() {
        System.out.println("----------------------------------------");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Course     : " + course);
    }
}

public class StudentManagementSystem {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        showWelcomeMessage();

        while (isRunning) {
            showMenu();

            int choice = getValidInteger("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    isRunning = false;
                    System.out.println("\nClosing Student Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option from 1 to 6.");
            }
        }

        scanner.close();
    }

    private static void showWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("Manage student records quickly and clearly.");
    }

    private static void showMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    private static void addStudent() {
        int id = getValidInteger("Enter Student ID: ");

        if (findStudentById(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        String name = getValidText("Enter Name: ");
        int age = getValidInteger("Enter Age: ");
        String course = getValidText("Enter Course: ");

        students.add(new Student(id, name, age, course));

        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\nStudent Records:");
        for (Student student : students) {
            student.display();
        }
    }

    private static void searchStudent() {
        int id = getValidInteger("Enter Student ID to search: ");
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nStudent Found:");
        student.display();
    }

    private static void updateStudent() {
        int id = getValidInteger("Enter Student ID to update: ");
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = getValidText("Enter New Name: ");
        int age = getValidInteger("Enter New Age: ");
        String course = getValidText("Enter New Course: ");

        student.updateDetails(name, age, course);

        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        int id = getValidInteger("Enter Student ID to delete: ");
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully.");
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    private static int getValidInteger(String message) {
        System.out.print(message);

        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }

    private static String getValidText(String message) {
        System.out.print(message);
        String value = scanner.nextLine().trim();

        while (value.isEmpty()) {
            System.out.print("This field cannot be empty. Please enter again: ");
            value = scanner.nextLine().trim();
        }

        return value;
    }
}