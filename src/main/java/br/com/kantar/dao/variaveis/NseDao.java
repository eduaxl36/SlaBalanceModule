/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.variaveis;

import static br.com.kantar.connectionFactory.Connection.getInstaladosConexao;
import br.com.kantar.connectionFactory.TIPOS_ENTREGAS;
import br.com.kantar.model.variaveis.Nse;
import br.com.kantar.model.variaveis.Televisor;
import br.com.kantar.util.Util;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author eduax
 */
public class NseDao {
    
    
    private String Praca;
    private int Mes;
    private TIPOS_ENTREGAS Entrega;

    
    public NseDao(String Praca, int Mes, TIPOS_ENTREGAS Entrega) {
        this.Praca = Praca;
        this.Mes = Mes;
        this.Entrega = Entrega;
    }

    public NseDao() {
    }



    public List<Nse> obterListaRetornoNSE(List<Integer> Ab,List<Integer> C1,List<Integer> C2,List<Integer>De) {

        List<Nse> ClassesNse = new ArrayList();

        for (int i = 0; i < Ab.size(); i++) {

            ClassesNse.add(new Nse(Ab.get(i), C1.get(i),C2.get(i),De.get(i)));

        }

        return ClassesNse;

    }

    public List<Integer> persistirPlanilhaObterNseAb() throws FilloException {

        String STRING_CONEXAO_GET_AB = "Select * from " + this.Praca + " where BL='AB'";
        
        List<Integer> NsesAB = new LinkedList<>();

        Connection Conexao = getInstaladosConexao(this.Entrega);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_AB);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              NsesAB.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return NsesAB;
    }

 
    
    
    public List<Integer> persistirPlanilhaObterNseC1() throws FilloException {

        String STRING_CONEXAO_GET_C1 = "Select * from " + this.Praca + " where BL='C1'";
        
        List<Integer> NsesC1 = new LinkedList<>();

        Connection Conexao = getInstaladosConexao(this.Entrega);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_C1);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              NsesC1.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return NsesC1;
    }
    
    
 
    
    
     public List<Integer> persistirPlanilhaObterNseC2() throws FilloException {

        String STRING_CONEXAO_GET_C2 = "Select * from " + this.Praca + " where BL='C2'";
        
        List<Integer> NsesC2 = new LinkedList<>();

        Connection Conexao = getInstaladosConexao(this.Entrega);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_C2);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              NsesC2.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return NsesC2;
    }
    
     
     
     
     
   public List<Integer> persistirPlanilhaObterNseDE() throws FilloException {

        String STRING_CONEXAO_GET_DE = "Select * from " + this.Praca + " where BL='DE'";
        
        List<Integer> NsesDE = new LinkedList<>();

        Connection Conexao = getInstaladosConexao(this.Entrega);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_DE);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              NsesDE.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return NsesDE;
    }  
     
     
    public static void main(String[] args) throws FilloException {
        
              NseDao tvdao = new NseDao("CAM", Calendar.APRIL, TIPOS_ENTREGAS.INSTALADO);

              System.out.println(
              
              
              
                         tvdao.obterListaRetornoNSE(
                      tvdao.persistirPlanilhaObterNseAb(), 
                      tvdao.persistirPlanilhaObterNseC1(), 
                      tvdao.persistirPlanilhaObterNseC2(), 
                      tvdao.persistirPlanilhaObterNseDE()
              
              )   
              
              
              
              
              );

        
        
       

        
        
    }
    
}
