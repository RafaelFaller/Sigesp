package sigesp.model;

import java.util.List;
import java.time.LocalDate;
public class SelecaoPessoas extends ProcessoSeletivo {
    private List<Aluno> alunosInscritos;
    private List<Aluno> aprovados;

    public SelecaoPessoas(
            String nome, 
            String descricao, 
            int numVagas, 
            LocalDate iniInscricoes, 
            LocalDate fimInscricoes, 
            List<String> banca, 
            Fase status
        ) {
        
        super(
            nome, 
            descricao, 
            numVagas, 
            iniInscricoes, 
            fimInscricoes, 
            banca, 
            status
        );
    }

    public List<Aluno> getAlunosInscritos() {
        return alunosInscritos;
    }

    public void setAlunosInscritos(List<Aluno> alunosInscritos) {
        this.alunosInscritos = alunosInscritos;
    }

    public List<Aluno> getAprovados() {
        return aprovados;
    }

    public void setAprovados(List<Aluno> aprovados) {
        this.aprovados = aprovados;
    }
}