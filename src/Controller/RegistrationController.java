package Controller;

import Model.CourseModel;
import Model.CourseOfferingModel;
import Model.StudentModel;
import View.RegistrationPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationController {

    private StudentModel theStudent;
    private RegistrationPage registrationView;
    private LoginController loginController;
    private CatalogueController catalogueController;

    public RegistrationController(RegistrationPage registrationView, LoginController loginController,
                                  CatalogueController catalogueController){
        this.registrationView = registrationView;
        this.loginController = loginController;
        this.catalogueController = catalogueController;

        registrationView.addRegistrationActionListener(new RegistrationListener());
        registrationView.addUnregistrationActionListener(new UnregistrationListener());
    }

    class RegistrationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String courseName = registrationView.getCourseName();
                int courseNumber = registrationView.getCourseNumber();
                int courseSection = registrationView.getCourseSection();

                theStudent = loginController.getTheStudent(); // get student from login


                theStudent.registerForCourse(catalogueController.getCatalogueModel(), courseName,
                        Integer.toString(courseNumber), courseSection);

                // registration was successful
                registrationView.displayPlainMessage("Registration", "Course registered");
                registrationView.clearText();
            }
            // user did not enter course information
            catch (NumberFormatException e2){
                registrationView.displayErrorMessage("ERROR: You must enter a course name, number, and section");

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
            try {
                String courseName = registrationView.getCourseName();
                int courseNumber = registrationView.getCourseNumber();
                int courseSection = registrationView.getCourseSection();

                theStudent = loginController.getTheStudent(); // get student from login
                theStudent.removeCourse(courseName, Integer.toString(courseNumber), courseSection);
                registrationView.displayPlainMessage("Registration", "Unregistered from Course.");

            }
            // user did not enter course information
            catch (NumberFormatException e2){
                registrationView.displayErrorMessage("ERROR: You must enter a course name, number, and section");

            }
            // course not found
            catch(NullPointerException e1){
                registrationView.displayErrorMessage("ERROR: Course not found.");
            }
        }
    }

}
