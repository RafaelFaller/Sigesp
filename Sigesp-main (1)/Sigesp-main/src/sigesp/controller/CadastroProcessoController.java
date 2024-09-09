
package sigesp.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sigesp.view.LoginView;
import sigesp.view.TelaProfessorView;

public class CadastroProcessoController extends BaseController implements Initializable {
    
    @FXML
    private Label titulo;
    
    @FXML
    private Label nomeLabel;
    
    @FXML
    private Label emailLabel;
    
    @FXML
    private Label matriculaLabel;
    
    @FXML
    private TextField nomeProcesso;
    
    @FXML
    private ComboBox membroBanca1;
    
    @FXML
    private ComboBox membroBanca2;
    
    @FXML
    private ComboBox membroBanca3;
    
    @FXML
    private TextArea descricaoProcesso;
    
    @FXML
    private TextField numVagas;
    
    @FXML
    private DatePicker dataInscricoes;
    
    @FXML
    private DatePicker dataFimInscricoes;
    
    
    @FXML
    private void cadastrarProcessoPessoas(){
        String nome = nomeProcesso.getText();
        String descricao = descricaoProcesso.getText();
        String vagas = numVagas.getText();
        LocalDate dtInicioInscricoes = dataInscricoes.getValue();
        LocalDate dtFimInscricoes = dataFimInscricoes.getValue();
        String banca = (String) membroBanca1.getValue();
        model.cadastrarSelecaoPessoas(nome, descricao, vagas, dtInicioInscricoes, dtFimInscricoes, banca);
        System.out.println("\nProcesso Seletivo Cadastrado\n");
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
    
    @FXML
    private void limparCampos(){
        nomeProcesso.clear();
        descricaoProcesso.clear();
        numVagas.clear();
        dataInscricoes.setValue(null);
        dataFimInscricoes.setValue(null);
        membroBanca1.setValue(null);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> membros = FXCollections.observableArrayList(
            "Membro 1",
            "Membro 2",
            "Membro 3",
            "Membro 4"
        );

        // Define os itens em cada ComboBox
        membroBanca1.setItems(membros);
        membroBanca2.setItems(membros);
        membroBanca3.setItems(membros);
    }    
    
}
