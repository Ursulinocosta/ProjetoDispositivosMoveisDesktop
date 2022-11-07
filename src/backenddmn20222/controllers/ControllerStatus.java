/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Status;
import backenddmn20222.models.daos.DaoStatus;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lab04aluno
 */
public class ControllerStatus {
    
    static DaoStatus daoSta;
    
    public Status inserir (Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.inserir(staEnt);
    }
    public Status alterar (Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.alterar(staEnt);
    }
    public List<Status> listar (Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.listar(staEnt);
    }
    public Status excluir(Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.excluir(staEnt);
    }

    public Status buscar(Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.buscar(staEnt);
    }

    
}
