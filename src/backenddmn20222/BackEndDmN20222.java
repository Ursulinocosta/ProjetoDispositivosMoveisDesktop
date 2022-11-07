/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222;

import backenddmn20222.views.ManterGinasio;
import backenddmn20222.views.ManterTreinadorPokemon;
import backenddmn20222.views.ManterTreinador;
import backenddmn20222.views.ManterPokemon;
import backenddmn20222.views.ManterPessoa;
import backenddmn20222.views.ManterStatus;
import backenddmn20222.views.ManterUsuario;
import backenddmn20222.views.ManterUsuarioPessoa;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * 
 * @author lab04aluno
 */
public class BackEndDmN20222 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Pessoa \n 3 - UsuarioPessoa \n 4 - Status \n 5 - Pokemon \n 6 - Treinador \n 7 - TreinadorPokemon \n 8 - Ginasio";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario.menu();
                break;
            case 2:
                ManterPessoa.menu();
                break;
            case 3:
                ManterUsuarioPessoa.menu();
                break;
            case 4:
                ManterStatus.menu();
                break;
            case 5:
                ManterPokemon.menu();
                break;
            case 6:
                ManterTreinador.menu();
                        break;
            case 7:
                ManterTreinadorPokemon.menu();
                break;
            case 8:
                ManterGinasio.menu();
                break;
            default:
                System.out.println("Opção inválido");
        }
    }
    
}
