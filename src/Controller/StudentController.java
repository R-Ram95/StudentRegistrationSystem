package Controller;

import Model.StudentModel;
import View.StudentCoursesPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {

    private StudentCoursesPage studentCoursesPage;
    private LoginController loginController;

    public StudentController(StudentCoursesPage studentCoursesPage, LoginController loginController){
        this.studentCoursesPage = studentCoursesPage;
        this.loginController = loginController;

        studentCoursesPage.addShowCourseActionListener(new ShowCourseListener());
    }

    class ShowCourseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // get the student
            StudentModel theStudent = loginController.getTheStudent();

            studentCoursesPage.setStudentCourses(theStudent.showCourseList());
        }
    }

}
