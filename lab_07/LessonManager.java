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
 */
public class LessonManager {

    private final String COURSES_FILE = "courses.json";

    private JSONObject readCoursesFile() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(COURSES_FILE)));
            return new JSONObject(content);
        } catch (Exception e) {
            return new JSONObject(); // empty database
        }
    }

    private void writeCoursesFile(JSONObject data) {
        try {
            Files.write(Paths.get(COURSES_FILE), data.toString(4).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Lesson> getLessonsByCourse(String courseId) {
        JSONObject db = readCoursesFile();

        if (!db.has(courseId)) {
            return new ArrayList<>();
        }

        JSONArray lessonsArr = db.getJSONObject(courseId).getJSONArray("lessons");

        ArrayList<Lesson> lessons = new ArrayList<>();
        for (int i = 0; i < lessonsArr.length(); i++) {
            JSONObject obj = lessonsArr.getJSONObject(i);
            lessons.add(Lesson.fromJSON(obj));
        }

        return lessons;
    }

    public void addLesson(String courseId, Lesson lesson) {
        JSONObject db = readCoursesFile();

        if (!db.has(courseId)) {
            return;
        }

        JSONArray lessonsArr = db.getJSONObject(courseId).getJSONArray("lessons");
        lessonsArr.put(lesson.toJSON());

        writeCoursesFile(db);
    }

    public void deleteLesson(String courseId, String lessonId) {
        JSONObject db = readCoursesFile();

        if (!db.has(courseId)) {
            return;
        }

        JSONArray lessonsArr = db.getJSONObject(courseId).getJSONArray("lessons");
        JSONArray newArr = new JSONArray();

        for (int i = 0; i < lessonsArr.length(); i++) {
            if (!lessonsArr.getJSONObject(i).getString("lessonId").equals(lessonId)) {
                newArr.put(lessonsArr.getJSONObject(i));
            }
        }

        db.getJSONObject(courseId).put("lessons", newArr);
        writeCoursesFile(db);
    }

    public void markLessonCompleted(String userId, String courseId, String lessonId) {
        try {
            // Read users.json
            String path = "users.json";
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONObject usersDb = new JSONObject(content);

            if (!usersDb.has(userId)) {
                return;
            }

            JSONObject user = usersDb.getJSONObject(userId);

            // Ensure progress object exists
            if (!user.has("progress")) {
                user.put("progress", new JSONObject());
            }

            JSONObject progress = user.getJSONObject("progress");

            // Ensure course progress exists
            if (!progress.has(courseId)) {
                progress.put(courseId, new JSONArray());
            }

            // Add lesson id if not already there
            JSONArray completed = progress.getJSONArray(courseId);
            if (!completed.toList().contains(lessonId)) {
                completed.put(lessonId);
            }

            // Save
            Files.write(Paths.get(path), usersDb.toString(4).getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
