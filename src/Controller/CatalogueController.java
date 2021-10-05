package Controller;

import Model.CatalogueModel;
import View.CataloguePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The catalogue controller class receives action from a button
 * and then calls the model to provide all the courses available
 * in the catalogue.
 */
public class CatalogueController {
    CatalogueModel model;
    CataloguePage view;

    public CatalogueController(CatalogueModel model, CataloguePage view){
        this.model = model;
        this.view = view;

        view.addActionListener(new CatalogueListener());
    }

    /** nested class that implements action listener to facilate the communication
     * between the model and the view **/
    class CatalogueListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String courses = model.getString();
            view.setTheView(courses);
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
