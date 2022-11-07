/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.Treinador;
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
public class DaoTreinador {
    
    private final Connection c;

    public DaoTreinador() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConexaoMySQL();
    }
     
    public Treinador inserir(Treinador treEnt) throws SQLException{
        String sql = "insert into treinadores" + " (nome, cpf)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,treEnt.getNome());
        stmt.setString(2,treEnt.getCpf());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            treEnt.setId(id);
        }
        stmt.close();
        return treEnt;
    }
    
    public Treinador alterar(Treinador treEnt) throws SQLException{
        String sql = "UPDATE treinadores SET nome = ?, cpf = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,treEnt.getNome());
        stmt.setString(2,treEnt.getCpf());
        stmt.setInt(3,treEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return treEnt;
    }

    public Treinador excluir(Treinador treEnt) throws SQLException{
        String sql = "delete from Treinadores WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,treEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return treEnt;
    }
    
    public Treinador buscar(Treinador treEnt) throws SQLException{
        String sql = "select * from treinadores WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,treEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Treinador treSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                treSaida = new Treinador(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return treSaida;
   }

   public List<Treinador> listar(Treinador treEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Treinador> trei = new ArrayList<>();
        
        String sql = "select * from treinadores where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + treEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Treinador tre = new Treinador(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3));
            // adiciona o usu à lista de usus
            trei.add(tre);
        }
        
        rs.close();
        stmt.close();
        return trei;
   
   }
    
}

