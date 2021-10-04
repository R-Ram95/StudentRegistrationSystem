package View;

import javax.swing.*;
import java.awt.*;

/**
 * RegistrationPage is the GUI for users to enter information when
 * registering or unregistering for courses.
 */
public class RegistrationPage extends JFrame {

    private JLabel courseNameLabel = new JLabel("Course Name: ");
    private JTextField courseName = new JTextField(10);
    private JLabel courseNumberLabel = new JLabel("Course Number:");
    private JTextField courseNumber = new JTextField(10);
    private JLabel sectionlabel = new JLabel("Course Section:");
    private JTextField courseSection = new JTextField(10);
    private JButton registrationButton = new JButton("Register");
    private JButton unregisterButton = new JButton("Unregister");

    public void displayGUI(LoginView loginPanel){
        JFrame frame = new JFrame("Registration Page");
        frame.setSize(600, 200);

        // registration panel
        JPanel regPanel = new JPanel();
        regPanel.setLayout(new GridLayout(4,2));
        // add components to panel
        regPanel.add(courseNameLabel);
        regPanel.add(courseName);
        regPanel.add(courseNumberLabel);
        regPanel.add(courseNumber);
        regPanel.add(sectionlabel);
        regPanel.add(courseSection);
        regPanel.add(registrationButton);
        regPanel.add(unregisterButton);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(loginPanel, BorderLayout.CENTER);
        panel.add(regPanel, BorderLayout.SOUTH);

        // add registration view
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Returns the course name entered by the user.
     * @return the course name
     */
    public String getCourseName() {
        return courseName.getText();
    }

    /**
     * Returns the course number entered by the user
     * @return the course number
     */
    public int getCourseNumber() {
        return Integer.parseInt(courseNumber.getText());
    }

    /**
     * Returns the course section entered by the user
     * @return the course section
     */
    public int getCourseSection() {
        return Integer.parseInt(courseSection.getText());
    }


}
