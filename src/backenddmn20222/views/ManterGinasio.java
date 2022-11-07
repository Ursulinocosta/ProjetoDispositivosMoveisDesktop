/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerGinasio;
import backenddmn20222.models.beans.Ginasio;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lab04aluno
 */
public class ManterGinasio {
    
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
        String estado = JOptionPane.showInputDialog("ESTADO");
        String pais = JOptionPane.showInputDialog("PAIS");
        Ginasio ginEnt = new Ginasio(estado, pais);
        ControllerGinasio contGinasio = new ControllerGinasio();
        Ginasio ginSaida = contGinasio.inserir(ginEnt);
        JOptionPane.showMessageDialog(null,ginSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String estado = JOptionPane.showInputDialog("ESTADO");
        String pais = JOptionPane.showInputDialog("PAIS");
        Ginasio ginEnt = new Ginasio(id,estado,pais);
        ControllerGinasio contGinasio = new ControllerGinasio();
        Ginasio ginSaida = contGinasio.alterar(ginEnt);
        JOptionPane.showMessageDialog(null,ginSaida.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Ginasio ginEnt = new Ginasio(id);
        ControllerGinasio contGinasio = new ControllerGinasio();
        Ginasio ginSaida = contGinasio.buscar(ginEnt);
        JOptionPane.showMessageDialog(null,ginSaida.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Ginasio ginEnt = new Ginasio(id);
        ControllerGinasio contGinasio = new ControllerGinasio();
        Ginasio ginSaida = contGinasio.excluir(ginEnt);
        JOptionPane.showMessageDialog(null,ginSaida.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String estado = JOptionPane.showInputDialog("ESTADO");
        Ginasio ginEnt = new Ginasio(estado);
        ControllerGinasio contGinasio = new ControllerGinasio();
        List<Ginasio> listaGin = contGinasio.listar(ginEnt);
        for (Ginasio ginSaida : listaGin) {
            JOptionPane.showMessageDialog(null,ginSaida.toString());
        }
    }
    
}
