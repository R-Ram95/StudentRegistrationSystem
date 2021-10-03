package Controller;

import Model.CatalogueModel;
import View.CataloguePage;
import Model.CourseModel;
import View.RegistrationApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogueController {
    CatalogueModel model;
    CataloguePage view;

    CatalogueController(CatalogueModel model, CataloguePage view){
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(new CatalogueListener());
    }


    class CatalogueListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getButton()) {
//                RegistrationApp myApp = new RegistrationApp();
//                myApp.displayApp();
                view.displayGUI(view.getButton());
            }
        }
    }
    public String getTheList(){
        return model.toString();
    }
}
