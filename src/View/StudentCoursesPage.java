package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Shows students registered courses
 */
public class StudentCoursesPage {

    private JTextArea courseArea = new JTextArea(20, 30);
    private JButton showCourseButton = new JButton("Show Courses");

    public void displayGUI() {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Show Student Courses");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(showCourseButton);
        panel.add(new JTextField("Student's Courses"));
        panel.add(courseArea);


        frame.add(panel);
        frame.setVisible(true);
    }

    public void setStudentCourses(String text){
        courseArea.setText(text);
    }

    public void addShowCourseActionListener(ActionListener listenForCourseButton){
        showCourseButton.addActionListener(listenForCourseButton);
    }
}
