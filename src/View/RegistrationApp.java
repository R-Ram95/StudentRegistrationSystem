package View;

import Controller.LoginController;
import Model.StudentList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View.Main interface for app
 */
public class RegistrationApp implements ActionListener {

    private JButton searchButton = new JButton("Search Course Catalogue");
    private JButton catalogueButton = new JButton("List Course Catalogue");
    private JButton registrationButton = new JButton("Register/Unregister Courses");
    private JButton registeredButton = new JButton("List Registered Courses");

    private CatalogueSearchPage search;
    private CataloguePage catalogue;
    private RegistrationPage registration;
    private StudentCoursesPage registered;

    public RegistrationApp(){
        searchButton.addActionListener(this);
        catalogueButton.addActionListener(this);
        registrationButton.addActionListener(this);
        registeredButton.addActionListener(this);
    }

    public void displayApp() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setTitle("Registration App");

        //configure the frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        //Set the layout
        panel.setLayout(null);

        // formatting
        searchButton.setBounds(75, 10, 200, 25);
        catalogueButton.setBounds(75, 50, 200, 25);
        registrationButton.setBounds(75, 90, 200, 25);
        registeredButton.setBounds(75, 130, 200, 25);

        // add components
        panel.add(searchButton);
        panel.add(catalogueButton);
        panel.add(registrationButton);
        panel.add(registeredButton);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // search button pressed
        if(e.getSource() == searchButton){
            search = new CatalogueSearchPage();
            search.displayGUI();
        }

        // catalogue button pressed
        if(e.getSource() == catalogueButton){
            catalogue = new CataloguePage();
            catalogue.setButton(catalogueButton);
//            catalogue.displayGUI();

        }

        // registration button pressed
        if(e.getSource() == registrationButton){
            registration = new RegistrationPage();
            registration.displayGUI();
        }

        // registered button pressed
        if(e.getSource() == registeredButton){
            registered = new StudentCoursesPage();
            registered.displayGUI();
        }

    }

    public static void main(String[] args) {
//        RegistrationApp app = new RegistrationApp();
//        app.displayApp();

        LoginPage login = new LoginPage();
        StudentList list = new StudentList();
        LoginController controller= new LoginController(login, list);


    }
}
