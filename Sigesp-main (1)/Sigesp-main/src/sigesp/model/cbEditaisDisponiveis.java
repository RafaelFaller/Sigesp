/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sigesp.model;

/**
 *
 * @author falle
 */
public class cbEditaisDisponiveis {
    private int id;
    private String Nome;

    public cbEditaisDisponiveis(int id, String Nome) {
        this.id = id;
        this.Nome = Nome;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
