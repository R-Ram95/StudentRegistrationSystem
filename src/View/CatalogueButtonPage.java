package View;

import java.awt.event.ActionListener;

import javax.swing.*;

public class CatalogueButtonPage extends JFrame{

    private JButton catalogueButton = new JButton ("Calculate");

    public CatalogueButtonPage () {

        JPanel cataloguePanel = new JPanel();
        setSize (300, 300);


        cataloguePanel.add(catalogueButton);


        add(cataloguePanel);

    }
    public void addActionListener (ActionListener listenForCalculateButton) {
        catalogueButton.addActionListener(listenForCalculateButton);
    }
//    public void displayErrorMessage (String errorMessage) {
//        JOptionPane.showMessageDialog(this, errorMessage);
//    }




}
