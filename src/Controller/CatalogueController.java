package Controller;

import Model.CatalogueModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogueController {
    CatalogueModel model;
    CatalogueController controller;

    CatalogueController(CatalogueModel model, CatalogueController controller){
        this.model = model;
        this.controller = controller;

        model.addActionListener(new CatalogueListener());
    }

    class CatalogueListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

        }

    }



}
