package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View for logging in
 */
public class LoginPage implements ActionListener{
    JButton button = new JButton("Login");
    JTextField nameText = new JTextField();
    JTextField stuNumText = new JTextField();

    public void displayGUI() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        //configure the frame
        frame.setSize(350, 200);
        frame.add(panel);

        //Set the layout
        panel.setLayout(null);

        //name label and textbox
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);


        nameText.setBounds(150, 20, 165, 25);
        panel.add(nameText);

        //student number label and textbox
        JLabel stuNumLabel = new JLabel("Student Number: ");
        stuNumLabel.setBounds(10, 50, 120, 25);
        panel.add(stuNumLabel);

        stuNumText.setBounds(150, 50, 165, 25);
        panel.add(stuNumText);

        button.setBounds(100, 90, 100, 25);
        panel.add(button);

        button.addActionListener(this);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            RegistrationApp myApp = new RegistrationApp();
        }
    }


    public String getStudentName() {
        return nameText.getText();
    }


    public int getStudentNumber() {
        return Integer.parseInt(stuNumText.getText());
    }

}
