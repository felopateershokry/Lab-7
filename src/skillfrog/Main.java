/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skillfrog;

/**
 *
 * @author Lenovo
 */
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CourseService service = new CourseService();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Course");
            System.out.println("2. Add Lesson");
            System.out.println("3. Edit Lesson");
            System.out.println("4. Edit Course");
            System.out.println("5. Delete Lesson");
            System.out.println("6. Delete Course");
            System.out.println("7. View Enrolled Students");
            System.out.println("8. Exit");

            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Course ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Description: ");
                    String desc = input.nextLine();

                    Course c = new Course(id, title, desc);
                    if (service.createCourse(c)) {
                        System.out.println("Course created!");
                    } else {
                        System.out.println("Faild");
                    }
                }

                case 2 -> {
                    System.out.print("Course ID: ");
                    int cid = input.nextInt();
                    System.out.print("Lesson ID: ");
                    int lid = input.nextInt();
                    input.nextLine();
                    System.out.print("Lesson Title: ");
                    String lTitle = input.nextLine();
                    System.out.print("Lesson Content: ");
                    String lContent = input.nextLine();

                    Lesson l = new Lesson(lid, lTitle, lContent);
                    if (service.addLesson(cid, l)) {
                        System.out.println("Lesson added!");
                    } else {
                        System.out.println("Faild");
                    }
                }

                case 3 -> {
                    System.out.print("Course ID: ");
                    int cid = input.nextInt();
                    System.out.print("Lesson ID: ");
                    int lid = input.nextInt();
                    input.nextLine();
                    System.out.print("New Lesson Title: ");
                    String lTitle = input.nextLine();
                    System.out.print("New Lesson Content: ");
                    String lContent = input.nextLine();

                    Lesson l = new Lesson(lid, lTitle, lContent);
                    if (service.editLesson(cid, lid, l)) {
                        System.out.println("Lesson updated!");
                    } else {
                        System.out.println("Faild");
                    }
                }
                case 4 -> {
                    System.out.print("Course ID to edit: ");
                    int cid = input.nextInt();
                    input.nextLine();
                    System.out.print("New Title: ");
                    String newTitle = input.nextLine();
                    System.out.print("New Description: ");
                    String newDesc = input.nextLine();

                    Course updatedCourse = new Course(cid, newTitle, newDesc);
                    if (service.updateCourse(cid, updatedCourse)) {
                        System.out.println("Course updated!");
                    } else {
                        System.out.println("Faild");
                    }
                }
                case 5 -> {
                    System.out.print("Course ID: ");
                    int cid = input.nextInt();
                    System.out.print("Lesson ID: ");
                    int lid = input.nextInt();
                    input.nextLine();

                    if (service.deleteLesson(cid, lid)) {
                        System.out.println("Lesson deleted!");
                    } else {
                        System.out.println("Faild");
                    }
                }

                case 6 -> {
                    System.out.print("Course ID: ");
                    int cid = input.nextInt();
                    input.nextLine();

                    if (service.deleteCourse(cid)) {
                        System.out.println("Course deleted!");
                    } else {
                        System.out.println("Faild");
                    }
                }

                case 7 -> {
                    System.out.print("Course ID: ");
                    int cid = input.nextInt();
                    input.nextLine();

                    List<String> students = service.getEnrolledStudents(cid);
                    if (students.isEmpty()) {
                        System.out.println("No enrolled students or course not found.");
                    } else {
                        System.out.println("Enrolled Students:");
                        for (String s : students) {
                            System.out.println("- " + s);
                        }
                    }
                }

                case 8 -> {
                    System.out.println("Exiting...");
                    input.close();
                    return;
                }

                default ->
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
