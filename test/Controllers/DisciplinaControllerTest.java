/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ModelsBean.Disciplina;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Mr. Savagery
 */
public class DisciplinaControllerTest {
    
    public DisciplinaControllerTest(){
    }

    @Test
    @Ignore
    public void saver() throws ClassNotFoundException, SQLException {
        
        Disciplina disciplina = new Disciplina("Frances",150000, 10, 2);
        DisciplinaController control = new DisciplinaController();
        control.createTable();
        
        if (control.save(disciplina)){
            System.out.println("Done");
        }else{
            System.out.println("Not Done");
        }
    }
    
    @Test
    @Ignore
    public void lister() throws ClassNotFoundException, SQLException{
        
        DisciplinaController control = new DisciplinaController();
        for(Disciplina d: control.ListAll()){
            System.out.println(d.toString());
        }
    }
    
    @Test
    public void selectedLister() throws ClassNotFoundException, SQLException{
        
        String concat = "";
        DisciplinaController control = new DisciplinaController();
        for(Disciplina d: control.ListSelected()){
            concat += "[1]Nome do Professor: "+ d.getNomeProfessor()+
            " [2]Disciplina: "+ d.getNomeDisciplina()+
            " [3]Nivel Academico: "+d.getNivelAcademico()+
            "\n";
        }
        System.out.println(concat);
    }
}
