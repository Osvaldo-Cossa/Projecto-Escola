/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Connection.ConnectionFactory;
import ModelsBean.Avaliacao;
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
public class AvaliacaoController {
    
    
    private Connection con = null;
    
    public AvaliacaoController() throws ClassNotFoundException, SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public boolean createTable() throws SQLException{
        
        String sql0 = "CREATE TABLE IF NOT EXISTS avaliacao (codigo int not null auto_increment,"
            + " nomeAvaliacao mediumtext not null, data mediumtext not null,"
            + " codigoDisciplina int not null, codigoProfessor int not null,"
            + " primary key(codigo), foreign key (codigoDisciplina) references disciplina(codigo),"
            + " foreign key(codigoProfessor) references professor(codigo)) default charset = utf8";
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement(sql0);
            stat.executeUpdate();
            return true;
        } catch(SQLException ex){
            Logger.getLogger(AvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean save(Avaliacao avaliacao) throws SQLException{
        
        String sql ="INSERT INTO avaliacao (nomeAvaliacao, data,"
                + " codigoDisciplina, codigoProfessor) VALUES (?,?,?,?)";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, avaliacao.getNomeAvaliacao());
            stat.setString(2, avaliacao.getData());
            stat.setInt(3, avaliacao.getCodigoDisciplina());
            stat.setInt(4, avaliacao.getCodigoProfessor());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
    
    public List <Avaliacao> ListAll() throws SQLException{
        
        String sql = "SELECT * FROM avaliacao";
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Avaliacao> avaliacoes = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Avaliacao aval = new Avaliacao();
            aval.setCodigo(result.getInt("codigo"));
            aval.setNomeAvaliacao(result.getString("nomeAvaliacao"));
            aval.setData(result.getString("data"));
            aval.setCodigoDisciplina(result.getInt("codigoDisciplina"));
            aval.setCodigoProfessor(result.getInt("codigoProfessor"));
            avaliacoes.add(aval);
        }

        ConnectionFactory.closeConnection(con, stat, result);
        return avaliacoes;
    }
    
    public List <Avaliacao> ListTable() throws SQLException{
        
        String sql = "select nomeAvaliacao, data, p.nome, d.nomeDisciplina"
            + " from avaliacao a join professor p on p.codigo = a.codigoProfessor"
                + " join disciplina d on d.codigo = a.codigoDisciplina";      
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Avaliacao> avaliacoes = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();
        
        while(result.next()){
            Avaliacao aval = new Avaliacao();
            aval.setNomeAvaliacao(result.getString("nomeAvaliacao"));
            aval.setData(result.getString("data"));
            aval.setNomeProfessor(result.getString("p.nome"));
            aval.setNomeDisciplina(result.getString("d.nomeDisciplina"));
            avaliacoes.add(aval);
        }
        return avaliacoes;
    }
    
    public List <Avaliacao> ListTable(int codigo) throws SQLException{
        
        String sql = "select nomeAvaliacao, data, p.nome, d.nomeDisciplina"
            + " from avaliacao a join professor p on p.codigo = a.codigoProfessor"
            + " join disciplina d on d.codigo = a.codigoDisciplina where a.codigoProfessor = "+codigo;      
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Avaliacao> avaliacoes = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();
        
        while(result.next()){
            Avaliacao aval = new Avaliacao();
            aval.setNomeAvaliacao(result.getString("nomeAvaliacao"));
            aval.setData(result.getString("data"));
            aval.setNomeProfessor(result.getString("p.nome"));
            aval.setNomeDisciplina(result.getString("d.nomeDisciplina"));
            avaliacoes.add(aval);
        }
        return avaliacoes;
    }
    
    /*public void closeConnection() throws SQLException{
        ConnectionFactory.closeConnection(con, con.prepareStatement("select nomeAvaliacao, data, p.nome, d.nomeDisciplina"
            + " from avaliacao a join professor e on p.codigo = a.codigoProfessor"
                + " join disciplina d on d.codigo = a.codigoDisciplina;"),
            con.prepareStatement("select nomeAvaliacao, data, p.nome, d.nomeDisciplina"
            + " from avaliacao a join professor e on p.codigo = a.codigoProfessor"
                + " join disciplina d on d.codigo = a.codigoDisciplina").executeQuery());
    }*/
    
    /*public boolean update(Avaliacao avaliacao){
        
        String sql ="UPDATE avaliacao SET nomeAvaliacao = ?, nota = ?,"
            + "WHERE codigo = ? limit 1";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, avaliacao.getNomeAvaliacao());
            stat.setDouble(2, avaliacao.getNota());
            stat.setInt(3, avaliacao.getCodigo());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }*/
    
    public boolean delete(Avaliacao avaliacao){
        
        String sql ="DELETE FROM avaliacao WHERE codigo = ?";       
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement(sql);
            stat.setInt(1, avaliacao.getCodigo());
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(con, stat);
            } catch (SQLException ex) {
            }
        }
    }
    
    public List <Avaliacao> ListAll(int codigoProfessor) throws SQLException{
        
        String sql = "SELECT * FROM avaliacao where codigoProfessor = "+codigoProfessor;
        PreparedStatement stat = null;
        ResultSet result = null;
        List <Avaliacao> avaliacoes = new ArrayList<>();
        
        stat = con.prepareStatement(sql);
        result = stat.executeQuery();

        while(result.next()){
            Avaliacao aval = new Avaliacao();
            aval.setCodigo(result.getInt("codigo"));
            aval.setNomeAvaliacao(result.getString("nomeAvaliacao"));
            aval.setData(result.getString("data"));
            aval.setCodigoDisciplina(result.getInt("codigoDisciplina"));
            aval.setCodigoProfessor(result.getInt("codigoProfessor"));
            avaliacoes.add(aval);
        }
        return avaliacoes;
    }
}
