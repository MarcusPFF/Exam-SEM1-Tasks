package Nr3.Akademiet;

public class runGradingSystem {
    //Declaring new variables
    TextUI ui;
    Academy academy;
    Course course;
    private int[] grades = {-3, 0, 2, 4, 7, 10, 12};

    public runGradingSystem() {
        //Initializing new objects
        ui = new TextUI();
        academy = new Academy();
        course = new Course();
    }

    //Method for running the program
    public void runProgram() {
        //Loading data for current session
        loadStudentData();
        loadCourseData();
        assignStudentToCourse();
        boolean running = true;
        while (running) {
            ui.displayMsg("----Welcome to Marcus Private University----");
            ui.displayMsg("1. Show students");
            ui.displayMsg("2. Show diploma");
            ui.displayMsg("3. Show academy courses");
            ui.displayMsg("4. Get list of highest grades");
            ui.displayMsg("5. Get list of lowest grades");
            ui.displayMsg("6. Get the average grade for all students");
            ui.displayMsg("7. Make a student pass a course");
            ui.displayMsg("8. Exit");

            //Bunch of cases that responds to user input
            int choice = ui.promptNumeric("Choose one of the following options");
            switch (choice) {
                case 1:
                    ui.displayMsg("--List of all students--");
                    academy.showAllStudents();
                    break;
                case 2:
                    String input = ui.promptText("Please type the name of the students you would like to see");
                    Student student = academy.getStudentByName(input);
                    if (student != null) {
                        ui.displayMsg("--Showing diploma for " + student.getName() + "--");
                        ui.displayMsg(student.getDiploma());
                    } else {
                        ui.displayMsg("Student not found. Please try again.");
                    }
                    break;
                case 3:
                    ui.displayMsg("--Academy courses--");
                    academy.showAllCourses();
                    break;
                case 4:
                    ui.displayMsg("Getting list of highest grades..");
                    academy.getHighest(16);
                    break;
                case 5:
                    ui.displayMsg("Getting list of lowest grades..");
                    academy.getLowest(16);
                    break;
                case 6:
                    ui.displayMsg("Calculating average grade...");
                    academy.getAverage(16);
                    break;
                case 7:
                    academy.makeStudentPassACourse();
                    break;
                case 8:
                    ui.displayMsg("Exiting program...");
                    running = false;
                    break;
                default:
                    ui.displayMsg("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    //Adding a student to the academy
    public void loadStudentData() {
        academy.addStudent(new Student("Marcus", 20, "Male"));
        academy.addStudent(new Student("Signe", 18, "Female"));
        academy.addStudent(new Student("Tine", 19, "Female"));
        academy.addStudent(new Student("David", 24, "Male"));
        academy.addStudent(new Student("John", 29, "Male"));
        academy.addStudent(new Student("Mark", 30, "Male"));
        academy.addStudent(new Student("Emma", 23, "Female"));
        academy.addStudent(new Student("Anne", 21, "Female"));
        academy.addStudent(new Student("Peter", 25, "Male"));
        academy.addStudent(new Student("Lise", 22, "Female"));
        academy.addStudent(new Student("Mikkel", 20, "Male"));
        academy.addStudent(new Student("Sofie", 19, "Female"));
        academy.addStudent(new Student("Rasmus", 28, "Male"));
        academy.addStudent(new Student("Julie", 24, "Female"));
        academy.addStudent(new Student("Frederik", 27, "Male"));
        academy.addStudent(new Student("Katrine", 26, "Female"));
        academy.addStudent(new Student("Anders", 23, "Male"));
    }

    //Adding courses to the academy
    public void loadCourseData() {
        academy.addCourse(new Course("Programming Basics"));
        academy.addCourse(new Course("Object-Oriented Programming"));
        academy.addCourse(new Course("Data Structures"));
        academy.addCourse(new Course("Algorithms"));
        academy.addCourse(new Course("Database Management"));
        academy.addCourse(new Course("Web Development"));
        academy.addCourse(new Course("Mobile App Development"));
        academy.addCourse(new Course("Software Engineering"));
        academy.addCourse(new Course("Network Security"));
        academy.addCourse(new Course("Cloud Computing"));
        academy.addCourse(new Course("Artificial Intelligence"));
        academy.addCourse(new Course("Machine Learning"));
        academy.addCourse(new Course("Cyber Security"));
        academy.addCourse(new Course("Data Science"));
        academy.addCourse(new Course("Game Development"));
        academy.addCourse(new Course("Operating Systems"));
        academy.addCourse(new Course("Computer Architecture"));
        academy.addCourse(new Course("DevOps"));
        academy.addCourse(new Course("User Experience Design"));
        academy.addCourse(new Course("Internet of Things"));
    }

    //Assigning the different courses to their position in the ArrayList
    public void assignStudentToCourse() {
        Course programmingBasics = academy.getAcademyCourses().get(0);
        Course objectOrientedProgramming = academy.getAcademyCourses().get(1);
        Course dataStructures = academy.getAcademyCourses().get(2);
        Course algorithms = academy.getAcademyCourses().get(3);
        Course databaseManagement = academy.getAcademyCourses().get(4);
        Course webDevelopment = academy.getAcademyCourses().get(5);
        Course mobileAppDevelopment = academy.getAcademyCourses().get(6);
        Course softwareEngineering = academy.getAcademyCourses().get(7);
        Course networkSecurity = academy.getAcademyCourses().get(8);
        Course cloudComputing = academy.getAcademyCourses().get(9);
        Course artificialIntelligence = academy.getAcademyCourses().get(10);
        Course machineLearning = academy.getAcademyCourses().get(11);
        Course cyberSecurity = academy.getAcademyCourses().get(12);
        Course dataScience = academy.getAcademyCourses().get(13);
        Course gameDevelopment = academy.getAcademyCourses().get(14);
        Course operatingSystems = academy.getAcademyCourses().get(15);
        Course computerArchitecture = academy.getAcademyCourses().get(16);
        Course userExperienceDesign = academy.getAcademyCourses().get(17);
        Course internetOfThings = academy.getAcademyCourses().get(18);


        // Getting the students from the ArrayList
        Student Marcus = academy.getStudents().get(0);
        Student Signe = academy.getStudents().get(1);
        Student Tine = academy.getStudents().get(2);
        Student David = academy.getStudents().get(3);
        Student John = academy.getStudents().get(4);
        Student Mark = academy.getStudents().get(5);
        Student Emma = academy.getStudents().get(6);
        Student Anne = academy.getStudents().get(7);
        Student Peter = academy.getStudents().get(8);
        Student Lise = academy.getStudents().get(9);
        Student Mikkel = academy.getStudents().get(10);
        Student Sofie = academy.getStudents().get(11);
        Student Rasmus = academy.getStudents().get(12);
        Student Julie = academy.getStudents().get(13);
        Student Frederik = academy.getStudents().get(14);
        Student Katrine = academy.getStudents().get(15);
        Student Anders = academy.getStudents().get(16);

        // Assign courses and grades to students
        Marcus.addCourse(programmingBasics, 12);
        Marcus.addCourse(mobileAppDevelopment, 7);

        Signe.addCourse(algorithms, 10);
        Signe.addCourse(webDevelopment, 2);

        Tine.addCourse(dataStructures, 4);
        Tine.addCourse(operatingSystems, 7);
        Tine.addCourse(gameDevelopment, 12);

        David.addCourse(artificialIntelligence, 0);
        David.addCourse(cyberSecurity, 4);
        David.addCourse(machineLearning, 10);

        John.addCourse(databaseManagement, 12);
        John.addCourse(computerArchitecture, 2);
        John.addCourse(cloudComputing, 10);

        Mark.addCourse(softwareEngineering, 12);
        Mark.addCourse(networkSecurity, 7);
        Mark.addCourse(softwareEngineering, 12);

        Emma.addCourse(userExperienceDesign, 10);
        Emma.addCourse(internetOfThings, 4);

        Anne.addCourse(gameDevelopment, 7);
        Anne.addCourse(artificialIntelligence, 0);

        Peter.addCourse(objectOrientedProgramming, 4);
        Peter.addCourse(cyberSecurity, 2);

        Lise.addCourse(mobileAppDevelopment, 12);
        Lise.addCourse(softwareEngineering, 10);

        Mikkel.addCourse(cloudComputing, 4);
        Mikkel.addCourse(dataScience, 7);

        Sofie.addCourse(programmingBasics, 0);
        Sofie.addCourse(databaseManagement, 4);

        Rasmus.addCourse(algorithms, 7);
        Rasmus.addCourse(machineLearning, 12);

        Julie.addCourse(operatingSystems, 4);
        Julie.addCourse(cyberSecurity, 0);

        Frederik.addCourse(dataStructures, 10);
        Frederik.addCourse(cloudComputing, 7);

        Katrine.addCourse(artificialIntelligence, 2);
        Katrine.addCourse(softwareEngineering, 0);

        Anders.addCourse(mobileAppDevelopment, 4);
        Anders.addCourse(networkSecurity, 7);
        Anders.addCourse(webDevelopment, 10);
    }
}
