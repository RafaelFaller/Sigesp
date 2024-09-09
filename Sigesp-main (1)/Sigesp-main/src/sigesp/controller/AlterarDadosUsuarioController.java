
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
import sigesp.view.LoginView;
import sigesp.view.TelaAlunoView;
import sigesp.view.TelaProfessorView;

public class AlterarDadosUsuarioController extends BaseController implements Initializable {
    
    Usuario usuario;
    
    public void setModel(Model model){
        this.model = model;
        this.usuario = model.getUsuarioAutt();
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
    
    @FXML
    private void carregarTelaInicial() {
        
        Stage stage = (Stage) titulo.getScene().getWindow();
        // Carrega a nova tela na mesma janela
        if(usuario.getVinculo() instanceof Aluno){
            TelaAlunoView.carregar(stage, model);
        } else{
            TelaProfessorView.carregar(stage, model);
        }
          
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
    
    public void atualizarTela(){
        if (usuario != null) {
            nomeLabel.setText(usuario.getNome());
            emailLabel.setText(usuario.getEmail());
            
            if(usuario.getVinculo() instanceof Aluno){
                Aluno vinculo = (Aluno) usuario.getVinculo();
                String matriculaText = "Maricula: " + vinculo.getMatricula();
                matriculaLabel.setText(matriculaText);
            }else{
                Professor vinculo = (Professor) usuario.getVinculo();
                String matriculaText = "Siape: " + vinculo.getSiape();
                matriculaLabel.setText(matriculaText);
            }    
        }
    }
    
}
