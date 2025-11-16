/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_07;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class Lesson {

    private String title;
    private String content;
    private String lessonId;
    private ArrayList<String> resources;

    public Lesson(String title, String content, String lessonId, ArrayList<String> resources) {
        this.title = title;
        this.content = content;
        this.lessonId = lessonId;
        this.resources = resources;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String Content) {
        this.content = Content;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public ArrayList<String> getResources() {
        return resources;
    }

    public void setResources(ArrayList<String> resources) {
        this.resources = resources;
    }

    public void addResource(String r) {
        this.resources.add(r);
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("lessonId", lessonId);
        obj.put("title", title);
        obj.put("content", content);

        JSONArray arr = new JSONArray();
        for (String r : resources) {
            arr.put(r);
        }
        obj.put("resources", arr);

        return obj;
    }

    public static Lesson fromJSON(JSONObject obj) {
        String lessonId = obj.getString("lessonId");
        String title = obj.getString("title");
        String content = obj.getString("content");

        ArrayList<String> resources = new ArrayList<>();
        if (obj.has("resources")) {
            JSONArray arr = obj.getJSONArray("resources");
            for (int i = 0; i < arr.length(); i++) {
                resources.add(arr.getString(i));
            }
        }

        return new Lesson(lessonId, title, content, resources);
    }

}
