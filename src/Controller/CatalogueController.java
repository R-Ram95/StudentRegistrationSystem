package Controller;

import Model.CatalogueModel;
import View.CataloguePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogueController {
    CatalogueModel model;
    CataloguePage view;

    CatalogueController(CatalogueModel model, CataloguePage view){
        this.model = model;
        this.view = view;
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
