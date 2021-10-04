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
    RegistrationApp reg;

    CatalogueController(CatalogueModel model, CataloguePage view, RegistrationApp reg){
        this.model = model;
        this.view = view;
        this.reg = reg;

        reg.addActionListener(new CatalogueListener());
    }


    class CatalogueListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            view.displayGUI();
            view.setTheView(model.toString());
        }
    }
    //gets the string version of the toString method in the model
    public String getTheList(){
        return model.toString();
    }

    public CatalogueModel getModel(){
        return model;
    }
}
