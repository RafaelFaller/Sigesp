
package sigesp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sigesp.model.Aluno;
import sigesp.view.LoginView;
import sigesp.view.TelaAlunoView;
import sigesp.view.TelaProfessorView;


public class AlterarProcessoController extends BaseController implements Initializable {
    
    @FXML
    private Label titulo;
    
    
    
    @FXML
    private void carregarTelaInicial() {
        
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        TelaProfessorView.carregar(stage, model);
        
        
    }
    
    @FXML
    private void carregarTelaLogin() {
        
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        LoginView.carregar(stage, model);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
