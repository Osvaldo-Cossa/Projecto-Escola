/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ModelsBean.Avaliacao;
import java.sql.SQLException;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mr. Savagery
 */
public class AvaliacaoControllerTest {
    
    public AvaliacaoControllerTest() {
    }

    @Test
    public void saver() throws ClassNotFoundException, SQLException {
        
        Avaliacao avaliacao = new Avaliacao("Teste 1", new Date(System.currentTimeMillis()).toString(), 1, 3);
        AvaliacaoController control = new AvaliacaoController();
        control.createTable();
        
        if(control.save(avaliacao)){
            System.out.println("Salvo");
        }else{
            System.out.println("Falha");
        }
    }
    
}
