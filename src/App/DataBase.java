package App;

import Model.CourseModel;
import Model.CourseOfferingModel;
import Model.StudentModel;
import java.util.ArrayList;

/**
 * to imitate the workings of a real database
 */
public class DataBase {

    ArrayList<CourseModel> courses = new ArrayList<>();
    ArrayList<StudentModel> studentList = new ArrayList<>();

    /**
     * Creates an imaginary database for course in the catalogue
     * @return
     */
    public ArrayList<CourseModel> loadCatalogueFromDB(){

        courses.add(new CourseModel("ENGG", "233"));
        courses.add(new CourseModel("ENGG", "234"));
        courses.add(new CourseModel("ENGG", "235"));
        courses.add(new CourseModel("ENGG", "236"));
        courses.add(new CourseModel("ENGG", "237"));
        courses.add(new CourseModel("ENGG", "238"));


        for (CourseModel c : courses){
            c.addPrereq(new CourseModel("ENGG", "101"));
            c.addPrereq(new CourseModel("ENSF", "592"));
        }

        for (CourseModel c: courses){

            c.addOfferingList("1", 80);
            c.addOfferingList("2", 80);
            c.addOfferingList("3", 80);

            for(CourseOfferingModel o: c.getOfferingList()){
                o.setCourse(c);
            }
        }
        return courses;
    }

    /**
     * Creates an imaginary database for students.
     * @return
     */
    public ArrayList<StudentModel> loadStudentsFromDB(){
        studentList.add(new StudentModel("Holly", 1));
        studentList.add(new StudentModel("Karen", 2));
        studentList.add(new StudentModel("Josh", 3));

        return studentList;
    }
}
