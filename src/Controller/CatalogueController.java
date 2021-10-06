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
    CatalogueModel catalogueModel;
    CataloguePage catalogueView;

    public CatalogueController(CatalogueModel model, CataloguePage view){
        this.catalogueModel = model;
        this.catalogueView = view;

        view.addActionListener(new CatalogueListener());
    }

    /** nested class that implements action listener to facilate the communication
     * between the model and the view **/
    class CatalogueListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String courses = catalogueModel.getString();
            catalogueView.setTheView(courses);
        }
    }
    
    public CatalogueModel getCatalogueModel(){
        return catalogueModel;
    }
}
