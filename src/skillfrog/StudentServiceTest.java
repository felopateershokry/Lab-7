package skillfrog;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StudentServiceTest {

    public static void main(String[] args) {
        // -------------------------------
        // Reset JSON files for clean test
        // -------------------------------
        resetJsonFiles();

        // Initialize services
        StudentService studentService = new StudentService();
        CourseRepository courseRepo = new CourseRepository();

        // -------------------------------
        // Create students
        // -------------------------------
        Student alice = new Student(1, "Alice", "alice@example.com", "pass123");
        Student bob = new Student(2, "Bob", "bob@example.com", "pass456");
        studentService.addStudent(alice);
        studentService.addStudent(bob);

        // -------------------------------
        // Create courses with lessons
        // -------------------------------
        Course javaCourse = new Course(101, "Java Basics", "Intro to Java");
        javaCourse.getLessons().add(new Lesson(1, "Intro", "Welcome"));
        javaCourse.getLessons().add(new Lesson(2, "Variables", "Learn variables"));

        Course pythonCourse = new Course(102, "Python Basics", "Intro to Python");
        pythonCourse.getLessons().add(new Lesson(1, "Intro", "Welcome"));
        pythonCourse.getLessons().add(new Lesson(2, "Data Types", "Learn data types"));

        courseRepo.saveCourses(Arrays.asList(javaCourse, pythonCourse));

        // -------------------------------
        // Test available courses
        // -------------------------------
        System.out.println("\nAvailable courses for Alice:");
        studentService.getAvailbleCourses(1).forEach(c -> System.out.println(c.getId() + ": " + c.getTitle()));

        // -------------------------------
        // Test enrollment
        // -------------------------------
        System.out.println("\nEnroll Alice in Java Basics:");
        System.out.println("Enrollment success: " + studentService.enroll(1, 101));
        System.out.println("Enroll Alice again in Java Basics (should fail): " + studentService.enroll(1, 101));

        System.out.println("\nEnroll Bob in Python Basics:");
        System.out.println("Enrollment success: " + studentService.enroll(2, 102));

        // -------------------------------
        // Test enrolled courses
        // -------------------------------
        System.out.println("\nAlice enrolled courses:");
        studentService.getEnrolledCourses(1).forEach(c -> System.out.println(c.getId() + ": " + c.getTitle()));

        System.out.println("\nBob enrolled courses:");
        studentService.getEnrolledCourses(2).forEach(c -> System.out.println(c.getId() + ": " + c.getTitle()));

        // -------------------------------
        // Test lessons retrieval
        // -------------------------------
        System.out.println("\nLessons for Alice in Java Basics:");
        studentService.getLessons(1, 101).forEach(l -> System.out.println(l.getId() + ": " + l.getTitle()));

        System.out.println("\nLessons for Bob in Python Basics:");
        studentService.getLessons(2, 102).forEach(l -> System.out.println(l.getId() + ": " + l.getTitle()));

        // -------------------------------
        // Test marking lessons completed
        // -------------------------------
        System.out.println("\nMark lessons completed:");
        System.out.println("Alice completes lesson 1: " + studentService.markLessonCompleted(1, 101, 1));
        System.out.println("Alice completes lesson 2: " + studentService.markLessonCompleted(1, 101, 2));
        System.out.println("Bob completes lesson 1: " + studentService.markLessonCompleted(2, 102, 1));

        // -------------------------------
        // Test lesson progress
        // -------------------------------
        System.out.println("\nAlice progress in Java Basics:");
        studentService.getLessonProgress(1, 101).forEach((k,v) -> System.out.println("Lesson " + k + " completed? " + v));

        System.out.println("\nBob progress in Python Basics:");
        studentService.getLessonProgress(2, 102).forEach((k,v) -> System.out.println("Lesson " + k + " completed? " + v));

        // -------------------------------
        // Test edge cases
        // -------------------------------
        System.out.println("\nEdge cases:");

        // Student not found
        System.out.println("Enroll non-existent student: " + studentService.enroll(999, 101));

        // Course not found
        System.out.println("Enroll in non-existent course: " + studentService.enroll(1, 999));

        // Mark lesson completed for non-enrolled course
        System.out.println("Alice marks lesson in course 102 (not enrolled): " + studentService.markLessonCompleted(1, 102, 1));

        // Get lessons for non-enrolled course
        System.out.println("Alice tries to get lessons for course 102:");
        studentService.getLessons(1, 102).forEach(l -> System.out.println(l.getId() + ": " + l.getTitle()));
    }

    // -------------------------------
    // Helper: Reset JSON files
    // -------------------------------
    private static void resetJsonFiles() {
        try {
            new FileWriter("users.json", false).close();   // clears users.json
            new FileWriter("courses.json", false).close(); // clears courses.json
            System.out.println("JSON files reset.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
