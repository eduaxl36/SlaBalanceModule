/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.categorias;

import br.com.kantar.connectionFactory.ConnectionInstalados;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;

/**
 *
 * @author eduax
 */
public class InstaladoDao {
    
Connection Conexao;

    public InstaladoDao() throws FilloException {
        
        Conexao = new ConnectionInstalados().getInstaladosConexao();
       
    }
    
    


    
 
 
 
    
}
