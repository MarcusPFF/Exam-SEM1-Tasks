package Nr3.Akademiet;

//Import libraries

import java.util.ArrayList;
import java.util.List;

public class Academy {
    //Declaring variables and making two of them private
    TextUI ui;
    private List<Course> academyCourses;
    private List<Student> students;

    //Constructor
    public Academy() {
        //Initializing my List as an ArrayList
        academyCourses = new ArrayList<>();
        students = new ArrayList<>();
        this.ui = new TextUI();
    }

    //Method to adding a course to the academyCourses
    public void addCourse(Course course) {
        academyCourses.add(course);
    }

    //Method for showing all students
    public void showAllStudents() {
        for (Student student : getStudents()) {
            ui.displayMsg(student.toString());
        }
    }

    //Method for showing all courses
    public void showAllCourses() {
        for (Course course : academyCourses) {
            ui.displayMsg(course.toString());
        }
    }

    //Method for getting a student by name, going through the students objects and using .equal to the parameter
    public Student getStudentByName(String name) {
        for (Student student : getStudents()) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    //Method for getting course by name, going though the course objects and using .equal to the parameter
    public Course getCourseByName(String name) {
        for (Course course : academyCourses) {
            if (course.getName().equalsIgnoreCase(name)) {
                return course;
            }
        }
        return null;
    }

    //Method for sorting the highest grade among the students
    public void getHighest(int amount) {
        List<Student> highestGradeStudents = new ArrayList<>();
        List<Double> grades = new ArrayList<>();

        /* Double for loop for getting the highest grade among the students.'
        And adding it to the grades ArrayList
         */
        for (Student student : getStudents()) {
            for (double grade : student.getGrades()) {
                if (!grades.contains(grade)) {
                    grades.add(grade);
                }
            }
        }

        // Sorting the grades (low -> high)
        grades.sort((a, b) -> Double.compare(b, a));

        //Utilizes TextUI to display the students grade now sorted from (low -> high)
        int count = 0;
        for (double grade : grades) {
            for (Student student : getStudents()) {
                for (double studentGrade : student.getGrades()) {
                    if (studentGrade == grade) {
                        highestGradeStudents.add(student);
                        ui.displayMsg("Student: " + student.getName() + " with grade: " + grade);
                        count++;
                    }
                }
            }
        }
    }

    //Method for getting the overall SUM between the students
    public void getAverage(int amount) {
        double sum = 0;
        int totalCount = 0;

        // Loops through all students
        for (Student student : getStudents()) {
            //Sum of all grades
            for (double grade : student.getGrades()) {
                sum = sum + grade;
                totalCount++;
            }
        }

        // Calc the average grade using the Sum of all the grades
        if (totalCount > 0) {
            double average = sum / totalCount;
            ui.displayMsg("The average grade for all students is: " + average);
        } else {
            ui.displayMsg("No grades available to calculate average.");
        }
    }

    //Exactly the same as the getHighest method just in reverse XD
    public void getLowest(int amount) {
        List<Student> lowestGradeStudents = new ArrayList<>();
        List<Double> grades = new ArrayList<>();

        for (Student student : getStudents()) {
            for (double grade : student.getGrades()) {
                if (!grades.contains(grade)) {
                    grades.add(grade);
                }
            }
        }
        grades.sort((a, b) -> Double.compare(a, b));

        int count = 0;
        for (double grade : grades) {
            for (Student student : getStudents()) {
                for (double studentGrade : student.getGrades()) {
                    if (studentGrade == grade) {
                        lowestGradeStudents.add(student);
                        ui.displayMsg("Student: " + student.getName() + " with grade: " + grade);
                        count++;
                    }
                }
            }
        }
    }

    //Method to making a student pass a course
    public void makeStudentPassACourse() {
        String nameOfStudent = ui.promptText("Please type the name of the student you would like to add a course to");
        Student student1 = getStudentByName(nameOfStudent);

        // Loop to keep asking for a valid student name if student is not found
        if (student1 == null) {
            ui.displayMsg("Student " + nameOfStudent + " does not exist. Please try again.");
            nameOfStudent = ui.promptText("Please type the name of the student");
            student1 = getStudentByName(nameOfStudent);
        }

        //Program gives up here because user cannot type correct student name
        if (student1 == null) {
            ui.displayMsg("Still no match, exiting...");
            return;
        }


        //Asking user for the name of the course
        String nameOfCourse = ui.promptText("Please type the name of the course");

        //Checks if the course already exist on the users diploma
        boolean courseAlreadyExists = false;
        for (Course course : student1.getCourses()) {
            if (course.getName().equalsIgnoreCase(nameOfCourse)) {
                courseAlreadyExists = true;
                break;
            }
        }
        //If it doesn't, make a new course
        if (!courseAlreadyExists) {
            Course course1 = new Course(nameOfCourse);
            //asking student the grade and saves the data in a variable
            double grade = ui.promptNumeric("What grade did the student get?");

            //Creating the course with the info provided
            student1.addCourse(course1, grade);
            ui.displayMsg("Data added successfully.");

        } else {
            ui.displayMsg("Student already has this course. Add something else or exit");
            return;
        }
    }

    //Getter
    public List<Course> getAcademyCourses() {
        return academyCourses;
    }

    //Method for adding a student to the ArrayList
    public void addStudent(Student student) {
        students.add(student);
    }

    //Getter
    public List<Student> getStudents() {
        return students;
    }

    //toString
    @Override
    public String toString() {
        return "Academy{" +
                "students=" + students;
    }
}
