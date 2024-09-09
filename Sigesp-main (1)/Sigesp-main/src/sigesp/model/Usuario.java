package sigesp.model;

// Classe que representa um Usuário no sistema
public class Usuario { 
    // Atributos privados da classe Usuario
    private String nome;
    private String email;
    private String senha;
    private String login;
    private Vinculo vinculo;

    // Construtor padrão
    public Usuario() {
        this.vinculo = null;
    }

    // Construtor com parâmetros
    public Usuario(String nome, String email, String senha, String login, Vinculo vinculo) {
        this.setNome(nome); // Verifica e define o nome
        this.setEmail(email); // Verifica e define o email
        this.setSenha(senha); // Verifica e define a senha
        this.setLogin(login); // Verifica e define o login
        this.setVinculo(vinculo); // Verifica e define o vínculo
    }

    // Getter para o nome do usuário
    public String getNome() {
        return nome;
    }

    // Setter para o nome com verificação
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    // Getter para o email do usuário
    public String getEmail() {
        return email;
    }

    // Setter para o email com verificação
    public void setEmail(String email) {
        /*if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }*/
        this.email = email;
    }

    // Getter para a senha do usuário
    public String getSenha() {
        return senha;
    }

    // Setter para a senha com verificação
    public void setSenha(String senha) {
        if (senha == null || senha.length() < 8) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 8 caracteres.");
        }
        this.senha = senha;
    }

    // Getter para o login do usuário
    public String getLogin() {
        return login;
    }

    // Setter para o login com verificação
    public void setLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login não pode ser nulo ou vazio.");
        }
        this.login = login;
    }

    // Getter para o vínculo do usuário
    public Vinculo getVinculo() {
        return vinculo;
    }

    // Setter para o vínculo com verificação
    public void setVinculo(Vinculo vinculo) {
        if (vinculo == null) {
            throw new IllegalArgumentException("Vínculo não pode ser nulo.");
        }
        this.vinculo = vinculo;
    }

    // Sobrescreve o método toString para exibir informações do usuário
    @Override
    public String toString() {
        return "[Nome: " + nome + ", Email: " + email + ", Login: " + login + ", Vinculo: " + vinculo.getTipo() + "]";
    }
}
