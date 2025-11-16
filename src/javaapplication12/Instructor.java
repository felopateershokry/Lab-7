/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< Updated upstream:src/javaapplication12/Instructor.java
package javaapplication12;
=======
package skillfrog;
>>>>>>> Stashed changes:src/skillfrog/Instructor.java

import java.util.ArrayList;

/**
 *
 * @author GAMING
 */
public class Instructor extends User {

<<<<<<< Updated upstream:src/javaapplication12/Instructor.java
    private ArrayList<courses> createdCourses;
=======
    private ArrayList<Course> createdCourses;
>>>>>>> Stashed changes:src/skillfrog/Instructor.java

    public Instructor() {
        this.createdCourses = new ArrayList<>();
    }

<<<<<<< Updated upstream:src/javaapplication12/Instructor.java
    public ArrayList<courses> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(ArrayList<courses> createdCourses) {
        this.createdCourses = createdCourses;
    }

    public void addCreatedCourse(courses c) {
=======
    public ArrayList<Course> getCreatedCourse() {
        return createdCourses;
    }

    public void setCreatedCourse(ArrayList<Course> createdCourse) {
        this.createdCourses = createdCourse;
    }

    public void addCreatedCourse(Course c) {
>>>>>>> Stashed changes:src/skillfrog/Instructor.java
        if (!createdCourses.contains(c)) {
            this.createdCourses.add(c);
        }
    }

}
