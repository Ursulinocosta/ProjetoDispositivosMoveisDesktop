/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222.utils;

import backenddmn20222.utils.ConexaoDb;

/**
 *
 * @author User
 */
public class TesteConexao {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(ConexaoDb.statusConection());
        ConexaoDb.getConexaoMySQL();
        System.out.println(ConexaoDb.statusConection());

    }

    
}
