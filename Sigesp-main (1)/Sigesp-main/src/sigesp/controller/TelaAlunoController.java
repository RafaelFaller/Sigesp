
package sigesp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sigesp.model.Aluno;
import sigesp.model.Model;
import sigesp.model.Usuario;
import sigesp.view.*;


public class TelaAlunoController extends BaseController implements Initializable {
    
    
    
    private Usuario aluno;
    
    @FXML
    private Label titulo;
    
    @FXML
    private Label nomeLabel;
    
    @FXML
    private Label emailLabel;
    
    @FXML
    private Label matriculaLabel;
    
    public void setModel(Model model){
        this.model = model;
        this.aluno = model.getUsuarioAutt();
        atualizarTela();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    @FXML
    private void carregarTelaAcompanharCandidatura() {
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) nomeLabel.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        AcompanharCandidaturaView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaLogin() {
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) nomeLabel.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        LoginView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaInscricao() {
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) nomeLabel.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        TelaInscricaoView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaAlterarDadosUsuario() {
        System.out.println("Botão funcionando!");
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        AlterarDadosUsuarioView.carregar(stage, model);
    }
    
    @FXML
    public void atualizarTela(){
        if (aluno != null) {
            nomeLabel.setText(aluno.getNome());
            emailLabel.setText(aluno.getEmail());
            Aluno vinculo = (Aluno) aluno.getVinculo();
            String matriculaText = "Maricula: " + vinculo.getMatricula();
            matriculaLabel.setText(matriculaText);
            
            
        }
    }
    
    
    
}
