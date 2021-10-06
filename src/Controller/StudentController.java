package Controller;

import Model.StudentModel;
import View.StudentCoursesPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {

    private StudentCoursesPage studentCoursesPage;
    private StudentModel theStudent;

    public StudentController(StudentCoursesPage studentCoursesPage, StudentModel theStudent){
        this.studentCoursesPage = studentCoursesPage;
        this.theStudent= theStudent;

        studentCoursesPage.addShowCourseActionListener(new ShowCourseListener());
    }

    class ShowCourseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            studentCoursesPage.setStudentCourses(theStudent.showCourseList());
        }
    }

}
