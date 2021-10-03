package Controller;

import Model.CourseModel;
import View.RegistrationApp;
import View.StudentCoursesPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseController {
    CourseModel model;
    StudentCoursesPage view;

    CourseController(CourseModel model, StudentCoursesPage view){
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(new CourseListener());
    }
    class CourseListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getButton()) {
//                RegistrationApp myApp = new RegistrationApp();
//                myApp.displayApp();
            }
        }
    }
}
