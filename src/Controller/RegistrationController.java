package Controller;

import Model.CatalogueModel;
import Model.StudentModel;
import View.RegistrationPage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationController {

    private StudentModel theStudent;
    private RegistrationPage registrationView;
    private CatalogueModel catalogueModel;

    public RegistrationController(RegistrationPage registrationView, StudentModel theStudent,
                                  CatalogueModel catalogueModel){
        this.registrationView = registrationView;
        this.catalogueModel = catalogueModel;
        this.theStudent = theStudent;

        registrationView.addRegistrationActionListener(new RegistrationListener());
        registrationView.addUnregistrationActionListener(new UnregistrationListener());
    }

    class RegistrationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String courseName = registrationView.getCourseName();
            String courseNumber = registrationView.getCourseNumber();
            String courseSection = registrationView.getCourseSection();

            // information not entered
            if(courseName == null || courseNumber == null || courseSection == null){
                registrationView.displayErrorMessage("ERROR: You must enter a course name, number, and section");
                return;
            }

            // student not logged in
            if(theStudent == null){
                registrationView.displayErrorMessage("You must login");
                return;
            }

            try {
                theStudent.registerForCourse(catalogueModel, courseName,
                                                courseNumber, courseSection);
                // registration was successful
                registrationView.displayPlainMessage("Registration", "Course registered");
                registrationView.clearText();
            }
            // the course was not found
            catch(NullPointerException e1){
                registrationView.displayErrorMessage("ERROR: Course not found.");
            }
        }
    }

    class UnregistrationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String courseName = registrationView.getCourseName();
            String courseNumber = registrationView.getCourseNumber();

            // information not entered
            if(courseName == null || courseNumber == null){
                registrationView.displayErrorMessage("ERROR: You must enter a course name and number");
                return;
            }

            // student not logged in
            if(theStudent == null){
                registrationView.displayErrorMessage("You must login");
                return;
            }

            try {
                theStudent.removeCourse(courseName, courseNumber);
                // successfully unregistered
                registrationView.displayPlainMessage("Registration", "Unregistered from Course.");
            }
            // course not found
            catch(NullPointerException e1){
                registrationView.displayErrorMessage("ERROR: You are not registered for this course.");
            }
        }
    }

}
