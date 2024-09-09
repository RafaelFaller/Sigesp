
package sigesp.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sigesp.model.Aluno;
import sigesp.model.Model;
import sigesp.model.Professor;
import sigesp.model.Usuario;
import sigesp.model.cbEditaisDisponiveis;
import sigesp.view.AcompanharCandidaturaView;
import sigesp.view.LoginView;
import sigesp.view.TelaAlunoView;
import sigesp.view.TelaProfessorView;

public class InscricaoController extends BaseController implements Initializable {
    
    @FXML
    private ComboBox<cbEditaisDisponiveis> cbEditaisDisponiveis;
    private List<cbEditaisDisponiveis> editais = new ArrayList<>();
    private ObservableList<cbEditaisDisponiveis> obsEditais;
    
    public void carregarEditais(){
        cbEditaisDisponiveis edital1 = new cbEditaisDisponiveis(1, "Dr Diego Barros");
        cbEditaisDisponiveis edital2 = new cbEditaisDisponiveis(2, "Dr Antonio");
        
        editais.add(edital1);
        editais.add(edital2);
        
        obsEditais = FXCollections.observableArrayList(editais);
        cbEditaisDisponiveis.setItems(obsEditais);
        
    }
    

    
    
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

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
    
    @FXML
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
