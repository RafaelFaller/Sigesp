package sigesp.model;

// Classe que representa um Aluno, herdando da classe Vinculo
public class Aluno extends Vinculo { 
    // Atributos privados da classe Aluno
    private int matricula;
    private String curso;
    private int semestre;

    // Construtor padrão
    public Aluno() {
        super();
    }
    
    public Aluno(int matricula, String tipo){
        super(tipo);
        setMatricula(matricula);
    }

    // Construtor com parâmetros
    public Aluno(int matricula, String curso, int semestre, String tipo) {
        super(tipo); // Inicializa o tipo e o ID do vínculo
        this.setMatricula(matricula); // Verifica e define a matrícula
        this.setCurso(curso); // Verifica e define o curso
        this.setSemestre(semestre); // Verifica e define o semestre
    }

    // Getter para a matrícula do aluno
    public int getMatricula() {
        return matricula;
    }

    // Setter para a matrícula com verificação
    public void setMatricula(int matricula) {
        if (matricula <= 0) {
            throw new IllegalArgumentException("Matrícula deve ser maior que zero.");
        }
        this.matricula = matricula;
    }

    // Getter para o curso do aluno
    public String getCurso() {
        return curso;
    }

    // Setter para o curso com verificação
    public void setCurso(String curso) {
        if (curso == null || curso.isEmpty()) {
            throw new IllegalArgumentException("Curso não pode ser nulo ou vazio.");
        }
        this.curso = curso;
    }

    // Getter para o semestre do aluno
    public int getSemestre() {
        return semestre;
    }

    // Setter para o semestre com verificação
    public void setSemestre(int semestre) {
        if (semestre <= 0) {
            throw new IllegalArgumentException("Semestre deve ser maior que zero.");
        }
        this.semestre = semestre;
    }
}
