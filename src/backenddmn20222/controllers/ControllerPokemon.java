
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Pokemon;
import backenddmn20222.models.daos.DaoPokemon;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lab04aluno
 */
public class ControllerPokemon {
    
    static DaoPokemon daoPok;
    
    public Pokemon inserir (Pokemon pokEnt) throws SQLException, ClassNotFoundException {
        daoPok = new DaoPokemon(); 
        return daoPok.inserir(pokEnt);
    }
    public Pokemon alterar (Pokemon pokEnt) throws SQLException, ClassNotFoundException {
        daoPok = new DaoPokemon(); 
        return daoPok.alterar(pokEnt);
    }
    public List<Pokemon> listar (Pokemon pokEnt) throws SQLException, ClassNotFoundException {
        daoPok = new DaoPokemon(); 
        return daoPok.listar(pokEnt);
    }
    public Pokemon excluir(Pokemon pokEnt) throws SQLException, ClassNotFoundException {
        daoPok = new DaoPokemon(); 
        return daoPok.excluir(pokEnt);
    }

    public Pokemon buscar(Pokemon pokEnt) throws SQLException, ClassNotFoundException {
        daoPok = new DaoPokemon(); 
        return daoPok.buscar(pokEnt);
    }

    
}
