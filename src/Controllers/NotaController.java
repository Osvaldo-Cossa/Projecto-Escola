/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Connection.ConnectionFactory;
import ModelsBean.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr. Savagery
 */
public class NotaController {
    
    
    private Connection con = null;
    
    public NotaController() throws ClassNotFoundException, SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public boolean createTable() throws SQLException{
        
        String sql0 = "CREATE TABLE IF NOT EXISTS nota (codigo int not null auto_increment,"
            + " nota double not null, nomeEstudante mediumtext not null, codigoDisciplina int not null,"
            + " codigoProfessor int not null, primary key(codigo), foreign key (codigoDisciplina) references disciplina(codigo),"
            + " foreign key (codigoProfessor) references professor(codigo)) default charset = utf8";
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement(sql0);
            stat.executeUpdate();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(NotaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean save(Nota nota) throws SQLException{
        
        String sql ="INSERT INTO nota (nota, nomeEstudante, codigoDisciplina, codigoProfessor) VALUES (?,?,?,?)";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setDouble(1, nota.getNota());
            stat.setString(2, nota.getNomeEstudante());
            stat.setInt(3, nota.getCodigoDisciplina());
            stat.setInt(4, nota.getCodigoProfessor());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NotaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
    
    public List <Nota> ListAll() throws SQLException{
        
        String sql = "SELECT * FROM nota";
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Nota> nota = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Nota grade = new Nota();
            grade.setCodigo(result.getInt("codigo"));
            grade.setNota(result.getDouble("nota"));
            grade.setNomeEstudante(result.getString("nomeEstudante"));
            grade.setCodigoDisciplina(result.getInt("codigoDisciplina"));
            grade.setCodigoProfessor(result.getInt("codigoProfessor"));
            nota.add(grade);
        }

        ConnectionFactory.closeConnection(con, stat, result);
        return nota;
    }
    
    public List <Nota> ListAll(int codigoProfessor) throws SQLException{
        
        String sql = "SELECT * FROM nota where codigoProfessor = "+ codigoProfessor;
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Nota> nota = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Nota grade = new Nota();
            grade.setCodigo(result.getInt("codigo"));
            grade.setNota(result.getDouble("nota"));
            grade.setNomeEstudante(result.getString("nomeEstudante"));
            grade.setCodigoDisciplina(result.getInt("codigoDisciplina"));
            grade.setCodigoProfessor(result.getInt("codigoProfessor"));
            nota.add(grade);
        }

        //ConnectionFactory.closeConnection(con, stat, result);
        return nota;
    }
    
}
