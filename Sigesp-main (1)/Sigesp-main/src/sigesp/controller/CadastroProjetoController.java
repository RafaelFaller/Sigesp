
package sigesp.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sigesp.view.LoginView;
import sigesp.view.TelaProfessorView;

public class CadastroProjetoController extends BaseController implements Initializable {
    
    @FXML
    private Label titulo;
    
    @FXML
    private Label nomeLabel;
    
    @FXML
    private Label emailLabel;
    
    @FXML
    private Label matriculaLabel;
    
    @FXML
    private TextField nomeProjeto;
    
    @FXML
    private TextField coordenadorProjeto;
    
    @FXML
    private DatePicker dataInicioProjeto;
    
    @FXML
    private TextField descricaoProjeto;
    
    
    @FXML
    private void cadastrarProjeto(){
        String nome = nomeProjeto.getText();
        String coordenador = coordenadorProjeto.getText();
        LocalDate dataInicio = dataInicioProjeto.getValue();
        String descricao = descricaoProjeto.getText();
    }
    
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
