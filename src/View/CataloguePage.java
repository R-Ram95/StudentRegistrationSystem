package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Shows full Catalogue
 */
public class CataloguePage {


    public void displayGUI() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        ArrayList<String> test = new ArrayList<>();
        test.add("ENSF 611");
        test.add("ENSF 612");
        test.add("ENSF 614");

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


        int length = 70;

        for(int i = 0; i<test.size(); i++){
            JLabel courseLabel = new JLabel(test.get(i));
            courseLabel.setBounds(10, length, 80, 25);
            panel.add(courseLabel);
            length = length + 50;
        }


        frame.setVisible(true);
    }


}
