package Controller;

import Model.CatalogueModel;
import View.CatalogueSearchPage;
import Model.CourseModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The course controller class receives course name and number from user
 * and checks if it exists and displays the offerings of the course if
 * it exists.
 */
public class CourseController {
    CatalogueModel model;
    CatalogueSearchPage view;

    public CourseController(CatalogueModel model, CatalogueSearchPage view) {
        this.model = model;
        this.view = view;

        view.addActionListener(new CourseListener());
    }

    /** nested class that implements action listener to facilate the communication
     * between the model and the view **/
    class CourseListener implements ActionListener {
        String courseName;
        String courseNum;
        CourseModel courseFound;

        @Override
        public void actionPerformed(ActionEvent e) {

            courseName = view.getCourseName();
            courseNum = view.getCourseNumber();

            //if the course name and course number text fields are empty, display error message
            if (courseName == null || courseNum == null){
                view.displayErrorMessage("ERROR: You must enter a course name and number.");
                view.clearText();
                return;
            }

            courseFound = model.searchCat(courseName, courseNum);

            //if the course was not found in database, display error message
            if (courseFound == null){
                view.displayErrorMessage("ERROR: Course not found.");
                view.clearText();
                return;
            }

            //if the course was found, then display the course name, number, and offerings
            if (courseFound != null) {
                view.setCourse(courseName, courseNum, courseFound.getString());
                view.clearText();
            }
        }
    }
}

