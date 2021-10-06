package Model;

import java.util.ArrayList;
import App.*;

public class CatalogueModel{
    ArrayList<CourseModel> courseList;
    DataBase db = new DataBase();


    public CatalogueModel(){
        courseList = new ArrayList<CourseModel>();
        courseList = db.loadCatalogueFromDB();
    }

    //gets the string of the course list
    public String getString(){
        StringBuffer attempt = new StringBuffer();
        for(CourseModel c: courseList){
            attempt.append(c + "\n");
        }
        return attempt.toString();
    }

    public CourseModel searchCat(String courseName, String courseNumber){
        //this way is good for searching cause it wont do an out of bounds exception
        for(CourseModel c : courseList){
            if(c.getCourseName().equals(courseName) && c.getCourseNumber().equals(courseNumber)){
                return c;
            }
        }
        return null;
    }

    public ArrayList<CourseModel> getList(){
        return courseList;
    }


    public ArrayList<CourseModel> getCourseList(){
        return courseList;
    }

    public void setCourseList(ArrayList<CourseModel> courseList){
        this.courseList = courseList;
    }
}

