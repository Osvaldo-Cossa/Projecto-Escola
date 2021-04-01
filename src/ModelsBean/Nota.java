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
public class Nota {
    
    private int codigo;
    private double nota;
    private String nomeEstudante;
    private int codigoDisciplina;
    private int codigoProfessor;
    
    public Nota(){}
    
    public Nota(double nota, String nomeEstudante, int codigoDisciplina, int codigoProfessor) {
        this.nota = nota;
        this.nomeEstudante = nomeEstudante;
        this.codigoDisciplina = codigoDisciplina;
        this.codigoProfessor = codigoProfessor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getNomeEstudante() {
        return nomeEstudante;
    }

    public void setNomeEstudante(String nomeEstudante) {
        this.nomeEstudante = nomeEstudante;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    @Override
    public String toString() {
        return "Nota{" + "nota=" + nota + ", nomeEstudante=" + nomeEstudante + ", codigoDisciplina=" + codigoDisciplina + ", codigoProfessor=" + codigoProfessor + '}';
    } 
}
