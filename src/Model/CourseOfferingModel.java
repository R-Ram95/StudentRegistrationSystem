package Model;

import java.util.ArrayList;

public class CourseOfferingModel {
    private int sectionNum;
    private int sectionCap;
    private CourseModel theCourse;
    private ArrayList<RegistrationModel> studentList;
    private boolean courseStatus;

    public CourseOfferingModel(int sectionNum, int sectionCap){
        this.setSectionNum(sectionNum);
        this.setSectionCap(sectionCap);
        // this.setCourse(theCourse);
        studentList = new ArrayList<RegistrationModel>();
        this.courseStatus = false;
    }

    public void addRegistration(RegistrationModel reg){
        studentList.add(reg);
    }

    public void removeRegistration(RegistrationModel reg){
        studentList.remove(reg);
    }

    public void checkCourseStatus(){
        //has less than 8 students, cannot run the course
        if(studentList.size() < 8){
            courseStatus = false;
        }
        //have 8 students or more, so can run the course
        else{
            courseStatus = true;
        }
    }

    // setters and getters
    public void setCourse(CourseModel theCourse){
        this.theCourse = theCourse;
    }

    public CourseModel getCourse(){
        return this.theCourse;
    }

    public ArrayList<RegistrationModel> getStudentList(){
        return studentList;
    }

    public int getSectionNum() {
        return this.sectionNum;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }

    public int getSectionCap() {
        return this.sectionCap;
    }

    public void setSectionCap(int sectionCap) {
        this.sectionCap = sectionCap;
    }

}

