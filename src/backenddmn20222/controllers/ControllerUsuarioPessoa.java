/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Usuario;
import backenddmn20222.models.beans.Pessoa;
import backenddmn20222.models.beans.UsuarioPessoa;
import backenddmn20222.models.daos.DaoUsuarioPessoa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lab04aluno
 */
public class ControllerUsuarioPessoa {
    
    ControllerUsuario contUsu;
    ControllerPessoa contPes;
    DaoUsuarioPessoa daoUsuPes;
    
    public UsuarioPessoa inserir(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();
        usupesEnt = daoUsuPes.inserir(usupesEnt);
        return usupesEnt;
    }

    public UsuarioPessoa alterar(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();
        usupesEnt = daoUsuPes.alterar(usupesEnt);
        return usupesEnt;
    }

    public List<UsuarioPessoa> listar(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();

        List<UsuarioPessoa> listaUsuPesAux = daoUsuPes.listar(usupesEnt);

        List<UsuarioPessoa> listaUsuPesRetorno = new ArrayList<>();
                
        for(UsuarioPessoa usupes : listaUsuPesAux) {        
            listaUsuPesRetorno.add(buscar(usupes));
        }

        return listaUsuPesRetorno;
    }

    public UsuarioPessoa excluir(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();
        usupesEnt = daoUsuPes.excluir(usupesEnt);
        return usupesEnt;
    }

    public UsuarioPessoa buscar(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {

        daoUsuPes = new DaoUsuarioPessoa();
        UsuarioPessoa usupesSaida = daoUsuPes.buscar(usupesEnt);

        Usuario usuEnt = new Usuario(usupesSaida.getIdUsuario());
        contUsu = new ControllerUsuario();
        usupesSaida.setUsu(contUsu.buscar(usuEnt));
        
        Pessoa pes = new Pessoa(usupesSaida.getIdPessoa());
        contPes = new ControllerPessoa();
        usupesSaida.setPes(contPes.buscar(pes));

        return usupesSaida;
    }


    
}
