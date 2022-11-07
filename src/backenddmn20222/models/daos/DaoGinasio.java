/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.Ginasio;
import backenddmn20222.utils.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lab04aluno
 */
public class DaoGinasio {
    
    private final Connection c;

    public DaoGinasio() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConexaoMySQL();
    }
     
    public Ginasio inserir(Ginasio ginEnt) throws SQLException{
        String sql = "insert into ginasio" + " (estado, pais)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,ginEnt.getEstado());
        stmt.setString(2,ginEnt.getPais());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            ginEnt.setId(id);
        }
        stmt.close();
        return ginEnt;
    }
    
    public Ginasio alterar(Ginasio ginEnt) throws SQLException{
        String sql = "UPDATE ginasio SET estado = ?, pais = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,ginEnt.getEstado());
        stmt.setString(2,ginEnt.getPais());
        stmt.setInt(3,ginEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return ginEnt;
    }

    public Ginasio excluir(Ginasio ginEnt) throws SQLException{
        String sql = "delete from ginasio WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,ginEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return ginEnt;
    }
    
    public Ginasio buscar(Ginasio ginEnt) throws SQLException{
        String sql = "select * from ginasio WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,ginEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Ginasio ginSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                ginSaida = new Ginasio(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return ginSaida;
   }

   public List<Ginasio> listar(Ginasio ginEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Ginasio> gina = new ArrayList<>();
        
        String sql = "select * from ginasio where estado like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + ginEnt.getEstado() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Ginasio gin = new Ginasio(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3));
            // adiciona o usu à lista de usus
            gina.add(gin);
        }
        
        rs.close();
        stmt.close();
        return gina;
   
   }
    
}

