package sigesp.model;

// Classe que representa um Professor, herdando da classe Vinculo
import java.util.List; 

public class Professor extends Vinculo {
    // Atributos privados da classe Professor
    private String siape;
    private List<String> cursos;
    private List<Projeto> projetos;

    // Construtor padrão
    public Professor() {
        super();
    }
    
    public Professor(String siape, String tipo){
        super(tipo);
        setSiape(siape);
    }

    // Construtor com parâmetros
    public Professor(String siape, List<String> cursos, List<Projeto> projetos, String tipo) {
        super(tipo); // Inicializa o tipo e o ID do vínculo
        this.setSiape(siape); // Verifica e define o SIAPE
        this.setCursos(cursos); // Verifica e define a lista de cursos
        this.setProjetos(projetos); // Verifica e define a lista de projetos
    }

    // Getter para o SIAPE do professor
    public String getSiape() {
        return siape;
    }

    // Setter para o SIAPE com verificação
    public void setSiape(String siape) {
        if (siape == null || siape.isEmpty()) {
            throw new IllegalArgumentException("SIAPE não pode ser nulo ou vazio.");
        }
        this.siape = siape;
    }

    // Getter para a lista de cursos
    public List<String> getCursos() {
        return cursos;
    }

    // Setter para a lista de cursos com verificação
    public void setCursos(List<String> cursos) {
        if (cursos == null || cursos.isEmpty()) {
            throw new IllegalArgumentException("A lista de cursos não pode ser nula ou vazia.");
        }
        this.cursos = cursos;
    }

    // Getter para a lista de projetos
    public List<Projeto> getProjetos() {
        return projetos;
    }

    // Setter para a lista de projetos com verificação
    public void setProjetos(List<Projeto> projetos) {
        if (projetos == null) {
            throw new IllegalArgumentException("A lista de projetos não pode ser nula.");
        }
        this.projetos = projetos;
    }
}
