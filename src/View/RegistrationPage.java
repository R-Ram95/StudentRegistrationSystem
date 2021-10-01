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

    public void displayGUI(){
        JFrame frame = new JFrame("Registration Page");
        JPanel panel = new JPanel();
        panel.setLayout(null);

        frame.setSize(400, 200);

        // formant components
        courseNameLabel.setBounds(10,20, 100, 25);
        courseName.setBounds(150, 20, 165, 25);

        courseNumberLabel.setBounds(10, 50, 100, 25);
        courseNumber.setBounds(150,50, 165, 25 );

        sectionlabel.setBounds(10, 80, 100, 25);
        courseSection.setBounds(150, 80, 165, 25);

        registrationButton.setBounds(10, 125, 165, 25);
        unregisterButton.setBounds(180, 125, 165, 25);

        // add components to panel
        panel.add(courseNameLabel);
        panel.add(courseName);
        panel.add(courseNumberLabel);
        panel.add(courseNumber);
        panel.add(sectionlabel);
        panel.add(courseSection);
        panel.add(registrationButton);
        panel.add(unregisterButton);

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
