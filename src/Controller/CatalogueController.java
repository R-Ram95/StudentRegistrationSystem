package Controller;

import Model.CatalogueModel;

public class CatalogueController {
    CatalogueModel model;
    CatalogueController controller;

    CatalogueController(CatalogueModel model, CatalogueController controller){
        this.model = model;
        this.controller = controller;
    }

    
}
