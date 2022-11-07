/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerUsuario;
import backenddmn20222.models.beans.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lab04aluno
 */
public class ManterUsuario {
    
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
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Usuario usuEnt = new Usuario(login,senha,status, tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Usuario usuEnt = new Usuario(id,login,senha,status, tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usuEnt = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.buscar(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usuEnt = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.excluir(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        Usuario usuEnt = new Usuario(login);
        ControllerUsuario contUsu = new ControllerUsuario();
        List<Usuario> listaUsuario = contUsu.listar(usuEnt);
        for(Usuario usu : listaUsuario) {
            JOptionPane.showMessageDialog(null, usu.toString());
        }
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        Usuario usuEnt = new Usuario(login,senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        retorno = contUsu.validar(usuEnt);
        return retorno;
    }
}
