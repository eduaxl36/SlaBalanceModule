/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.connectionFactory;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Fillo;
import javax.swing.JOptionPane;

/**
 *
 * @author eduax
 */
public class Connection {



    public static com.codoid.products.fillo.Connection getConexao(TIPOS_ENTREGAS Entrega) throws FilloException {

        System.setProperty("ROW", "4");//Table start row
        System.setProperty("COLUMN", "2");//Table start column
        Fillo fillo = new Fillo();

        com.codoid.products.fillo.Connection Conexao = fillo.getConnection(Entrega.getCaminhoArquivo());
        return Conexao;

    }

}
