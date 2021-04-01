/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Connection.ConnectionFactory;
import ModelsBean.Estudante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Viewers.Dashboard;
/**
 *
 * @author Mr. Savagery
 */
public class EstudanteController {
    
    
    private Connection con = null;
    
    public EstudanteController() throws ClassNotFoundException, SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public boolean createTable() throws SQLException{
        
        String sql0 = "CREATE TABLE IF NOT EXISTS estudante(codigo int not null auto_increment, nome mediumtext, genero char,"
            + " anoIngresso year not null, primary key(codigo)) default charset = utf8";
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement(sql0);
            stat.executeUpdate();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(EstudanteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean save(Estudante estudante) throws SQLException{
        
        createTable();
        String sql ="INSERT INTO estudante (nome, genero, anoIngresso) VALUES (?,?,?)";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, estudante.getNome());
            stat.setString(2, estudante.getGenero());
            stat.setInt(3, estudante.getAnoIngresso());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
    
    public List <Estudante> showAll() throws SQLException{
        
        String sql = "SELECT * FROM estudante";
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Estudante> estudantes = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Estudante estu = new Estudante();
            estu.setCodigo(result.getInt("codigo"));
            estu.setNome(result.getString("nome"));
            estu.setGenero(result.getString("genero"));
            estu.setAnoIngresso(result.getInt("anoIngresso"));
            estudantes.add(estu);
        }
        return estudantes;
    }
    
    public List <Estudante> showSelected(int codigo) throws SQLException{
        
        String sql = "SELECT * FROM estudante where codigo ="+ codigo ;
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Estudante> estudantes = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Estudante estu = new Estudante();
            estu.setCodigo(result.getInt("codigo"));
            estu.setNome(result.getString("nome"));
            estu.setGenero(result.getString("genero"));
            estu.setAnoIngresso(result.getInt("anoIngresso"));
            estudantes.add(estu);
        }
        ConnectionFactory.closeConnection(con, stat, result);
        return estudantes;
    }
    
    public void closeConnection() throws SQLException{
        ConnectionFactory.closeConnection(con, con.prepareStatement("SELECT * FROM estudante"),
            con.prepareStatement("SELECT * FROM estudante").executeQuery());
    }
    
    public boolean update(Estudante estudante){
        
        String sql ="UPDATE estudante SET nome = ?, genero = ?, anoIngresso = ? WHERE codigo = ? limit 1";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, estudante.getNome());
            stat.setString(2, estudante.getGenero());
            stat.setInt(3, estudante.getAnoIngresso());
            stat.setInt(4, estudante.getCodigo());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
    
    public boolean delete(Estudante estudante){
        
        String sql = "DELETE FROM estudante WHERE codigo = ?";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setInt(1, estudante.getCodigo());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
}
