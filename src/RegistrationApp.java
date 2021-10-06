import Controller.LoginController;
import Model.CatalogueModel;
import Controller.CatalogueController;
import Model.StudentList;
import Model.StudentModel;
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

    private JButton loginButton = new JButton("Student Login");
    private JButton searchButton = new JButton("Search Course Catalogue");
    private JButton catalogueButton = new JButton("List Course Catalogue");
    private JButton registrationButton = new JButton("Register/Unregister Courses");
    private JButton registeredButton = new JButton("List Registered Courses");

    private LoginView loginView;
    private CatalogueSearchPage search;
    private RegistrationPage registrationPage;
    private StudentCoursesPage studentCoursesPage;
    private CataloguePage catView;

    private LoginController loginController;
    private StudentModel theStudent;

    public void runApp(){

        loginButton.addActionListener(this);
        searchButton.addActionListener(this);
        catalogueButton.addActionListener(this);
        registrationButton.addActionListener(this);
        registeredButton.addActionListener(this);

        //all catalogue view
        catView = new CataloguePage();
        CatalogueModel catalogueModel = new CatalogueModel();
        CatalogueController catalogueController = new CatalogueController(catalogueModel, catView);

        // Catalogue search
        search = new CatalogueSearchPage();
        CourseController courseController = new CourseController(catalogueController, search);

        displayApp();
    }

    public void displayApp() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setTitle("Registration App");

        //configure the frame
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        //Set the layout
        panel.setLayout(null);

        // formatting
        loginButton.setBounds(75, 10, 200, 25);
        searchButton.setBounds(75, 50, 200, 25);
        catalogueButton.setBounds(75, 90, 200, 25);
        registrationButton.setBounds(75, 130, 200, 25);
        registeredButton.setBounds(75, 170, 200, 25);

        // add components
        panel.add(loginButton);
        panel.add(searchButton);
        panel.add(catalogueButton);
        panel.add(registrationButton);
        panel.add(registeredButton);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // login pressed
        if(e.getSource() == loginButton){
            loginView = new LoginView();
            StudentList studentList = new StudentList();
            loginController = new LoginController(studentList, loginView);
            loginView.displayGUI();
        }

        // search button pressed
        if(e.getSource() == searchButton){
            search.displayGUI();
        }

        if(e.getSource() == catalogueButton){
            catView.displayGUI();
        }

        // registration button pressed
        if(e.getSource() == registrationButton){
            registrationPage = new RegistrationPage();

            CatalogueModel catalogueModel = new CatalogueModel();
            theStudent = loginController.getTheStudent();

            RegistrationController registrationController = new RegistrationController(registrationPage, theStudent,
                    catalogueModel);
            registrationPage.displayGUI();
        }

        // registered button pressed
        if(e.getSource() == registeredButton){
            studentCoursesPage = new StudentCoursesPage();
            theStudent = loginController.getTheStudent();

            StudentController studentController = new StudentController(studentCoursesPage, theStudent);
            studentCoursesPage.displayGUI();
        }

    }
}
