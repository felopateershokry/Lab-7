/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_07;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author PC
 */public class LessonManager {

    private final String COURSES_FILE = "courses.json";

    // Read courses as JSONArray
    private JSONArray readCoursesFile() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(COURSES_FILE)), "UTF-8");
            return new JSONArray(content);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public ArrayList<Lesson> getLessonsByCourse(String courseId) {

        JSONArray coursesArr = readCoursesFile();
        ArrayList<Lesson> lessons = new ArrayList<>();

        int id = Integer.parseInt(courseId);

        for (int i = 0; i < coursesArr.length(); i++) {
            JSONObject course = coursesArr.getJSONObject(i);

            if (course.getInt("id") == id) {
                JSONArray lessonsArr = course.getJSONArray("lessons");

                for (int j = 0; j < lessonsArr.length(); j++) {

                    JSONObject l = lessonsArr.getJSONObject(j);

                    Lesson lesson = new Lesson(
                            String.valueOf(l.getInt("id")),
                            l.getString("title"),
                            l.getString("content"),
                            null
                    );

                    lessons.add(lesson);
                }
            }
        }

        return lessons;
    }

    // ✔ FIXED: Compatible with users.json (array of users)
    public void markLessonCompleted(String userId, String courseId, String lessonId) {

        try {
            String path = "users.json";
            String content = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");

            JSONArray usersArr = new JSONArray(content);

            int uid = Integer.parseInt(userId);

            for (int i = 0; i < usersArr.length(); i++) {

                JSONObject user = usersArr.getJSONObject(i);
                if (user.getInt("userId") == uid) {

                    if (!user.has("progress"))
                        user.put("progress", new JSONObject());

                    JSONObject progress = user.getJSONObject("progress");

                    if (!progress.has(courseId))
                        progress.put(courseId, new JSONArray());

                    JSONArray completed = progress.getJSONArray(courseId);

                    // Prevent duplicates
                    if (!completed.toList().contains(lessonId))
                        completed.put(lessonId);

                    // Save file
                    Files.write(Paths.get(path), usersArr.toString(4).getBytes());
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

