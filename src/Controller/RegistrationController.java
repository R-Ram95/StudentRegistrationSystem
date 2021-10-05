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
    private CourseController courseController;

    public RegistrationController(RegistrationPage registrationView, LoginController loginController,
                                  CourseController courseController){
        this.registrationView = registrationView;
        this.loginController = loginController;
        this.courseController = courseController;

        registrationView.addRegistrationActionListener(new RegistrationListener());
    }

    class RegistrationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String courseName = registrationView.getCourseName();
                int courseNumber = registrationView.getCourseNumber();
                int courseSection = registrationView.getCourseSection();
                theStudent = loginController.getTheStudent(); // get student from login

                // search catalogue for course
                CourseModel theCourse = courseController.model.searchCat(courseName, Integer.toString(courseNumber)); // TODO get int input
                // make sure section exists in course
                CourseOfferingModel theOffering = theCourse.searchOfferingList(courseSection);

                theStudent.registerForCourse(theCourse, theOffering);

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

}
