/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Connection.ConnectionFactory;
import ModelsBean.Professor;
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
public class ProfessorController {
    
    
    private Connection con = null;
    
    public ProfessorController() throws ClassNotFoundException, SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public boolean createTable() throws SQLException{
        
        String sql0 = "CREATE TABLE IF NOT EXISTS professor(codigo int not null auto_increment, nome mediumtext, genero char,"
            + " nivelAcademico mediumtext, primary key(codigo)) default charset = utf8";
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement(sql0);
            stat.executeUpdate();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(ProfessorController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean save(Professor professor) throws SQLException{
        
        createTable();
        String sql ="INSERT INTO professor (nome, genero, nivelAcademico) VALUES (?,?,?)";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, professor.getNome());
            stat.setString(2, professor.getGenero());
            stat.setString(3, professor.getNivelAcademico());
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
        
    public List <Professor> ListAll() throws SQLException{
        
        String sql = "SELECT * FROM professor";
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Professor> professores = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Professor prof = new Professor();
            prof.setCodigo(result.getInt("codigo"));
            prof.setNome(result.getString("nome"));
            prof.setGenero(result.getString("genero"));
            prof.setNivelAcademico(result.getString("nivelAcademico"));
            professores.add(prof);
        }
        return professores;
    }
    
    public List <Professor> ShowSelected(int codigo) throws SQLException{
        
        String sql = "SELECT * FROM professor where codigo ="+ codigo;
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Professor> professores = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Professor prof = new Professor();
            prof.setCodigo(result.getInt("codigo"));
            prof.setNome(result.getString("nome"));
            prof.setGenero(result.getString("genero"));
            prof.setNivelAcademico(result.getString("nivelAcademico"));
            professores.add(prof);
        }
        ConnectionFactory.closeConnection(con, stat, result);
        return professores;
    }
    
    public void closeConnection() throws SQLException{
        ConnectionFactory.closeConnection(con, con.prepareStatement("SELECT * FROM professor"),
            con.prepareStatement("SELECT * FROM professor").executeQuery());
    }
    
    public boolean update(Professor professor){
        
        String sql ="UPDATE professor SET nome = ?, genero = ?, nivelAcademico = ? WHERE codigo = ? limit 1";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, professor.getNome());
            stat.setString(2, professor.getGenero());
            stat.setString(3, professor.getNivelAcademico());
            stat.setInt(4, professor.getCodigo());
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
    
    public boolean delete(int codigo){
        
        String sql ="DELETE FROM professor WHERE codigo = ?";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setInt(1, codigo);
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
