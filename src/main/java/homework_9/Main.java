package homework_9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course c1 = new SpbCource(123);
        Course c2 = new SpbCource(321);
        Course c3 = new SpbCource(777);

        SpbStudent student1 = new SpbStudent("Petr");
        SpbStudent student2 = new SpbStudent("Kate");
        SpbStudent student3 = new SpbStudent("Ann");
        SpbStudent student4 = new SpbStudent("Joe");

        student1.addCourse(c1);
        student2.addCourse(c1);
        student2.addCourse(c2);
        student3.addCourse(c2);
        student4.addCourse(c1);
        student4.addCourse(c2);
        student4.addCourse(c3);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        List<Course> uniqueCourses = uniqueCourses(students);
        System.out.println("Список уникальных курсов: ");
        for (Course x : uniqueCourses
        ) {
            System.out.println(x.getId());
        }
        System.out.println("------------");

        List<Student> top3Studwnts = getThreeBestStudents(students);
        System.out.println("Cписок из трех самых любознательных: ");
        top3Studwnts.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println("------------");

        Course selectedCourse = c2;
        System.out.println("Список студентов курса " + selectedCourse.getId() + ":");
        List<Student> studentsOfCourse = getCourseStudents(students, selectedCourse);
        studentsOfCourse.stream().forEach(s -> System.out.println(s.getName()));
    }
    
    //    1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые
    //    подписаны студенты.
    static List<Course> uniqueCourses(List<Student> students) {
        Stream<Student> stream = students.stream();
        return stream
                .flatMap(a -> a.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    //    2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
    //    (любознательность определяется количеством курсов).
    static List<Student> getThreeBestStudents(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> -(s1.getAllCourses().size() - s2.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    //3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
    // которые посещают этот курс.
    static List<Student> getCourseStudents(List<Student> students, Course course) {
        return students.stream()
                .filter(s -> s.getAllCourses().stream()
                        .anyMatch(c -> c.getId() == course.getId())
                )
                .collect(Collectors.toList());
    }
}
