package sigesp.model;

public class CriterioAvaliacao {
    private String descricao;
    private double peso;

    public CriterioAvaliacao(String descricao, double peso) {
        this.descricao = descricao;
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setter com verificação
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia.");
        }
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    // Setter com verificação
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero.");
        }
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "CriterioAvaliacao [descricao=" + descricao + ", peso=" + peso + "]";
    }
}
