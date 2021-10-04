package App;

import Model.CourseModel;
import Model.CourseOfferingModel;

import java.util.ArrayList;

public class DataBase {

    ArrayList<CourseModel> courses = new ArrayList<>();


    public ArrayList<CourseModel> loadCatalogueFromDB(){

        courses.add(new CourseModel("ENGG", "233"));
        courses.add(new CourseModel("ENGG", "233"));
        courses.add(new CourseModel("ENGG", "233"));
        courses.add(new CourseModel("ENGG", "233"));
        courses.add(new CourseModel("ENGG", "233"));
        courses.add(new CourseModel("ENGG", "233"));


        for (CourseModel c : courses){

            c.addPrereq(new CourseModel("ENGG", "101"));
            c.addPrereq(new CourseModel("ENSF", "592"));
        }

        for (CourseModel c: courses){

            c.addOfferingList(1, 80);
            c.addOfferingList(2, 80);
            c.addOfferingList(3, 80);

            for(CourseOfferingModel o: c.getOfferingList()){
                o.setCourse(c);
            }
        }

        return courses;
    }
}
