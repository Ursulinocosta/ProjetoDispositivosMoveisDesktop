/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.Pokemon;
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
public class DaoPokemon {
    
    private final Connection c;

    public DaoPokemon() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConexaoMySQL();
    }
     
    public Pokemon inserir(Pokemon pokEnt) throws SQLException{
        String sql = "insert into pokemon" + " (nome, tipo)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,pokEnt.getNome());
        stmt.setString(2,pokEnt.getTipo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pokEnt.setId(id);
        }
        stmt.close();
        return pokEnt;
    }
    
    public Pokemon alterar(Pokemon pokEnt) throws SQLException{
        String sql = "UPDATE pokemon SET nome = ?, tipo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,pokEnt.getNome());
        stmt.setString(2,pokEnt.getTipo());
        stmt.setInt(3,pokEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pokEnt;
    }

    public Pokemon excluir(Pokemon pokEnt) throws SQLException{
        String sql = "delete from pokemon WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pokEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pokEnt;
    }
    
    public Pokemon buscar(Pokemon pokEnt) throws SQLException{
        String sql = "select * from pokemon WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pokEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Pokemon pokSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                pokSaida = new Pokemon(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pokSaida;
   }

   public List<Pokemon> listar(Pokemon pokEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Pokemon> poke = new ArrayList<>();
        
        String sql = "select * from pokemon where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pokEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Pokemon pok = new Pokemon(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3));
            // adiciona o usu à lista de usus
            poke.add(pok);
        }
        
        rs.close();
        stmt.close();
        return poke;
   
   }
    
}

