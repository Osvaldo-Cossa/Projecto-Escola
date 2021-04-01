/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ModelsBean.Estudante;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/** 
 *
 * @author Mr. Savagery
 */
public class EstudanteControllerTest {
    
    public EstudanteControllerTest() {
    }

    @Test
    public void saving() throws ClassNotFoundException, SQLException {
        
        Estudante estudante = new Estudante(2018, "Eulalia", "F");
        EstudanteController control = new EstudanteController();
        
        control.createTable();
        
        if (control.save(estudante)){
            System.out.print("Salvo");
        }else{
            System.out.println("Erro");
        }
    }
    
}
