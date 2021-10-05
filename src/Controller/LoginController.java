package Controller;

import Model.StudentList;
import Model.StudentModel;
import View.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

public class LoginController{

    LoginView loginView;
    StudentList studentList;
    StudentModel theStudent;

    public LoginController(StudentList list, LoginView login){
        loginView = login;
        studentList = list;
        loginView.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String studentName = loginView.getStudentName();
            int studentId = loginView.getStudentId();

            try {
                // search for student
                theStudent = studentList.searchStudentList(studentName, studentId);
            }catch(NullPointerException e1){
                loginView.displayErrorMessage("ERROR: Student not found.");
            }

            loginView.displayPlainMessage("Login", "Login Successful");
        }
    }

    /**
     * Returns the StudentModel.
     * @return
     */
    public StudentModel getTheStudent(){
        return theStudent;
    }
}
