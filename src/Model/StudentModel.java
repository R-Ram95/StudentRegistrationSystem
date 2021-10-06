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
    public void registerForCourse(CatalogueModel catalogueModel, String courseName, String courseNum, int secNum){


        // get the course
        CourseModel theCourse = catalogueModel.searchCat(courseName, courseNum);

        // get the offering
        CourseOfferingModel theOffering = theCourse.searchOfferingList(secNum);

        RegistrationModel reg = new RegistrationModel(this, theOffering);

        //adds the course to the course list
        reg.addRegistration();
    }

    //facilitates removing a course
    public void removeCourse(String courseName, String courseNumber, int sectionNum) throws NullPointerException{

        RegistrationModel registrationResult = searchList(courseName, courseNumber, sectionNum);
        registrationResult.removeRegistration();
    }

    public RegistrationModel searchList(String courseName, String courseNumber, int sectionNum){
        if(courseList.size() == 0){
            return null;
        }

        for(RegistrationModel r : courseList){
            if(r.getOffering().getCourse().getCourseName().equals(courseName) && r.getOffering().getCourse()
                    .getCourseNumber().equals(courseNumber)){
                return r;
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