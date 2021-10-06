package View;

import Controller.CatalogueController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Shows full Catalogue
 */
public class CataloguePage extends JFrame{
    
    private JTextArea textArea = new JTextArea(100, 100);
    private JButton goButton  = new JButton("Show All Courses");
    private JTextArea courseArea = new JTextArea();
    private JLabel label = new JLabel("All Courses: ");
    private JPanel panel;

    public void displayGUI(){

        panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setTitle("Show Catalogue Page");

        //configure the frame
        frame.setSize(400, 400);

        goButton.setBounds(75, 10, 200, 25);

        label.setBounds(10, 30, 350, 20);
        Font font = new Font("Courier", Font.BOLD,15);
        label.setFont(font);
        label.setVisible(false);
        courseArea.setWrapStyleWord(true);
        courseArea.setLineWrap(true);

        courseArea.setBounds(10, 60, 365, 380);
        courseArea.setEditable(false);

        //Set the layout
        panel.add(goButton);
        panel.setLayout(null);
        panel.add(courseArea);
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void addActionListener(ActionListener ListenForSearchButton) {
        goButton.addActionListener(ListenForSearchButton);
    }

    public void setTheView(String text){
        label.setVisible(true);
        courseArea.setText(text);
    }


}
