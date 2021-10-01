package Model;

/**
 * COPY PASTED FROM ASSIGNMENT1
 *
 * Keeps track of all the student information and also adding new classes
 * and new operations
 *
 * We can use a pattern and model view controller.
 * have a model and controller student.
 * Controller: talk to other classes, and do all the functional stuff
 */
public class StudentModel {
    private String studentName;
    private int studentId;
    private ArrayList<Registration> courseList;

    public StudentModel(String studentName, int studentId){
        this.studentName = studentName;
        this.studentId = studentId;
        courseList = new ArrayList<Registration>();
    }

    //facilitates adding a course
    public void registerForCourse(CourseCat cat, String courseName, String courseNumber, int secNumber){
        if(courseList.size() >= 6){
            System.err.println("ERROR, You've already enrolled in the maximum number of courses.");
        }

        else{
            //search catalogue for the course
            Course myCourse = cat.searchCat(courseName, courseNumber);

            if(myCourse == null){
                System.err.println("ERROR, Incorrect course or section number, please try again.");
                return;
            }
            //if the course list already contains the course
            if(courseList.contains(searchCourseList(courseName, courseNumber))){
                System.err.println("ERROR, student's already enrolled in this course!");
                return;
            }
            //if the course exists, we need the section number
            Offering theOffering = myCourse.matchOffering(secNumber);

            Registration reg = new Registration(this, theOffering);
            //adds the course to the course list
            reg.addRegistration();
            System.out.println("You've successfully enrolled in " + courseName + " " + courseNumber);

        }
    }

    //facilitates removing a course
    public void removeCourse(String courseName, String courseNumber, int sectionNum){

        Registration registrationResult = searchList(courseName, courseNumber, sectionNum);
        if(registrationResult == null){
            return;
        }
        registrationResult.removeRegistration();
        System.out.println("You've successfully unenrolled in " + courseName + " " + courseNumber);
    }

    public Registration searchList(String courseName, String courseNumber, int sectionNum){
        if(courseList.size() == 0){
            System.err.println("ERROR, You're not enrolled in any courses currently.");
        }
        else{
            for(Registration course : this.getCourseList()){
                if(course.getOffering().getCourse().getCourseName().equals(courseName) && course.getOffering().getCourse()
                        .getCourseNumber().equals(courseNumber) && course.getOffering().getSectionNum() == sectionNum){
                    return course;
                }
            }
            //if traversed the entire list and didn't find course
            System.err.println("ERROR, You're either not enrolled in this course, or entered the incorrect course or section number!");
            return null;
        }
        return null;
    }

    public Registration searchCourseList(String courseName, String courseNumber){
        for(Registration course : this.getCourseList()){
            if(course.getOffering().getCourse().getCourseName().equals(courseName) && course.getOffering().getCourse()
                    .getCourseNumber().equals(courseNumber)){
                return course;
            }
        }
        return null;
    }

    public void printCourseList(){
        System.out.print("Registered Courses: ");
        for(Registration course : courseList){
            System.out.print(course.getOffering().getCourse() + " ");
        }
        System.out.println("");
    }

    public Student studentLogin(ArrayList<Student> students, String name, int id){

        for(Student search:students){
            //if the student name in the list is the same as the one inputted
            if(search.getStudentName().equals(name) && search.getStudentId() == id){
                //then this is the student
                return search;
            }
        }
        //if not found in the arraylist
        return null;
    }

    public void addRegistration(Registration reg){
        courseList.add(reg);
    }

    public void removeRegistration(Registration reg){
        courseList.remove(reg);
    }

    //getters and setters
    public ArrayList<Registration> getCourseList(){
        return courseList;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}