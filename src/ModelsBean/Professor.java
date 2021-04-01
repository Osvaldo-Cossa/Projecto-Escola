/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsBean;

/**
 *
 * @author Mr. Savagery
 */
public class Professor extends Pessoa {
    
    
    private String nivelAcademico;
    
    public Professor(){}

    public Professor(String nivelAcademico, String nome, String genero) {
        super(nome, genero);
        this.nivelAcademico = nivelAcademico;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    @Override
    public String toString() {
        return super.toString() + " nivelAcademico=" + nivelAcademico + "\n";
    }
}
