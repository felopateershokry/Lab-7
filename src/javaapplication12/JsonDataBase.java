/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skillfrog;

<<<<<<< Updated upstream:src/javaapplication12/JsonDataBase.java
import java.util.ArrayList;
import java.util.HashMap;
=======
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
>>>>>>> Stashed changes:src/skillfrog/JsonDataBase.java

/**
 *
 * @author GAMING
 */
<<<<<<< Updated upstream:src/javaapplication12/JsonDataBase.java
<<<<<<<< Updated upstream:src/javaapplication12/JsonDataBase.java
public class JsonDataBase {
========
public class Student extends User {
>>>>>>>> Stashed changes:src/skillfrog/Student.java

    private ArrayList<Course> enrolledCourses;
    private HashMap<String, Boolean> progress;

    public Student(int id, String email, String pass, String name) {
        super(id, "student", email, pass, name);
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
=======
public class JsonDataBase {

    private static final String UsersFile = "users.json";
    private static final String CourseFILE = "courses.json";
    private static final Gson gson = new Gson();

    public static List<User> loadUsers() {
        try {
            FileReader reader = new FileReader(UsersFile);
            return gson.fromJson(reader, new TypeToken<List<User>>() {
            }.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveUsers(List<User> users) {
        try {
            FileWriter writer = new FileWriter(UsersFile);
            gson.toJson(users, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Course> loadCourses() {
        try {
            FileReader reader = new FileReader(CourseFILE);
            return gson.fromJson(reader, new TypeToken<List<Course>>() {
            }.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveCourses(List<Course> courses) {
        try {
            FileWriter writer = new FileWriter(CourseFILE);
            gson.toJson(courses, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

>>>>>>> Stashed changes:src/skillfrog/JsonDataBase.java
}
