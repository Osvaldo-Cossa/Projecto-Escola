/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Connection.ConnectionFactory;
import ModelsBean.Disciplina;
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
public class DisciplinaController {
    
    
    private Connection con = null;
    
    public DisciplinaController() throws ClassNotFoundException, SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public boolean createTable() throws SQLException{
        
        String sql0 = "CREATE TABLE IF NOT EXISTS disciplina (codigo int not null auto_increment,"
            + " nomeDisciplina mediumtext, horasPorSemana time, creditos int,"
            + " codigoProfessor int, primary key(codigo), foreign key (codigoProfessor)"
            + " references professor (codigo)) default charset = utf8";
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement(sql0);
            stat.executeUpdate();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(DisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean save(Disciplina disciplina) throws SQLException{
        
        createTable();
        String sql ="INSERT INTO disciplina (nomeDisciplina, horasPorSemana, creditos, codigoProfessor) VALUES (?,?,?,?)";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, disciplina.getNomeDisciplina());
            stat.setInt(2, disciplina.getHorasPorSemana());
            stat.setInt(3, disciplina.getCreditos());
            stat.setInt(4, disciplina.getCodigoProfessor());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
    
    public List <Disciplina> ListAll() throws SQLException{
        
        String sql = "SELECT * FROM disciplina";
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Disciplina> disciplinas = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Disciplina disc = new Disciplina();
            disc.setCodigo(result.getInt("codigo"));
            disc.setNomeDisciplina(result.getString("nomeDisciplina"));
            disc.setHorasPorSemana(result.getInt("horasPorSemana"));
            disc.setCreditos(result.getInt("creditos"));
            disc.setCodigoProfessor(result.getInt("codigoProfessor"));
            disciplinas.add(disc);
        }

        ConnectionFactory.closeConnection(con, stat, result);
        return disciplinas;
    }
    
    public List <Disciplina> showSelected(int codigo) throws SQLException{
        
        String sql = "SELECT * FROM disciplina where codigo ="+ codigo;
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Disciplina> disciplinas = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Disciplina disc = new Disciplina();
            disc.setCodigo(result.getInt("codigo"));
            disc.setNomeDisciplina(result.getString("nomeDisciplina"));
            disc.setHorasPorSemana(result.getInt("horasPorSemana"));
            disc.setCreditos(result.getInt("creditos"));
            disc.setCodigoProfessor(result.getInt("codigoProfessor"));
            disciplinas.add(disc);
        }

        ConnectionFactory.closeConnection(con, stat, result);
        return disciplinas;
    }
    
    public List <Disciplina> ListSelected() throws SQLException{
        
        String sql = "Select disciplina.nomeDisciplina, professor.nome, professor.nivelAcademico"
            + " from disciplina join professor on disciplina.codigoProfessor = professor.codigo";
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Disciplina> disciplinas  = new ArrayList();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();
        
        while (result.next()){
            Disciplina disc = new Disciplina();
            disc.setNomeDisciplina(result.getString("nomeDisciplina"));
            disc.setNomeProfessor(result.getString("nome"));
            disc.setNivelAcademico(result.getString("nivelAcademico"));
            disciplinas.add(disc);
        }
        
        ConnectionFactory.closeConnection(con, stat, result);
        return disciplinas;
    }
    
    public List <Disciplina> ListTable() throws SQLException{
        
        String sql = "Select disciplina.codigo, disciplina.nomeDisciplina, disciplina.horasPorSemana,"
                + "disciplina.creditos, professor.codigo, professor.nome"
            + " from disciplina join professor on disciplina.codigoProfessor = professor.codigo";
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Disciplina> disciplinas  = new ArrayList();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();
        
        while (result.next()){
            Disciplina disc = new Disciplina();
            disc.setCodigo(result.getInt("codigo"));
            disc.setNomeDisciplina(result.getString("nomeDisciplina"));
            disc.setHorasPorSemana(result.getInt("horasPorSemana"));
            disc.setCreditos(result.getInt("creditos"));
            disc.setCodigoProfessor(result.getInt("professor.codigo"));
            disc.setNomeProfessor(result.getString("nome"));
            disciplinas.add(disc);
        }
        return disciplinas;
    }
    
    public void closeConnection() throws SQLException{
        ConnectionFactory.closeConnection(con, con.prepareStatement("Select disciplina.codigo, disciplina.nomeDisciplina,"
                + " disciplina.horasPorSemana,"
                + "disciplina.creditos, professor.codigo, professor.nome"
            + " from disciplina join professor on disciplina.codigoProfessor = professor.codigo"),
            con.prepareStatement("Select disciplina.codigo, disciplina.nomeDisciplina, disciplina.horasPorSemana,"
                + "disciplina.creditos, professor.codigo, professor.nome"
            + " from disciplina join professor on disciplina.codigoProfessor = professor.codigo").executeQuery());
    }
    
    public boolean update(Disciplina disciplina){
        
        String sql ="UPDATE disciplina SET nomeDisciplina = ?, horasPorSemana = ?, creditos = ?, "
            + "codigoProfessor = ? WHERE codigo = ? limit 1";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, disciplina.getNomeDisciplina());
            stat.setInt(2, disciplina.getHorasPorSemana());
            stat.setInt(3, disciplina.getCreditos());
            stat.setInt(4, disciplina.getCodigoProfessor());
            stat.setInt(5, disciplina.getCodigo());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
    
    public boolean delete(Disciplina disciplina){
        
        String sql ="DELETE FROM disciplina WHERE codigo = ?";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setInt(1, disciplina.getCodigo());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
    
    public int codigoDisciplina(int codigoProfessor) throws SQLException{
        
        String sql  = "Select codigo from disciplina where codigoProfessor = "+codigoProfessor;
        
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Disciplina> disciplinas  = new ArrayList();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();
        
        while (result.next()){
            Disciplina disc = new Disciplina();
            disc.setCodigo(result.getInt("codigo"));
            disciplinas.add(disc);
        }   
        //ConnectionFactory.closeConnection(con, stat, result);
        return disciplinas.get(0).getCodigo();
    }
}
