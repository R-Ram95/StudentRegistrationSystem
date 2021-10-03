package Controller;

import Model.StudentList;
import View.LoginPage;
import View.RegistrationApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    LoginPage login;
    StudentList list;

//    public static void main(String[] args) {
////        RegistrationApp app = new RegistrationApp();
////        app.displayApp();
//
//        LoginPage login = new LoginPage();
////        StudentList list = new StudentList();
////        LoginController controller= new LoginController(login, list);
//
//    }

    public LoginController(LoginPage login, StudentList list){
        this.login = login;
        this.list = list;
    }

    class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            login.getButton().addActionListener(this);
            if(e.getSource() == login.getButton()){
                RegistrationApp myApp = new RegistrationApp();
                myApp.displayApp();
        }
    }

    }

}
