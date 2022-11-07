/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerTreinadorPokemon;
import backenddmn20222.models.beans.TreinadorPokemon;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lab04aluno
 */
public class ManterTreinadorPokemon{
    
        public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    
    public static void inserir() throws SQLException, ClassNotFoundException {
        int idTreinador = Integer.parseInt(JOptionPane.showInputDialog("IDTREINADOR"));
        int idPokemon = Integer.parseInt(JOptionPane.showInputDialog("IDPOKEMON"));
        String obs = JOptionPane.showInputDialog("OBS");
        TreinadorPokemon trepokEnt = new TreinadorPokemon(idTreinador, idPokemon, obs);
        ControllerTreinadorPokemon contTrePok = new ControllerTreinadorPokemon();
        TreinadorPokemon trepokSaida = contTrePok.inserir(trepokEnt);
        JOptionPane.showMessageDialog(null, trepokSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idTreinador = Integer.parseInt(JOptionPane.showInputDialog("IDTREINADOR"));
        int idPokemon = Integer.parseInt(JOptionPane.showInputDialog("IDPOKEMON"));
        String obs = JOptionPane.showInputDialog("OBS");
        TreinadorPokemon trepokEnt = new TreinadorPokemon(id,idTreinador, idPokemon, obs);
        ControllerTreinadorPokemon contTrePok = new ControllerTreinadorPokemon();
        TreinadorPokemon trepokSaida = contTrePok.alterar(trepokEnt);
        JOptionPane.showMessageDialog(null, trepokSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        TreinadorPokemon trepokEnt = new TreinadorPokemon(id);
        ControllerTreinadorPokemon contTrePok = new ControllerTreinadorPokemon();
        TreinadorPokemon trepokSaida = contTrePok.buscar(trepokEnt);
        JOptionPane.showMessageDialog(null, trepokSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        TreinadorPokemon trepokEnt = new TreinadorPokemon(id);
        ControllerTreinadorPokemon contTrePOk = new ControllerTreinadorPokemon();
        TreinadorPokemon trepokSaida = contTrePOk.excluir(trepokEnt);
        JOptionPane.showMessageDialog(null, trepokSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        TreinadorPokemon trepokEnt = new TreinadorPokemon(obs);
        ControllerTreinadorPokemon contTrePok = new ControllerTreinadorPokemon();
        List<TreinadorPokemon> listaTreinadorPokemon = contTrePok.listar(trepokEnt);
        for(TreinadorPokemon trePok: listaTreinadorPokemon) {
            JOptionPane.showMessageDialog(null, trePok.toString());
            JOptionPane.showMessageDialog(null, trePok.getPok().toString());
            JOptionPane.showMessageDialog(null, trePok.getTre().toString());
        }
    }
    
}
