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
    CatalogueController catalogueController;
    CatalogueSearchPage catalogueView;


    public CourseController(CatalogueController controller, CatalogueSearchPage view) {
        this.catalogueController = controller;
        this.catalogueView = view;

        view.addActionListener(new CourseListener());
    }

    /** nested class that implements action listener to facilate the communication
     * between the model and the view **/
    class CourseListener implements ActionListener {
        CourseModel courseFound;
        String courseName;
        String courseNum;

        @Override
        public void actionPerformed(ActionEvent e) {

            courseName = catalogueView.getCourseName();
            courseNum = catalogueView.getCourseNumber();

            //if the course name and course number text fields are empty, display error message
            if (courseName == null || courseNum == null){
                catalogueView.displayErrorMessage("ERROR: You must enter a course name and number.");
                catalogueView.clearText();
                return;
            }

            courseFound = catalogueController.getCatalogueModel().searchCat(courseName, courseNum);

            //if the course was not found in database, display error message
            if (courseFound == null){
                catalogueView.displayErrorMessage("ERROR: Course not found.");
                catalogueView.clearText();
                return;
            }

            //if the course was found, then display the course name, number, and offerings
            if (courseFound != null) {
                catalogueView.setCourse(courseName, courseNum, courseFound.getString());
                catalogueView.clearText();
            }
        }
    }
}

