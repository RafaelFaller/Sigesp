package sigesp.model;

// Classe que representa o vínculo de um Usuário (pode ser Aluno ou Professor)
public abstract class Vinculo { 
    // Atributos privados da classe Vinculo
    private String tipo;

    // Construtor padrão
    public Vinculo() {}

    // Construtor com parâmetros
    public Vinculo(String tipo) {
        this.setTipo(tipo); // Verifica e define o tipo do vínculo
        
    }

    // Getter para o tipo de vínculo
    public String getTipo() {
        return tipo;
    }

    // Setter para o tipo de vínculo com verificação
    public void setTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("Tipo de vínculo não pode ser nulo ou vazio.");
        }
        this.tipo = tipo;
    }
}
