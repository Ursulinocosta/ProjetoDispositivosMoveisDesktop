/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerPokemon;
import backenddmn20222.models.beans.Pokemon;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lab04aluno
 */
public class ManterPokemon {
    
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
                System.out.println("Opcao inválido");
        }
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Pokemon pokEnt = new Pokemon(nome,tipo);
        ControllerPokemon contPokemon = new ControllerPokemon();
        Pokemon pokSaida = contPokemon.inserir(pokEnt);
        JOptionPane.showMessageDialog(null,pokSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Pokemon pokEnt = new Pokemon(id,nome,tipo);
        ControllerPokemon contPokemon = new ControllerPokemon();
        Pokemon pokSaida = contPokemon.alterar(pokEnt);
        JOptionPane.showMessageDialog(null,pokSaida.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pokemon pokEnt = new Pokemon(id);
        ControllerPokemon contPokemon = new ControllerPokemon();
        Pokemon pokSaida = contPokemon.buscar(pokEnt);
        JOptionPane.showMessageDialog(null,pokSaida.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pokemon pokEnt = new Pokemon(id);
        ControllerPokemon contPokemon = new ControllerPokemon();
        Pokemon pokSaida = contPokemon.excluir(pokEnt);
        JOptionPane.showMessageDialog(null,pokSaida.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Pokemon pokEnt = new Pokemon(nome);
        ControllerPokemon contPokemon = new ControllerPokemon();
        List<Pokemon> listaPok = contPokemon.listar(pokEnt);
        for (Pokemon pokSaida : listaPok) {
            JOptionPane.showMessageDialog(null,pokSaida.toString());
        }
    }
    
}
