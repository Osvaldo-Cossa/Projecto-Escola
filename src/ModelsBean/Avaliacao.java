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
public class Avaliacao {
    
    
    private int codigo;
    private String nomeAvaliacao;
    private String data;
    private int codigoDisciplina;
    private String nomeDisciplina;
    private int codigoProfessor;
    private String nomeProfessor;
    
    public Avaliacao(){}

    public Avaliacao(String nomeAvaliacao, String data, int codigoDisciplina, int codigoProfessor) {
        this.nomeAvaliacao = nomeAvaliacao;
        this.data = data;
        this.codigoDisciplina = codigoDisciplina;
        this.codigoProfessor = codigoProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeAvaliacao() {
        return nomeAvaliacao;
    }

    public void setNomeAvaliacao(String nomeAvaliacao) {
        this.nomeAvaliacao = nomeAvaliacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        return "Avaliacao{" + "codigo=" + codigo + ", nomeAvaliacao=" + nomeAvaliacao + ", data=" + data + ", codigoDisciplina=" + codigoDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", codigoProfessor=" + codigoProfessor + ", nomeProfessor=" + nomeProfessor + '}';
    }
}
