
package sigesp.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sigesp.controller.AlterarProcessoController;
import sigesp.controller.CadastroProcessoController;
import sigesp.model.Model;

public class AlterarProcessoView {
    
    public static void carregar(Stage stage, Model model) {
        try {
            FXMLLoader loader = new FXMLLoader(LoginView.class.getResource("/sigesp/view/telaAlterarProcesso.fxml"));
            if (loader.getLocation() == null) {
                throw new IOException("O arquivo FXML não pôde ser encontrado.");
            }
            
            Parent novaTela = loader.load();
            
            AlterarProcessoController controller = loader.getController();
            controller.setModel(model);
            
            stage.setScene(new Scene(novaTela));
            stage.setTitle("Processos Seletivos");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Log adequado do erro
        }
    }
    
}
