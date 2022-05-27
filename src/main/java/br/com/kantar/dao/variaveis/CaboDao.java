/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.variaveis;

import static br.com.kantar.connectionFactory.Connection.getConexao;
import br.com.kantar.connectionFactory.PRACA;
import static br.com.kantar.connectionFactory.PRACA.obterPraca;
import br.com.kantar.connectionFactory.TIPOS_ENTREGAS;
import br.com.kantar.model.variaveis.Cabo;
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
public class CaboDao {
    
    private int CodPraca;
    private int Mes;
    private int Ano;
    private TIPOS_ENTREGAS Processo;

    
    public CaboDao(int CodPraca, int Mes,int Ano, TIPOS_ENTREGAS Processo) {
        this.CodPraca = CodPraca;
        this.Mes = Mes;
        this.Processo =Processo;
        this.Ano = Ano;
    }

    public CaboDao() {
    }


    public List<Cabo> obterListaRetornoCabo(List<Integer> Tem,List<Integer> NaoTem) {

        
        List<Cabo> Cabos = new ArrayList();

        for (int i =0; i < Tem.size(); i++) {

            Cabos.add(new Cabo(retornoData(i+1,this.Mes,this.Ano),Tem.get(i), NaoTem.get(i),this.Processo.toString(),this.CodPraca));

        }

        return Cabos;

    }

    public List<Integer> persistirPlanilhaObterCCabo() throws FilloException {

        String STRING_CONEXAO_GET_CCABO = "Select * from "  + obterPraca(this.CodPraca) + " where BL='CABT'";
        
        List<Integer> CCabos = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_CCABO);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              CCabos.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return CCabos;
    }

 
    public List<Integer> persistirPlanilhaObterSCabo() throws FilloException {

        String STRING_CONEXAO_GET_SCABO = "Select * from " + obterPraca(this.CodPraca) + " where BL='CABNT'";
        
        List<Integer> SCabos = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_SCABO);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {
               
              SCabos.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return SCabos;
    }
    
    
    public static void main(String[] args) throws FilloException {
        
                CaboDao CaboDao = new CaboDao(PRACA.CAM.getCodigo(), Calendar.MARCH, 2022,TIPOS_ENTREGAS.INSTALADO);

              
            List<Cabo>Cabos = CaboDao.obterListaRetornoCabo(
                      
                     CaboDao.persistirPlanilhaObterCCabo(),
                     CaboDao.persistirPlanilhaObterSCabo()
                     
              );
            
            
            Cabos.forEach(x->{
            
            
                System.out.println
               (
                        x.getData()+" "+
                        x.getComCabo()+" "
                       +x.getSemCabo()
                   +" "+x.getCategoria()
                     + " " +x.getPraca()
                
                );
                
            
            });
            
            
            
               
               
               
               
              
        
    }
}
