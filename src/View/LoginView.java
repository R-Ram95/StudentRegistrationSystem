package View;

import Controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View for logging in
 */
public class LoginView extends JFrame{
    JButton loginButton = new JButton("Login");
    JTextField nameText = new JTextField();
    JTextField studentIdText = new JTextField();

    public void displayGUI(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        //configure the frame
        frame.setSize(350, 200);
        frame.add(panel);

        //Set the layout
        panel.setLayout(null);

        //name label and textbox
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);


        nameText.setBounds(150, 20, 165, 25);
        panel.add(nameText);

        //student number label and textbox
        JLabel stuNumLabel = new JLabel("Student Number: ");
        stuNumLabel.setBounds(10, 50, 120, 25);
        panel.add(stuNumLabel);

        studentIdText.setBounds(150, 50, 165, 25);
        panel.add(studentIdText);

        loginButton.setBounds(100, 90, 100, 25);
        panel.add(loginButton);


        frame.setVisible(true);
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
