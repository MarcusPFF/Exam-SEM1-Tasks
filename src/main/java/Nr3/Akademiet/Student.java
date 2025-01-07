package Nr3.Akademiet;

import java.util.ArrayList;
import java.util.List;

public class Student {
    //Declaring private variables
    private String name;
    private double age;
    private String gender;
    private double grade;
    private List<Course> courses;
    private List<Double> grades;

    //Constructor
    public Student(String name, double age, String gender) {
        //Initializing the variables and creating ArrayLists
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    //getter
    public String getName() {
        return name;
    }

    //Method to adding data to courses
    public void addCourse(Course course, double grade) {
        courses.add(course);
        grades.add(grade);
    }

    /* I changed this from "printDiploma(Student)" to this because I have made an interactive app
    This method gets the diploma for a student
     */
    public String getDiploma() {
        if (courses.isEmpty()) {
            return name + " has not completed any courses.";
        }
        //Here it displays the courses and what grade they got
        String diploma = "Diploma for " + name + ":\n";
        diploma = diploma + "Courses and Grades:\n";
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course != null) {
                diploma = diploma + "- " + course.getName() + ": " + grades.get(i) + "\n";
            } else {
                diploma = diploma + "- Unknown Course: No grade available\n";
            }
        }
        return diploma;
    }

    //Getter
    public List<Course> getCourses() {
        return this.courses;
    }

    public List<Double> getGrades() {
        return grades;
    }

    //toString
    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
    }
}