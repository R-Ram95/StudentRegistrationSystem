package Controller;

import Model.StudentModel;
import View.RegistrationPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationController {

    private StudentModel theStudent;
    private RegistrationPage registrationView;

    public RegistrationController(RegistrationPage registrationView, LoginController loginController){

    }

    class RegistrationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String courseName = registrationView.getCourseName();
            int courseNumber = registrationView.getCourseNumber();
            int courseSection = registrationView.getCourseSection();

            // TODO Add Registration
            theStudent.registerForCourse();
        }
    }

}
