package Model;

import java.util.ArrayList;

public class CourseOfferingModel {
    private String sectionNum;
    private int sectionCap;
    private CourseModel theCourse;
    private ArrayList<RegistrationModel> studentList;
    private boolean courseStatus;

    public CourseOfferingModel(String sectionNum, int sectionCap){
        this.setSectionNum(sectionNum);
        this.setSectionCap(sectionCap);
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

    public String getSectionNum() {
        return this.sectionNum;
    }

    public void setSectionNum(String sectionNum) {
        this.sectionNum = sectionNum;
    }

    public int getSectionCap() {
        return this.sectionCap;
    }

    public void setSectionCap(int sectionCap) {
        this.sectionCap = sectionCap;
    }

    @Override
    public String toString(){

        StringBuffer buffer = new StringBuffer();

        buffer.append("Section Number: " + getSectionNum() + "\n");
        buffer.append("Section Capacity: " + getSectionCap() + "\n");

        return buffer.toString();
    }

}

