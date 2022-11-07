/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerPessoa;
import backenddmn20222.models.beans.Pessoa;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lab04aluno
 */
public class ManterPessoa {
    
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
        String nome = JOptionPane.showInputDialog("NOME");
        String rg = JOptionPane.showInputDialog("RG");
        String cpf = JOptionPane.showInputDialog("CPF");
        String email = JOptionPane.showInputDialog("EMAIL");
        Pessoa pes = new Pessoa(nome,rg,cpf,email);
        ControllerPessoa contpes = new ControllerPessoa();
        pes = contpes.inserir(pes);
        JOptionPane.showMessageDialog(null,pes.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String rg = JOptionPane.showInputDialog("RG");
        String cpf = JOptionPane.showInputDialog("CPF");
        String email = JOptionPane.showInputDialog("EMAIL");
        Pessoa pes = new Pessoa(id,nome,rg,cpf,email);
        ControllerPessoa contpes = new ControllerPessoa();
        pes = contpes.alterar(pes);
        JOptionPane.showMessageDialog(null,pes.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pes = new Pessoa(id);
        ControllerPessoa contpes = new ControllerPessoa();
        pes = contpes.buscar(pes);
        JOptionPane.showMessageDialog(null,pes.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pes = new Pessoa(id);
        ControllerPessoa contpes = new ControllerPessoa();
        pes = contpes.excluir(pes);
        JOptionPane.showMessageDialog(null,pes.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Pessoa pes = new Pessoa(nome);
        ControllerPessoa contpes = new ControllerPessoa();
        List<Pessoa> listaPes = contpes.listar(pes);
        for (Pessoa pesSaida : listaPes) {
            JOptionPane.showMessageDialog(null,pesSaida.toString());
        }
    }
    
}
