/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skillfrog;

import java.util.ArrayList;

/**
 *
 * @author GAMING
 */
public class Instructor extends User {

    private ArrayList<String> createdCourses;

    public Instructor(int id, String name, String email, String pass) {
        super(id, name, email, pass, "instructor");
        this.createdCourses = new ArrayList<>();
    }

    public ArrayList<String> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(ArrayList<String> createdCourses) {
        this.createdCourses = createdCourses;
    }

    public void addCreatedCourse(String c) {
        if (!createdCourses.contains(c)) {
            this.createdCourses.add(c);
        }
    }

}
