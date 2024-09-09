/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package sigesp.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sigesp.controller.LoginController;
import sigesp.controller.TelaProfessorController;
import sigesp.model.Model;

public class TelaProfessorView extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sigesp/view/telaProfessor.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void carregar(Stage stage, Model model) {
        try {
            FXMLLoader loader = new FXMLLoader(LoginView.class.getResource("/sigesp/view/telaProfessor.fxml"));
            if (loader.getLocation() == null) {
                throw new IOException("O arquivo FXML não pôde ser encontrado.");
            }
            
            Parent novaTela = loader.load();
            
            TelaProfessorController controller = loader.getController();
            controller.setModel(model);
            
            stage.setScene(new Scene(novaTela));
            stage.setTitle("Tela Inicial");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Log adequado do erro
        }
    }
    
}
