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
public class Estudante extends Pessoa {
    
    private int anoIngresso;
    
    public Estudante(){}

    public Estudante(int anoIngresso, String nome, String genero) {
        super(nome, genero);
        this.anoIngresso = anoIngresso;
    }
    

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    @Override
    public String toString() {
        return super.toString()+ " anoIngresso=" + anoIngresso ;
    }
}
