import Controller.LoginController;
import Model.CatalogueModel;
import Controller.CatalogueController;
import Model.StudentList;
import View.*;
import Controller.*;
import View.CatalogueSearchPage;
import View.RegistrationPage;
import View.StudentCoursesPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main interface for app
 */
public class RegistrationApp implements ActionListener {

    private JButton searchButton = new JButton("Search Course Catalogue");
    private JButton catalogueButton = new JButton("List Course Catalogue");
    private JButton registrationButton = new JButton("Register/Unregister Courses");
    private JButton registeredButton = new JButton("List Registered Courses");

    private CatalogueSearchPage search;
    private RegistrationPage registrationPage;
    private StudentCoursesPage registered;
    private CataloguePage catView;

    private LoginView loginView;

    public RegistrationApp(){
        searchButton.addActionListener(this);
        catalogueButton.addActionListener(this);
        registrationButton.addActionListener(this);
        registeredButton.addActionListener(this);

        // Models and Controllers here
        //all catalogue view
        catView = new CataloguePage();
        CatalogueModel catMod = new CatalogueModel();
        CatalogueController catContro = new CatalogueController(catMod, catView);

        // Catalogue search
        search = new CatalogueSearchPage();
        CatalogueModel catalogueModel = new CatalogueModel();
        CourseController courseController = new CourseController(catalogueModel, search);

        // Student login
        loginView = new LoginView();
        StudentList studentList = new StudentList();
        LoginController loginController = new LoginController(studentList ,loginView);

        // Registration
        registrationPage = new RegistrationPage();
        RegistrationController registrationController = new RegistrationController(registrationPage, loginController, courseController);

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
            search.displayGUI();
        }

        if(e.getSource() == catalogueButton){
            catView.displayGUI();
        }

        // registration button pressed
        if(e.getSource() == registrationButton){
            registrationPage.displayGUI(loginView);
        }

        // registered button pressed
        if(e.getSource() == registeredButton){
            registered = new StudentCoursesPage();
            registered.displayGUI(loginView);
        }

    }

}
