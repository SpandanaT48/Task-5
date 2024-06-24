import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManagementSystem sms = new StudentManagementSystem();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine().trim();

        Student newStudent = new Student(name, rollNumber, grade);
        sms.addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        sms.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }

    private static void searchStudent() {
        System.out.print("Enter roll number of the student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        List<Student> students = sms.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("All Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
