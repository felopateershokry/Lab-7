/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< Updated upstream:src/javaapplication12/Student.java
package javaapplication12;
=======
package skillfrog;
>>>>>>> Stashed changes:src/skillfrog/Student.java

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author GAMING
 */
public class Student extends User {

<<<<<<< Updated upstream:src/javaapplication12/Student.java
    private ArrayList<courses> enrolledCourses;
=======
    private ArrayList<Course> enrolledCourses;
>>>>>>> Stashed changes:src/skillfrog/Student.java
    private HashMap<String, Boolean> progress;

    public Student(int id, String email, String pass, String name) {
        super(id, "student", email, pass, name);
        this.enrolledCourses = new ArrayList<>();
        this.progress = new HashMap<>();
    }

<<<<<<< Updated upstream:src/javaapplication12/Student.java
    public ArrayList<courses> getEnrolledCourses() {
=======
    public ArrayList<Course> getEnrolledCourses() {
>>>>>>> Stashed changes:src/skillfrog/Student.java
        return enrolledCourses;
    }

    public HashMap<String, Boolean> getProgress() {
        return progress;
    }

<<<<<<< Updated upstream:src/javaapplication12/Student.java
    public void setEnrolledCourses(ArrayList<courses> enrolledCourses) {
=======
    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
>>>>>>> Stashed changes:src/skillfrog/Student.java
        this.enrolledCourses = enrolledCourses;
    }

    public void setProgress(HashMap<String, Boolean> progress) {
        this.progress = progress;
    }

<<<<<<< Updated upstream:src/javaapplication12/Student.java
    public void enrollCourse(courses c) {
=======
    public void enrollCourse(Course c) {
>>>>>>> Stashed changes:src/skillfrog/Student.java
        if (!enrolledCourses.contains(c)) {
            enrolledCourses.add(c);
        }
    }

    public void markLessonCompleted(String lessonId) {
        progress.put(lessonId, true);
    }
}
