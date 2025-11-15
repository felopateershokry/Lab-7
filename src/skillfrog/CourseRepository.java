/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skillfrog;

/**
 *
 * @author Lenovo
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private final String FILE = "courses.json";
    private final Gson gson = new Gson();

    public List<Course> loadCourses() {
        try (FileReader reader = new FileReader(FILE)) {
            return gson.fromJson(reader, new TypeToken<List<Course>>() {
            }.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void saveCourses(List<Course> courses) {
        try (FileWriter writer = new FileWriter(FILE)) {
            gson.toJson(courses, writer);
        } catch (Exception e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }
}
