package View;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * View.Main interface for app
 */
public class App {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();


    App(){

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        //configure the frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        //Set the layout
        panel.setLayout(null);

        //student number label and textbox
        JLabel stuNumLabel = new JLabel("Student Number: ");
        stuNumLabel.setBounds(10, 50, 80, 25);
        panel.add(stuNumLabel);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        frame.setVisible(true);

    }

    public void displayApp() {

    }
}
