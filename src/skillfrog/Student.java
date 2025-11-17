/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skillfrog;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author GAMING
 */
public class Student extends User {

    private ArrayList<Course> enrolledCourses;
    private HashMap<String, Boolean> progress;

    public Student(int id, String name, String email, String pass) {
        super(id, name, email, pass, "student");
        this.enrolledCourses = new ArrayList<>();
        this.progress = new HashMap<>();
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public HashMap<String, Boolean> getProgress() {
        return progress;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setProgress(HashMap<String, Boolean> progress) {
        this.progress = progress;
    }

    public void enrollCourse(Course c) {
        if (!enrolledCourses.contains(c)) {
            enrolledCourses.add(c);
        }
    }

    public void markLessonCompleted(String lessonId) {
        progress.put(lessonId, true);
    }
}
