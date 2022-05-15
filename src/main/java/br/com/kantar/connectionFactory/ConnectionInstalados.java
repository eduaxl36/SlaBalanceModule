/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.connectionFactory;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

/**
 *
 * @author eduax
 */
public class ConnectionInstalados {
    
        public Connection getInstaladosConexao() throws FilloException {

        System.setProperty("ROW", "4");//Table start row
        System.setProperty("COLUMN", "2");//Table start column
        Fillo fillo = new Fillo();
        Connection Conexao = fillo.getConnection("C:\\Users\\eduax\\Desktop\\Projetos\\BalanceColect\\FONTE\\teste.xlsx");
        return Conexao;

    }
    
}
