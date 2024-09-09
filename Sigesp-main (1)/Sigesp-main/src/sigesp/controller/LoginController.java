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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sigesp.model.*;
import sigesp.view.TelaAlunoView;
import sigesp.view.TelaProfessorView;

public class LoginController extends BaseController implements Initializable {
    

  
// LOGIN
    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;
    
    @FXML
    private Label erroLogin;
    
    @FXML
    private void entrar(ActionEvent event) {
        
        if (usuario == null || senha == null) {
            System.out.println("Os campos de usuário ou senha não foram inicializados.");
            return;
        }
        String nome1 = usuario.getText();
        String senha1 = senha.getText();
        
        
        // Aqui você pode adicionar a lógica para verificar o login no banco de dados ou um serviço
        boolean autenticado = model.autenticarUsuario(nome1, senha1);
        
        if(autenticado){
            erroLogin.setText("");
            Usuario usuarioAutt = model.getUsuarioAutt();
            System.out.println("Login efetuado com sucesso");
            if (usuarioAutt != null && usuarioAutt.getVinculo() != null) {
                if (usuarioAutt.getVinculo().getTipo().equals("Aluno")) {
                    carregarTelaAluno();
                } else if (usuarioAutt.getVinculo().getTipo().equals("Professor")) {
                    carregarTelaProfessor();
                } else {
                    erroLogin.setText("Erro do sistema");
                }
            } else {
                erroLogin.setText("Erro do sistema");
            }
 
            
        } else{
            limparCampos();
            // Mostrar mensagem de erro
            erroLogin.setText("Usuário ou a senha estão incorretos");
        }

    }

//CADASTRO    
    
    @FXML
    private RadioButton opcaoAluno;

    @FXML
    private RadioButton opcaoProfessor;
    
    @FXML
    private TextField nomeCompleto;
    
    @FXML
    private TextField email;

    @FXML
    private TextField matricula;
    
    @FXML
    private PasswordField senhaCadastro;
    
    @FXML
    private void cadastrar(ActionEvent evento){
        String nomeCompleto1 = nomeCompleto.getText();
        String email1 = email.getText();
        String senhaCadastro1 = senhaCadastro.getText();
        String login = email1;
        String tipoVinculo = identificarVinculo();
        String matriculaSiape = matricula.getText();
        
        
        if(tipoVinculo == "Aluno"){
            model.cadastrarAluno(nomeCompleto1, email1, senhaCadastro1, login, tipoVinculo, matriculaSiape);
            System.out.println("\n\n Usuário Cadastrado!!!\n\n");
        } else if (tipoVinculo == "Professor"){
            model.cadastrarProfessor(nomeCompleto1, email1, senhaCadastro1, login, tipoVinculo, matriculaSiape);
        }

        System.out.println("Usuario Cadastrado: "+nomeCompleto.getText()+ " "+email.getText()+" "+model.getTotalUsuarios());
        
        limparCampos();                   
    }

    private void limparCampos(){
        usuario.clear();
        senha.clear();
        nomeCompleto.clear();
        email.clear();
        matricula.clear();
        senhaCadastro.clear();
    }
    
    public void carregarTelaAluno() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sigesp/view/telaAluno.fxml"));
            if (loader.getLocation() == null) {
                throw new IOException("O arquivo FXML não pôde ser encontrado.");
            }
            Parent novaTela = loader.load();
            
            // Obtém o controlador da nova tela
            TelaAlunoController telaAlunoController = loader.getController();
            telaAlunoController.setModel(model);

            // Obtém o Stage atual
            Stage stage = (Stage) usuario.getScene().getWindow();
            stage.setScene(new Scene(novaTela));

            // Opcional: Atualize o título da janela
            stage.setTitle("Tela Inicial");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o FXML: " + e.getMessage());
        }
    }
    public void carregarTelaProfessor() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sigesp/view/telaProfessor.fxml"));
            if (loader.getLocation() == null) {
                throw new IOException("O arquivo FXML não pôde ser encontrado.");
            }
            Parent novaTela = loader.load();
            
            // Obtém o controlador da nova tela
            TelaProfessorController telaProfessorController = loader.getController();
            telaProfessorController.setModel(model);

            // Obtém o Stage atual
            Stage stage = (Stage) usuario.getScene().getWindow();
            stage.setScene(new Scene(novaTela));

            // Opcional: Atualize o título da janela
            stage.setTitle("Tela Inicial");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o FXML: " + e.getMessage());
        }
    }
    
    @FXML
    private String identificarVinculo(){
        if (opcaoAluno.isSelected()) {
            return "Aluno";    
        } else if (opcaoProfessor.isSelected()) {
            return "Professor";
        } else {
            return ""; // Caso nenhum esteja selecionado, mas idealmente deve ser tratado como erro
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
  
        // Inicializações necessárias quando a tela é carregada
        ToggleGroup toggleGroup = new ToggleGroup();
        opcaoAluno.setToggleGroup(toggleGroup);
        opcaoProfessor.setToggleGroup(toggleGroup);
    }
}
