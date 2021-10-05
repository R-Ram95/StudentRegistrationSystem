package Model;

import java.util.ArrayList;

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
    private ArrayList<RegistrationModel> courseList;

    public StudentModel(String studentName, int studentId){
        this.studentName = studentName;
        this.studentId = studentId;
        courseList = new ArrayList<RegistrationModel>();
    }

    //facilitates adding a course
    public void registerForCourse(CourseModel theCourse, CourseOfferingModel theOffering){
        // TODO add checking if student is registered in too many courses

        RegistrationModel reg = new RegistrationModel(this, theOffering);
        //adds the course to the course list
        reg.addRegistration();
    }

    //facilitates removing a course
    public void removeCourse(String courseName, String courseNumber, int sectionNum){

        RegistrationModel registrationResult = searchList(courseName, courseNumber, sectionNum);
        if(registrationResult == null){
            return;
        }
        registrationResult.removeRegistration();
        System.out.println("You've successfully unenrolled in " + courseName + " " + courseNumber);
    }

    public RegistrationModel searchList(String courseName, String courseNumber, int sectionNum){
        if(courseList.size() == 0){
            System.err.println("ERROR, You're not enrolled in any courses currently.");
        }
        else{
            for(RegistrationModel course : this.getCourseList()){
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

    public RegistrationModel searchCourseList(String courseName, String courseNumber){
        for(RegistrationModel course : this.getCourseList()){
            if(course.getOffering().getCourse().getCourseName().equals(courseName) && course.getOffering().getCourse()
                    .getCourseNumber().equals(courseNumber)){
                return course;
            }
        }
        return null;
    }

    public String showCourseList(){
        StringBuffer buffer = new StringBuffer();
        for(RegistrationModel r: courseList){
            buffer.append(r.getOffering().getCourse());
            buffer.append(r.getOffering());
        }

        return buffer.toString();
    }

    public void addRegistration(RegistrationModel reg){
        courseList.add(reg);
    }

    public void removeRegistration(RegistrationModel reg){
        courseList.remove(reg);
    }

    //getters and setters
    public ArrayList<RegistrationModel> getCourseList(){
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