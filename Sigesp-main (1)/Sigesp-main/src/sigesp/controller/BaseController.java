
package sigesp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sigesp.model.Model;


public abstract class BaseController implements Initializable{
    
    protected Model model = inicializarModel();
    
    public Model getModel(){
        return model;
    }
    
    public void setModel(Model model){
        this.model = model;
    }
    
    private Model inicializarModel() {
        if(model == null){
            System.out.println("\nBaseController: verifique pq o model = null\n");
            model = new Model();
        }
        return model;
    }
}
