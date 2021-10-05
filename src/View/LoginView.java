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

    /**
     * Returns the StudentModel students name.
     * @return
     */
    public String getStudentName() {
        return nameText.getText();
    }

    /**
     * Returns the StudentModel students id.
     * @return
     */
    public int getStudentId() {
        return Integer.parseInt(studentIdText.getText());
    }

    /**
     * Displays an error message in a dialog box.
     * @param errorMessage the error message
     */
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    /**
     * Displays a plain message in a dialog box
     * @param titleMessage title of the dialog box
     * @param plainMessage the plain message
     */
    public void displayPlainMessage(String titleMessage,String plainMessage){
        JOptionPane.showMessageDialog(this, plainMessage, titleMessage, JOptionPane.PLAIN_MESSAGE);
    }
}
