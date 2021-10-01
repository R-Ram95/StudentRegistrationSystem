package View;

import javax.swing.*;
import java.awt.*;

/**
 * Search catalogue for a course
 */
public class CatalogueSearchPage {

    private JLabel courseNameLabel = new JLabel("Course Name");
    private JTextField courseName = new JTextField(10);
    private JLabel courseNumberLabel = new JLabel("Course Number");
    private JTextField courseNumber = new JTextField(10);
    private JButton searchButton = new JButton("Go");
    private JTextArea courseArea = new JTextArea(30, 30);

    public CatalogueSearchPage(){
        JFrame frame = new JFrame("Catalogue Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // panel for course name
        JPanel namePanel = new JPanel();
        namePanel.add(courseNameLabel);
        namePanel.add(courseName);

        // panel for course number
        JPanel numberPanel = new JPanel();
        numberPanel.add(courseNumberLabel);
        numberPanel.add(courseNumber);

        // panel to contain input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        // add components to input panel
        inputPanel.add(namePanel, BorderLayout.NORTH);
        inputPanel.add(numberPanel, BorderLayout.CENTER);

        // add buttons to buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(searchButton);

        // put all components into frame
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(courseArea);

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

}
