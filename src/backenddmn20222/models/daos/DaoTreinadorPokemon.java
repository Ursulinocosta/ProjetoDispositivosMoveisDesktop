/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.TreinadorPokemon;
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
public class DaoTreinadorPokemon {
    
    private final Connection c;
    
    public DaoTreinadorPokemon() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }


    public TreinadorPokemon excluir(TreinadorPokemon trepokEnt) throws SQLException{
        String sql = "delete from treinador_pokemon WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,trepokEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return trepokEnt;
    }
    
    public TreinadorPokemon buscar(TreinadorPokemon trepokEnt) throws SQLException{
        String sql = "select * from treinador_pokemon WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,trepokEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            TreinadorPokemon trepokSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                trepokSaida = new TreinadorPokemon(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return trepokSaida;
   }

    public TreinadorPokemon inserir(TreinadorPokemon trepokEnt) throws SQLException{
        String sql = "insert into treinador_pokemon " + " (idPokemon, idTreinador, obs)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,trepokEnt.getIdPokemon());
        stmt.setInt(2,trepokEnt.getIdTreinador());
        stmt.setString(3,trepokEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            trepokEnt.setId(id);
        }
        stmt.close();
        return trepokEnt;
    }

    public TreinadorPokemon alterar(TreinadorPokemon trepokEnt) throws SQLException{
        String sql = "UPDATE treinador_pokemon SET idPokemon = ?, idTreinador = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,trepokEnt.getIdPokemon());
        stmt.setInt(2,trepokEnt.getIdTreinador());
        stmt.setString(3,trepokEnt.getObs());
        stmt.setInt(4,trepokEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return trepokEnt;
    }

   public List<TreinadorPokemon> listar(TreinadorPokemon trepokEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<TreinadorPokemon> trepokk = new ArrayList<>();
        
        String sql = "select * from treinador_pokemon where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + trepokEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            TreinadorPokemon trepok = new TreinadorPokemon(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            trepokk.add(trepok);
        }
        
        rs.close();
        stmt.close();
        return trepokk;
   
   }

    
}
