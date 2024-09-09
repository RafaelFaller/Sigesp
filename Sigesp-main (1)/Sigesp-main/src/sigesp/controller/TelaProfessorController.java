
package sigesp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sigesp.model.Aluno;
import sigesp.model.Model;
import sigesp.model.Professor;
import sigesp.model.Usuario;
import sigesp.view.AcompanharCandidaturaView;
import sigesp.view.AlterarDadosUsuarioView;
import sigesp.view.AlterarProcessoView;
import sigesp.view.CadastroProcessoView;
import sigesp.view.CadastroProjetoView;
import sigesp.view.LoginView;
import sigesp.view.TelaInscricaoView;

public class TelaProfessorController extends BaseController implements Initializable {
    
    private Usuario usuarioAutt;
    
    public void setModel(Model model){
        this.model = model;
        this.usuarioAutt = model.getUsuarioAutt();
        atualizarTela();
    }
    
    @FXML
    private Label titulo;
    
    @FXML
    private Label nomeLabel;
    
    @FXML
    private Label emailLabel;
    
    @FXML
    private Label matriculaLabel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void atualizarTela(){
        if (usuarioAutt != null) {
            nomeLabel.setText(usuarioAutt.getNome());
            emailLabel.setText(usuarioAutt.getEmail());
            Professor vinculo = (Professor) usuarioAutt.getVinculo();
            String matriculaText = "Siape: " + vinculo.getSiape();
            matriculaLabel.setText(matriculaText);
        }
    }
    
    @FXML
    private void carregarTelaLogin() {
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        LoginView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaAcompanharCandidatura() {
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        AcompanharCandidaturaView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaInscricao() {
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        TelaInscricaoView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaCadastroProcesso() {
        System.out.println("Botão funcionando!");
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        CadastroProcessoView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaAlterarProcesso() {
        System.out.println("Botão funcionando!");
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        AlterarProcessoView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaCadastrarProjeto() {
        System.out.println("Botão funcionando!");
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        CadastroProjetoView.carregar(stage, model);
    }
    
    @FXML
    private void carregarTelaAlterarDadosUsuario() {
        System.out.println("Botão funcionando!");
        // Obtém o Stage atual a partir de um componente da cena
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        AlterarDadosUsuarioView.carregar(stage, model);
    }
}
