/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.Usuario;
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
public class DaoUsuario {
    
    private final Connection c;
    
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Usuario validar(Usuario usuEnt) throws SQLException {
        // cria o select para ser executado no banco de dados 
        String sql = "select * from usuarios WHERE login = ? AND senha = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        Usuario usuSaida = null;
        while (rs.next()) {      
            // criando o objeto Usuario
            usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        return usuSaida; 
    }

    public Usuario excluir(Usuario usuEnt) throws SQLException{
        String sql = "delete from usuarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usuEnt;
    }
    
    public Usuario buscar(Usuario usuEnt) throws SQLException{
        String sql = "select * from usuarios WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usuEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Usuario usuSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usuSaida;
   }

    public Usuario inserir(Usuario usuEnt) throws SQLException{
        String sql = "insert into usuarios" + " (login, senha, status, tipo)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        stmt.setString(3,usuEnt.getStatus());
        stmt.setString(4,usuEnt.getTipo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usuEnt.setId(id);
        }
        stmt.close();
        return usuEnt;
    }

    public Usuario alterar(Usuario usuEnt) throws SQLException{
        String sql = "UPDATE usuarios SET login = ?, senha = ?, status = ?, tipo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        stmt.setString(3,usuEnt.getStatus());
        stmt.setString(4,usuEnt.getTipo());
        stmt.setInt(5,usuEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return usuEnt;
    }

   public List<Usuario> listar(Usuario usuEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Usuario> usus = new ArrayList<>();
        
        String sql = "select * from usuarios where login like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usuEnt.getLogin() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
   
   }

    
}
