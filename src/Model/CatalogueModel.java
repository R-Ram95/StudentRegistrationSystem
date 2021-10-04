package Model;

import java.util.ArrayList;
import App.*;

public class CatalogueModel{
    ArrayList<CourseModel> courseList;
    DataBase db = new DataBase();

    //load a course catalog, a page comes up
    //supposed to load courses from a database...
    public CatalogueModel(){
        courseList = new ArrayList<CourseModel>();
        courseList = db.loadCatalogueFromDB();
    }

    public void listCourses(){
        //just loads the courses
        System.out.println(this);
    }

    @Override
    public String toString(){
        String temp = "";
        for(CourseModel c: courseList){
            temp += c + "\n";
        }
        return temp;
    }
    public CourseModel searchCat(String courseName, String courseNumber){
        //this way is good for searching cause it wont do an out of bounds exception
        for(CourseModel c : courseList){
            if(c.getCourseName().equals(courseName) && c.getCourseNumber().equals(courseNumber)){
                return c;
            }
        }
        System.err.println("ERROR, Course " + courseName + " " + courseNumber + " does NOT exist!");
        return null;
    }

    public ArrayList<CourseModel> getList(){
        return courseList;
    }

    //can create offering for every course
    public static void createOffering(){

    }

    public ArrayList<CourseModel> getCourseList(){
        return courseList;
    }

    public void setCourseList(ArrayList<CourseModel> courseList){
        this.courseList = courseList;
    }
}

