package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

import Controller.CourseController;

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



    public void displayGUI(){
        JFrame frame = new JFrame("Catalogue Search");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.setSize(400, 400);

        // format fields
        courseNameLabel.setBounds(10,20, 100, 25);
        courseName.setBounds(150, 20, 165, 25);

        courseNumberLabel.setBounds(10, 50, 100, 25);
        courseNumber.setBounds(150,50, 165, 25 );

        searchButton.setBounds(180, 85, 100, 25);

        courseArea.setBounds(10, 120, 365, 230);
        courseArea.setEditable(false);

        // add components to frame
        panel.add(courseNameLabel);
        panel.add(courseName);
        panel.add(courseNumberLabel);
        panel.add(courseNumber);
        panel.add(searchButton);
        panel.add(courseArea);

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
    public String getCourseNumber() {
        return courseNumber.getText();
    }

    public void addActionListener (ActionListener listenForSearchButton){
        searchButton.addActionListener(listenForSearchButton);
    }

    public void setCourse(String course, String courseNum, String offeringList){
        courseArea.setText(course + " " + courseNum + " Exists for the following offerings: \n" + offeringList);

    }

}
