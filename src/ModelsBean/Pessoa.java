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
public abstract class Pessoa {
    
    
    private String nome;
    private String genero;
    private int codigo;
    
    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pessoa(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  "nome: " + nome + ", genero: " + genero + ", codigo: " + codigo;
    }
}
