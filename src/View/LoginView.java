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
    JTextField studentIdText = new JTextField(10);

    public LoginView(){
        JLabel nameLabel = new JLabel("Student Name: ");
        add(nameLabel);
        add(nameText);
        JLabel studentIdLabel = new JLabel("Student Number: ");
        add(studentIdLabel);
        add(studentIdText);
        add(loginButton);
    }

    public void addLoginListener(ActionListener listenForLogin){
        loginButton.addActionListener(listenForLogin);
    }

    public String getStudentName() {
        return nameText.getText();
    }

    public int getStudentId() {
        return Integer.parseInt(studentIdText.getText());
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
