package View;

import javax.swing.*;
import java.awt.*;

/**
 * RegistrationPage is the GUI for users to enter information when
 * registering or unregistering for courses.
 */
public class RegistrationPage extends JFrame {

    private JLabel courseNameLabel = new JLabel("Course Name");
    private JTextField courseName = new JTextField(10);
    private JLabel courseNumberLabel = new JLabel("Course Number");
    private JTextField courseNumber = new JTextField(10);
    private JLabel sectionlabel = new JLabel("Course Section");
    private JTextField courseSection = new JTextField(10);
    private JButton registrationButton = new JButton("Register");
    private JButton unregisterButton = new JButton("Unregister");

    public RegistrationPage(){
        JFrame frame = new JFrame("Registration Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // panel for course name
        JPanel namePanel = new JPanel();
        namePanel.add(courseNameLabel);
        namePanel.add(courseName);

        // panel for course number
        JPanel numberPanel = new JPanel();
        numberPanel.add(courseNumberLabel);
        numberPanel.add(courseNumber);

        // panel for course section
        JPanel sectionPanel = new JPanel();
        sectionPanel.add(sectionlabel);
        sectionPanel.add(courseSection);

        // panel to contain input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        // add components to input panel
        inputPanel.add(namePanel, BorderLayout.NORTH);
        inputPanel.add(numberPanel, BorderLayout.CENTER);
        inputPanel.add(sectionPanel, BorderLayout.SOUTH);

        // add buttons to buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registrationButton);
        buttonPanel.add(unregisterButton);

        // put all components into frame
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

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
