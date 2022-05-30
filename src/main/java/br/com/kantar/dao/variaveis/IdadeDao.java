/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.variaveis;

import static br.com.kantar.connectionFactory.Connection.getConexao;
import br.com.kantar.connectionFactory.PRACA;
import static br.com.kantar.connectionFactory.PRACA.obterPraca;
import br.com.kantar.connectionFactory.TIPOS_ENTREGAS;
import br.com.kantar.model.variaveis.Idade;
import br.com.kantar.util.Util;
import static br.com.kantar.util.Util.retornoData;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Eduardo.Fernando
 */
public class IdadeDao {
       
    private int CodPraca;
    private int Mes;
    private TIPOS_ENTREGAS Categoria;
    private int Ano;
  
    
    
    
    
    public IdadeDao(int CodPraca, int Mes,int Ano, TIPOS_ENTREGAS Categoria) {
        this.CodPraca = CodPraca;
        this.Mes = Mes;
        this.Categoria = Categoria;
        this.Ano = Ano;
    }

    public IdadeDao() {
    }



    public List<Idade> obterListaRetornoIdade(List<Integer> I15,List<Integer> I35,List<Integer> I50) {

        List<Idade> Idades = new ArrayList();

        for (int i = 0; i < I15.size(); i++) {

            Idades.add(new Idade(retornoData(i+1,this.Mes,this.Ano),I15.get(i), I35.get(i),I50.get(i),this.Categoria,this.CodPraca));

        }

        return Idades;

    }

    public List<Integer> persistirPlanilhaObterI15() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_I15 = "Select * from " + obterPraca(this.CodPraca) + " where BL='I15'";
        
        List<Integer> IdadeI15 = new LinkedList<>();

        Connection Conexao = getConexao(this.Categoria);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_I15);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              IdadeI15.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeI15;
    }

 
    
    
    public List<Integer> persistirPlanilhaObteI35() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_I35 = "Select * from " + obterPraca(this.CodPraca) + " where BL='I35'";
        
        List<Integer> IdadeI35 = new LinkedList<>();

        Connection Conexao = getConexao(this.Categoria);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_I35);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              IdadeI35.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeI35;
    }
    
    
 
    
    
     public List<Integer> persistirPlanilhaObterI50() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_I50 = "Select * from " + obterPraca(this.CodPraca) + " where BL='I50'";
        
        List<Integer> IdadeI50 = new LinkedList<>();

        Connection Conexao = getConexao(this.Categoria);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_I50);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              IdadeI50.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeI50;
    }
    
     
     
     
     public static void main(String[] args) throws FilloException {
        
           IdadeDao idadeDao = new IdadeDao(PRACA.CAM.getCodigo(), Calendar.APRIL, 2022,TIPOS_ENTREGAS.INSTALADO);

              
              idadeDao.obterListaRetornoIdade(
                      
                      idadeDao.persistirPlanilhaObterI15(),
                      idadeDao.persistirPlanilhaObteI35(),
                      idadeDao.persistirPlanilhaObterI50()).
                      forEach(x->{
                      
                      System.out.println(x.getData()+" "
                                        +x.getI15()+" "+
                                         x.getI35()+" "+
                                         x.getI50()+" "+
                                         x.getCategoria()+" "+
                                         x.getCodPraca()
                                         
                      
                      
                      );
                      
                      
                      });
              
              
              
         
         
    }
   
}
