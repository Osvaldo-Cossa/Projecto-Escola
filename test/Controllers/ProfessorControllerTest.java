/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ModelsBean.Professor;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Mr. Savagery
 */
public class ProfessorControllerTest {
    
    public ProfessorControllerTest() {
    }

    @Test
    public void insert() throws ClassNotFoundException, SQLException {
        
        Professor professor = new Professor("Mestrado", "Neide", "F");
        ProfessorController control = new ProfessorController();
        
        control.createTable();
        
        if (control.save(professor)){
            System.out.print("Salvo");
        }else{
            System.out.println("Erro");
        }
    }
    
    @Test
    @Ignore
    public void list () throws ClassNotFoundException, SQLException {
        
        ProfessorController control = new ProfessorController();
        
        for (Professor p: control.ListAll()){
            System.out.println(p.toString());
        }
    }
    
    @Test
    @Ignore
    public void updating () throws ClassNotFoundException, SQLException{
        
        Professor professor = new Professor("Mestrado", "Carlos", "M");
        ProfessorController control = new ProfessorController();
        
        professor.setCodigo(2);
        if (control.update(professor)){
            System.out.println("Actualizado");
        }else{
            System.out.println("Erro");
        }
    }
    
    @Test
    @Ignore
    public void deleting () throws ClassNotFoundException, SQLException{
        
        Professor professor = new Professor();
        ProfessorController control = new ProfessorController();
        professor.setCodigo(2);
        
        if (control.delete(professor)){
            System.out.println("Eliminado");
        }else{
            System.out.println("Erro");
        }
    }
}
