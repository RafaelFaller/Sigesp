package sigesp.model;

import java.util.List;
import java.time.LocalDate;
import sigesp.model.Professor;
public abstract class ProcessoSeletivo {
    private String nome;
    private String descricao;
    private int numVagas;
    private List<String> banca; 
    private int numInscritos;
    private int numAprovados;
    private Fase status;
    private Avaliacao avaliacao;

    public ProcessoSeletivo(){}
    
    public ProcessoSeletivo(
        String nome,
        String descricao, 
        int numVagas, 
        LocalDate iniInscricoes, 
        LocalDate fimInscricoes, 
        List<String> banca,   
        Fase status) {
        this.nome = nome;
        this.descricao = descricao;
        this.numVagas = numVagas;
        this.banca = banca;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        if (descricao != null) {
            this.descricao = descricao;
        }
    }
    
    public int getNumVagas() {
        return numVagas;
    }
    
    public void setNumVagas(int numVagas) {
        if (numVagas > 0) {
            this.numVagas = numVagas;
        }
    }
    
    public List<String> getBanca() {
        return banca;
    }
    
    public void setBanca(List<String> banca) {
        if (banca != null) {
            this.banca = banca;
        }
    }
    
    public int getNumInscritos() {
        return numInscritos;
    }
    
    public int getNumAprovados() {
        return numAprovados;
    }
    
    public void setNumAprovados(int numAprovados) {
        if (numAprovados >= 0) {
            this.numAprovados = numAprovados;
        }
    }
    
    public Fase getStatus() {
        return status;
    }
    
    public void setStatus(Fase status) {
        if (status != null) {
            this.status = status;
        }
    }

    public Avaliacao getAvaliacao(){
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao){
        this.avaliacao = avaliacao;
    }
    
}
