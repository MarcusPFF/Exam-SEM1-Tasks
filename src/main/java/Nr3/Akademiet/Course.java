package Nr3.Akademiet;

//Import libraries

import java.util.ArrayList;
import java.util.List;

public class Course {
    //Declaring private variables
    private String name;
    private List<Student> students;

    //Constructor overloading
    public Course() {
        //Initializing a new ArrayList
        students = new ArrayList<>();
    }

    //Constructor overloading
    public Course(String name) {
        this.name = name;
        //Initializing a new ArrayList
        this.students = new ArrayList<>();
    }

    //getter
    public String getName() {
        return name;
    }

    //Method for counting all students in the students ArrayList. Currently not being used.
    public int countAllStudent() {
        int studentsCount = 0;
        for (Student student : students) {
            studentsCount++;
        }
        return studentsCount;
    }


    //Getter
    public List<Student> getStudents() {
        return students;
    }

    //toString
    @Override
    public String toString() {
        return getName();
    }
}
