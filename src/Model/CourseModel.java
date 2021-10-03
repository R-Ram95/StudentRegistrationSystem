package Model;

import java.util.ArrayList;

public class CourseModel{
    private String courseName;
    private String courseNumber;
    private ArrayList <CourseModel> preReqList;
    private ArrayList <CourseOfferingModel> offeringList;

    public CourseModel(String courseName, String courseNumber){
        this.setCourseName(courseName);
        setCourseNumber(courseNumber);

        preReqList = new ArrayList<CourseModel>();
        offeringList = new ArrayList<CourseOfferingModel>();
    }

    //adding a prerequisite for a course to the list
    public void addPrereq(CourseModel preReqCourse){
        preReqList.add(preReqCourse);
    }

    //adding a course offering to the list
    public void addOfferingList(int sectionNum, int capacity){
        CourseOfferingModel offering = new CourseOfferingModel(sectionNum, capacity);
        offeringList.add(offering);
    }

    public CourseOfferingModel matchOffering(int sectionNum){
        for(CourseOfferingModel i: offeringList){
            if(sectionNum == i.getSectionNum()){
                return i;
            }
        }
        //could not find a matching section number
        System.err.println("ERROR, Course cannot be found, please try again!");
        return null;
    }

    //setters and getters
    public ArrayList<CourseModel> getPreReq() {
        return this.preReqList;
    }

    public void setPreReq(ArrayList<CourseModel> preReq) {
        this.preReqList = preReq;
    }

    public ArrayList<CourseOfferingModel> getOfferingList() {
        return this.offeringList;
    }

    public void setOfferingList(ArrayList<CourseOfferingModel> offeringList) {
        this.offeringList = offeringList;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseNumber(){
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber){
        this.courseNumber = courseNumber;
    }

    @Override
    public String toString(){
        return this.courseName + " " + this.courseNumber.toString();
    }
}