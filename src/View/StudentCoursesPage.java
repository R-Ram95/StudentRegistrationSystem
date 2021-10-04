package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Shows students registered courses
 */
public class StudentCoursesPage {

    JTextArea courseArea = new JTextArea(20, 30);

    public void displayGUI(LoginView loginView) {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Show Student Courses");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(loginView);
        panel.add(new JTextField("Student's Courses"));
        panel.add(courseArea);


        frame.add(panel);
        frame.setVisible(true);
    }

    public void setStudentCourses(String text){
        courseArea.setText(text);
    }

}
