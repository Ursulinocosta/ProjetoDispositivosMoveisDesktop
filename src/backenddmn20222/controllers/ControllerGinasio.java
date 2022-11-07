/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Ginasio;
import backenddmn20222.models.daos.DaoGinasio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lab04aluno
 */
public class ControllerGinasio {
    
    static DaoGinasio daoGin;
    
    public Ginasio inserir (Ginasio ginEnt) throws SQLException, ClassNotFoundException {
        daoGin = new DaoGinasio(); 
        return daoGin.inserir(ginEnt);
    }
    public Ginasio alterar (Ginasio ginEnt) throws SQLException, ClassNotFoundException {
        daoGin = new DaoGinasio(); 
        return daoGin.alterar(ginEnt);
    }
    public List<Ginasio> listar (Ginasio ginEnt) throws SQLException, ClassNotFoundException {
        daoGin = new DaoGinasio(); 
        return daoGin.listar(ginEnt);
    }
    public Ginasio excluir(Ginasio ginEnt) throws SQLException, ClassNotFoundException {
        daoGin = new DaoGinasio(); 
        return daoGin.excluir(ginEnt);
    }

    public Ginasio buscar(Ginasio ginEnt) throws SQLException, ClassNotFoundException {
        daoGin = new DaoGinasio(); 
        return daoGin.buscar(ginEnt);
    }

    
}
