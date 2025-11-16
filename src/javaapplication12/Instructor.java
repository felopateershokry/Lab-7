/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication12;

import java.util.ArrayList;

/**
 *
 * @author GAMING
 */
public class Instructor extends User {

    private ArrayList<courses> createdCourses;

    public Instructor() {
        this.createdCourses = new ArrayList<>();
    }

    public ArrayList<courses> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(ArrayList<courses> createdCourses) {
        this.createdCourses = createdCourses;
    }

    public void addCreatedCourse(courses c) {
        if (!createdCourses.contains(c)) {
            this.createdCourses.add(c);
        }
    }

}
