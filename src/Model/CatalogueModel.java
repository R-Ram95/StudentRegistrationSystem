package Model;

import java.util.ArrayList;

public class CatalogueModel {
    ArrayList<CourseModel> catalogueList;
    CatalogueModel(){
        catalogueList = new ArrayList<CourseModel>();
        catalogueList = loadFromDB();
    }

    public CourseModel searchCat(String courseName, String courseNumber){
        //this way is good for searching cause it wont do an out of bounds exception
        for(CourseModel c : catalogueList){
            if(c.getCourseName().equals(courseName) && c.getCourseNumber().equals(courseNumber)){
                return c;
            }
        }
        System.err.println("ERROR, Course " + courseName + " " + courseNumber + " does NOT exist!");
        return null;
    }

    public ArrayList<CourseModel> loadFromDB(){
        ArrayList<CourseModel> imaginaryDB = new ArrayList<CourseModel>();
        //creating a new course object
        imaginaryDB.add(new CourseModel("ENGG", "233"));
        imaginaryDB.add(new CourseModel("PHYS", "259"));
        imaginaryDB.add(new CourseModel("ENSF", "607"));

        return imaginaryDB;
    }

//    public void addCourse(CourseModel course){
//
//    }

}
