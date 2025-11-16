/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication12;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author GAMING
 */
public class Student extends User {

    private ArrayList<courses> enrolledCourses;
    private HashMap<String, Boolean> progress;

    public Student(int id, String email, String pass, String name) {
        super(id, "student", email, pass, name);
        this.enrolledCourses = new ArrayList<>();
        this.progress = new HashMap<>();
    }

    public ArrayList<courses> getEnrolledCourses() {
        return enrolledCourses;
    }

    public HashMap<String, Boolean> getProgress() {
        return progress;
    }

    public void setEnrolledCourses(ArrayList<courses> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setProgress(HashMap<String, Boolean> progress) {
        this.progress = progress;
    }

    public void enrollCourse(courses c) {
        if (!enrolledCourses.contains(c)) {
            enrolledCourses.add(c);
        }
    }

    public void markLessonCompleted(String lessonId) {
        progress.put(lessonId, true);
    }
}
