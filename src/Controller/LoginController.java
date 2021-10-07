package Controller;

import Model.StudentList;
import Model.StudentModel;
import View.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController{

    private LoginPage loginView;
    private StudentList studentList;
    private StudentModel theStudent;

    public LoginController(StudentList list, LoginPage login){
        loginView = login;
        studentList = list;
        loginView.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String studentName = loginView.getStudentName();
                int studentId = loginView.getStudentId();

                // search for student
                theStudent = studentList.searchStudentList(studentName, studentId);
                loginView.displayPlainMessage("Login", "Login Successful");
            } // Login was not successful
            catch (NumberFormatException e1){
                loginView.displayErrorMessage("ERROR: Enter student name and number.");
            }
            catch(NullPointerException e2){
                loginView.displayErrorMessage("ERROR: Student not found.");
            }
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
