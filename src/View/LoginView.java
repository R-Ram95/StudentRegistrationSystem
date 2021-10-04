package View;

import Controller.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View for logging in
 */
public class LoginView extends JPanel{
    JButton loginButton = new JButton("Login");
    JTextField nameText = new JTextField(10);
    JTextField stuNumText = new JTextField(10);

    public LoginView(){
        JLabel nameLabel = new JLabel("Student Name: ");
        add(nameLabel);
        add(nameText);
        JLabel stuNumLabel = new JLabel("Student Number: ");
        add(stuNumLabel);
        add(stuNumText);
        add(loginButton);
    }

    public void addActionListener(ActionListener buttonClicked){
        loginButton.addActionListener(buttonClicked);
    }

    public String getStudentName() {
        return nameText.getText();
    }

    public int getStudentNumber() {
        return Integer.parseInt(stuNumText.getText());
    }

}
