/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Treinador;
import backenddmn20222.models.beans.Pokemon;
import backenddmn20222.models.beans.TreinadorPokemon;
import backenddmn20222.models.daos.DaoTreinadorPokemon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lab04aluno
 */
public class ControllerTreinadorPokemon {
    
    ControllerTreinador contTre;
    ControllerPokemon contPok;
    DaoTreinadorPokemon daoTrepok;
    
    public TreinadorPokemon inserir(TreinadorPokemon trepokEnt) throws SQLException, ClassNotFoundException {
        daoTrepok = new DaoTreinadorPokemon();
        trepokEnt = daoTrepok.inserir(trepokEnt);
        return trepokEnt;
    }

    public TreinadorPokemon alterar(TreinadorPokemon trepokEnt) throws SQLException, ClassNotFoundException {
        daoTrepok = new DaoTreinadorPokemon();
        trepokEnt = daoTrepok.alterar(trepokEnt);
        return trepokEnt;
    }

    public List<TreinadorPokemon> listar(TreinadorPokemon trepokEnt) throws SQLException, ClassNotFoundException {
        daoTrepok = new DaoTreinadorPokemon();

        List<TreinadorPokemon> listaTrePokAux = daoTrepok.listar(trepokEnt);

        List<TreinadorPokemon> listaTrePokRetorno = new ArrayList<>();
                
        for(TreinadorPokemon trepok : listaTrePokAux) {        
            listaTrePokRetorno.add(buscar(trepok));
        }

        return listaTrePokRetorno;
    }

    public TreinadorPokemon excluir(TreinadorPokemon trepokEnt) throws SQLException, ClassNotFoundException {
        daoTrepok = new DaoTreinadorPokemon();
        trepokEnt = daoTrepok.excluir(trepokEnt);
        return trepokEnt;
    }

    public TreinadorPokemon buscar(TreinadorPokemon usupesEnt) throws SQLException, ClassNotFoundException {

        daoTrepok = new DaoTreinadorPokemon();
        TreinadorPokemon trepokSaida = daoTrepok.buscar(usupesEnt);

        Treinador treEnt = new Treinador(trepokSaida.getIdTreinador());
        contTre = new ControllerTreinador();
        trepokSaida.setTre(contTre.buscar(treEnt));
        
        Pokemon pok = new Pokemon(trepokSaida.getIdPokemon());
        contPok = new ControllerPokemon();
        trepokSaida.setPok(contPok.buscar(pok));

        return trepokSaida;
    }


    
}
