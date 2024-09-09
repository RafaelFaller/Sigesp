package sigesp.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import sigesp.view.*;
import sigesp.controller.*;

public class Model {
    
    private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private ArrayList<SelecaoPessoas> selecaoPessoas = new ArrayList<>(); // Lista de processos seletivos de pessoas
    //private ArrayList<SelecaoProjetos> selecaoProjetos = new ArrayList<>(); // Lista de processos seletivos de projetos
    private Usuario usuarioAutt; // Usuário autenticado pelo sistema
   

    /*
     * Método utilizado para notificar todos os observadores contidos no ArrayList que o modelo mudou
     */
    
    //retorna o usuario de acordo com seu id salvo no HashMap
    public Usuario getUsuario(String login) {
        if (login != null) {
            Usuario usuario = usuarios.get(login);
            return usuario;
        }
        return null;
    }

    //instanceia e cadastra um novo usuario no sistema, salvando-o no ArrayList
    public void cadastrarAluno(String nome, String email, String senha, String login, String tipoVinculo, String matriculaSiape) {
        
        // Converte a matricula em inteiro
        int matricula = converterParaInteiro(matriculaSiape);
        
        
        // Verifica se já existe um HashMap de Usuarios
        if(this.usuarios == null){
            this.usuarios = new HashMap<String, Usuario>(); 
        }
        System.out.println("\n\n Verificou se existe lista de usuários\n\n");
        Aluno aluno = new Aluno(matricula, tipoVinculo); 
        Usuario novoUsuario = new Usuario(nome, email, senha, login, aluno); // Cria um novo objeto Usuario
            if (!usuarios.containsKey(login)) { // Verifica se o login já não está cadastrado
                usuarios.put(login, novoUsuario); // Adiciona o usuário ao HashMap
                //notifica(); // Notifica os observadores
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Erro: O login já está em uso.");
            }
    }
    
    public void cadastrarProfessor(String nome, String email, String senha, String login, String tipoVinculo, String siape) {
        
        
        // Verifica se já existe um HashMap de Usuarios
        if(this.usuarios == null){
            this.usuarios = new HashMap<String, Usuario>(); 
        }
        
        Professor professor = new Professor(siape, tipoVinculo); 
        Usuario novoUsuario = new Usuario(nome, email, senha, login, professor); // Cria um novo objeto Usuario
            if (!usuarios.containsKey(login)) { // Verifica se o login já não está cadastrado
                usuarios.put(login, novoUsuario); // Adiciona o usuário ao HashMap
                //notifica(); // Notifica os observadores
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Erro: O login já está em uso.");
            }
    }

    //autentifica o usuario (logar)
    public boolean autenticarUsuario(String login, String senha) {
        if (login == null || senha == null) {
            System.out.println("Erro: Login ou senha não podem ser nulos.");
            return false;
        }

        Usuario usuario = usuarios.get(login);
        if (usuario != null && senha.equals(usuario.getSenha())) {
            usuarioAutt = usuario;
            System.out.println("Usuário autenticado com sucesso!");
            return true;
        } else {
            System.out.println("Erro: Login ou senha incorretos.");
            return false;
    }
}


    //desautentifica o usuario (deslogar)
    public void deslogarUsuario() {
        usuarioAutt = null;
        //notifica();
    }

    //retorna o usuario autenticado (usuario logado)
    public Usuario getUsuarioAutt() {
        return usuarioAutt;
    }
    
    // Método para cadastrar um novo processo seletivo de pessoas
    public boolean cadastrarSelecaoPessoas(String nome, String descricao, String vagas, LocalDate iniInscricoes, 
                                           LocalDate fimInscricoes, String professor) {
        int numVagas = converterParaInteiro(vagas);
        if (nome == null || descricao == null || numVagas <= 0 || iniInscricoes == null || fimInscricoes == null) {
            return false; // Retorna false se algum parâmetro necessário for inválido
        }
        ArrayList<String> banca = new ArrayList<String>();
        banca.add(professor);
        LocalDate dataDeHoje = LocalDate.now();
        Fase status = new Fase("Previsto", "O processo seletivo iniciará em breve.", dataDeHoje, iniInscricoes);
        SelecaoPessoas novoProcesso = new SelecaoPessoas(nome, descricao, numVagas, iniInscricoes, fimInscricoes, banca, status);
        //novoProcesso.setAlunosInscritos(alunosInscritos);
        //novoProcesso.setAprovados(aprovados);
        selecaoPessoas.add(novoProcesso);
        return true; // Processo cadastrado com sucesso
    }

    //retorna o numero de usuarios cadastrados no HashMap
    public int getTotalUsuarios() {
        return usuarios.size();
    }
    
    private boolean sohTemNumeros(String texto){
        if (texto.matches("\\d+")) {
        // A string contém apenas números
            return true;
        } else {
        // A string contém caracteres não numéricos
            System.out.println("O texto contém caracteres que não são números.");
            return false;
}
    }
    private int converterParaInteiro(String texto){
        if(sohTemNumeros(texto)){
            int inteiro = Integer.parseInt(texto);
            
            return inteiro; 
        }
        System.out.println("\nErro ao converter o texto em inteiro\n");
        return 0;
    }

    
}


