package skillfrog;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private final CourseRepository repo = new CourseRepository();
    private List<Course> courses = repo.loadCourses();

    public boolean createCourse(Course c) {
        if (courseExists(c.getId())) {
            return false;
        }
        courses.add(c);
        repo.saveCourses(courses);
        return true;
    }

    public boolean updateCourse(int id, Course newData) {
        if (!courseExists(id)) {
            return false;
        }
        for (Course c : courses) {
            if (c.getId() == id) {
                c.setTitle(newData.getTitle());
                c.setDescription(newData.getDescription());
                repo.saveCourses(courses);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int id) {
        if (!courseExists(id)) {
            return false;
        }
        courses.removeIf(c -> c.getId() == id);
        repo.saveCourses(courses);
        return true;
    }

    public boolean addLesson(int courseId, Lesson lesson) {
        if (!courseExists(courseId)) {
            return false;
        }
        if (lessonExists(courseId, lesson.getId())) {
            return false;
        }
        for (Course c : courses) {
            if (c.getId() == courseId) {
                c.getLessons().add(lesson);
                repo.saveCourses(courses);
                return true;
            }
        }
        return false;
    }

    public boolean editLesson(int courseId, int lessonId, Lesson newData) {
        if (!courseExists(courseId) || !lessonExists(courseId, lessonId)) {
            return false;
        }
        for (Course c : courses) {
            if (c.getId() == courseId) {
                for (Lesson l : c.getLessons()) {
                    if (l.getId() == lessonId) {
                        l.setTitle(newData.getTitle());
                        l.setContent(newData.getContent());
                        repo.saveCourses(courses);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean deleteLesson(int courseId, int lessonId) {
        if (!courseExists(courseId) || !lessonExists(courseId, lessonId)) {
            return false;
        }
        for (Course c : courses) {
            if (c.getId() == courseId) {
                c.getLessons().removeIf(l -> l.getId() == lessonId);
                repo.saveCourses(courses);
                return true;
            }
        }
        return false;
    }

    public List<String> getEnrolledStudents(int courseId) {
        for (Course c : courses) {
            if (c.getId() == courseId) {
                return c.getEnrolledStudents();
            }
        }
        return new ArrayList<>();
    }

    public boolean courseExists(int courseId) {
        for (Course c : courses) {
            if (c.getId() == courseId) {
                return true;
            }
        }
        return false;
    }

    public boolean lessonExists(int courseId, int lessonId) {
        for (Course c : courses) {
            if (c.getId() == courseId) {
                for (Lesson l : c.getLessons()) {
                    if (l.getId() == lessonId) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Course courseExist(int courseId) {
        for (Course c : courses) {
            if (c.getId() == courseId) {
                return c;
            }
        }
        return null;
    }

    public Lesson lessonExist(int courseId, int lessonId) {
        for (Course c : courses) {
            if (c.getId() == courseId) {
                for (Lesson l : c.getLessons()) {
                    if (l.getId() == lessonId) {
                        return l;
                    }
                }
            }
        }
        return null;
    }
}
