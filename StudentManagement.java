import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    public static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        students.add(new Student(name, roll, dept));
        System.out.println("Student Added Successfully!\n");
    }

    // View Students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.\n");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    public static void searchStudent() {
        System.out.print("Enter Roll No to Search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.getRollNo() == roll) {
                s.display();
                return;
            }
        }
        System.out.println("Student Not Found.\n");
    }

    // Delete Student
    public static void deleteStudent() {
        System.out.print("Enter Roll No to Delete: ");
        int roll = sc.nextInt();

        students.removeIf(s -> s.getRollNo() == roll);
        System.out.println("Student Deleted (if existed).\n");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

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
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!\n");
            }
        }
    }
}