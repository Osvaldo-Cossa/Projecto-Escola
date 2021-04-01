/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsBean;


public class Disciplina {
    
    
    private int codigo;
    private String nomeDisciplina;
    private int horasPorSemana;
    private int creditos;
    private int codigoProfessor;
    private String nomeProfessor;
    private String nivelAcademico;
    
    public Disciplina(){}

    public Disciplina(String nomeDisciplina, int horasPorSemana, int creditos, int codigoProfessor) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasPorSemana = horasPorSemana;
        this.creditos = creditos;
        this.codigoProfessor = codigoProfessor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getHorasPorSemana() {
        return horasPorSemana;
    }

    public void setHorasPorSemana(int horasPorSemana) {
        this.horasPorSemana = horasPorSemana;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }
    
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    @Override
    public String toString() {
        return  "codigo=" + codigo + ", nomeDisciplina=" + nomeDisciplina + 
                ", horasPorSemana=" + horasPorSemana + ", creditos=" + creditos + ", codigoProfessor=" + codigoProfessor;
    }    
}
