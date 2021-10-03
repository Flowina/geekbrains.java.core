package homework_9;

import java.util.ArrayList;
import java.util.List;

public class SpbStudent implements Student {
    private String name;
    List<Course> courses = new ArrayList<>();

    public SpbStudent(String name) {
        this.name = name;

    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}
