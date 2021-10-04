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

    private CatalogueController controller;
//    private JButton button;

    private JTextArea textArea = new JTextArea();


    public void displayGUI(){

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setTitle("Show Catalogue Page");

        //configure the frame
        frame.setSize(700, 500);
        frame.add(panel);

        //Set the layout
        panel.setLayout(null);

        JLabel label = new JLabel("All the courses available in the catalogue: ");
        Font font = new Font("Courier", Font.BOLD,15);
        label.setFont(font);
        label.setBounds(10, 20, 800, 25);
        panel.add(label);

        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);


        frame.setVisible(true);
    }

    public void setTheView(String text){
//        textArea = new JTextArea("" + controller.getTheList());
        textArea = new JTextArea(text);
    }



}
