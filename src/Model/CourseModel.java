package Model;

import java.util.ArrayList;

/**
 * Holds all the information required for a cocCurse such as
 * prerequisites list and offering list
 */
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
    public void addOfferingList(String sectionNum, int capacity){
        CourseOfferingModel offering = new CourseOfferingModel(sectionNum, capacity);
        offeringList.add(offering);
    }


    /**
     * Searches the courses offerings for the given section Number
     * @param sectionNumber the section number searched for
     * @return the Course Offering
     */
    public CourseOfferingModel searchOfferingList(String sectionNumber){

        for(CourseOfferingModel o : offeringList){
            // section found
            if(o.getSectionNum().equals(sectionNumber)){
                return o;
            }
        }
        // section not found
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

//    @Override
    //get the string for the course offering list
    public String getString(){
        StringBuffer string = new StringBuffer();
//        String offeringListString = "";

        for(CourseOfferingModel o: offeringList){
            string.append(o);
        }
        return string.toString();
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append(courseName + " " + courseNumber + "\n");
        return buffer.toString();
    }

}