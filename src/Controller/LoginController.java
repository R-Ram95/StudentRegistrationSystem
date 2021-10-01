package Controller;

import Model.StudentList;
import View.LoginPage;
import View.RegistrationApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    LoginPage login;
    StudentList list;

    public LoginController(LoginPage login, StudentList list){
        this.login = login;
        this.list = list;

        login.getButton().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == login.getButton()){
            RegistrationApp myApp = new RegistrationApp();
            myApp.displayApp();
        }
    }

}
