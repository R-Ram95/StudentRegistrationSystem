package Model;

import java.util.ArrayList;
import java.util.List;

public class CatalogueModel{
    ArrayList<CourseModel> courseList;

    //load a course catalog, a page comes up
    //supposed to load courses from a database...
    public CatalogueModel(){
        courseList = new ArrayList<CourseModel>();
        courseList = loadFromDB();
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

    //imitate loading from a database
    private static ArrayList<CourseModel> loadFromDB(){
        //irl, courses will be loaded from the DB or at least some file on disk,
        //for now just imagine, this is all coming from a DB
        ArrayList<CourseModel> imaginaryDB = new ArrayList<CourseModel>();
        //creating a new course object
        imaginaryDB.add(new CourseModel("ENGG", "233"));
        imaginaryDB.add(new CourseModel("PHYS", "259"));
        imaginaryDB.add(new CourseModel("ENSF", "607"));

        //Adding the prerequisite (1) to add 3 courses
        for(CourseModel course : imaginaryDB){
            course.addPrereq(new CourseModel("ENGG", "232"));
        }

        //Linking section number and capacity to each course, two offerings each course
        for(CourseModel course : imaginaryDB){
            //offering 1: section 1, capacity 50
            course.addOfferingList(1, 50);
            //offering 2: section 2, capacity 50
            course.addOfferingList(2, 80);

            //it sets the course
            for(CourseOfferingModel offering : course.getOfferingList()){
                offering.setCourse(course);
            }
        }
        return imaginaryDB;

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

