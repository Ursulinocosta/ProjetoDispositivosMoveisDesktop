/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerTreinador;
import backenddmn20222.models.beans.Treinador;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lab04aluno
 */
public class ManterTreinador  {
    
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
        String cpf = JOptionPane.showInputDialog("CPF");
        Treinador treEnt = new Treinador(nome,cpf);
        ControllerTreinador contTreinador = new ControllerTreinador();
        Treinador treSaida = contTreinador.inserir(treEnt);
        JOptionPane.showMessageDialog(null,treSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        Treinador treEnt = new Treinador(id,nome,cpf);
        ControllerTreinador contTreinador = new ControllerTreinador();
        Treinador treSaida = contTreinador.alterar(treEnt);
        JOptionPane.showMessageDialog(null,treSaida.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Treinador treEnt = new Treinador(id);
        ControllerTreinador contTreinador = new ControllerTreinador();
        Treinador treSaida = contTreinador.buscar(treEnt);
        JOptionPane.showMessageDialog(null,treSaida.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Treinador treEnt = new Treinador(id);
        ControllerTreinador contTreinador = new ControllerTreinador();
        Treinador treSaida = contTreinador.excluir(treEnt);
        JOptionPane.showMessageDialog(null,treSaida.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Treinador treEnt = new Treinador(nome);
        ControllerTreinador contTreinador = new ControllerTreinador();
        List<Treinador> listaTre = contTreinador.listar(treEnt);
        for (Treinador treSaida : listaTre) {
            JOptionPane.showMessageDialog(null,treSaida.toString());
        }
    }
    
}
