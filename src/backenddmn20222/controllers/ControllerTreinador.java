/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Treinador;
import backenddmn20222.models.daos.DaoTreinador;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lab04aluno
 */
public class ControllerTreinador {
    
    static DaoTreinador daoTre;
    
    public Treinador inserir (Treinador treEnt) throws SQLException, ClassNotFoundException {
        daoTre = new DaoTreinador(); 
        return daoTre.inserir(treEnt);
    }
    public Treinador alterar (Treinador treEnt) throws SQLException, ClassNotFoundException {
        daoTre = new DaoTreinador(); 
        return daoTre.alterar(treEnt);
    }
    public List<Treinador> listar (Treinador treEnt) throws SQLException, ClassNotFoundException {
        daoTre = new DaoTreinador(); 
        return daoTre.listar(treEnt);
    }
    public Treinador excluir(Treinador treEnt) throws SQLException, ClassNotFoundException {
        daoTre = new DaoTreinador(); 
        return daoTre.excluir(treEnt);
    }

    public Treinador buscar(Treinador treEnt) throws SQLException, ClassNotFoundException {
        daoTre = new DaoTreinador(); 
        return daoTre.buscar(treEnt);
    }

    
}
