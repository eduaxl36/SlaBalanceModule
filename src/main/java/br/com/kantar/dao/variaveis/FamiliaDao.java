/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.variaveis;

import static br.com.kantar.connectionFactory.Connection.getConexao;
import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import static br.com.kantar.connectionFactory.PRACA.obterPraca;
import br.com.kantar.connectionFactory.TIPOS_ENTREGAS;
import br.com.kantar.model.variaveis.familia;
import br.com.kantar.util.Util;
import static br.com.kantar.util.Util.retornoData;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eduardo.Fernando
 */
@Component
public class FamiliaDao {

    private int CodPraca;
    private int Mes;
    private TIPOS_ENTREGAS Entrega;
    private int Ano;
    private EntityManager em; 

       public FamiliaDao(int Mes,int Ano,EntityManager em) {
  
        this.Mes = Mes;
        this.Ano = Ano;
        this.em = em;
    } 

    public FamiliaDao(int CodPraca, int Mes, TIPOS_ENTREGAS Processo, int Ano) {
        this.CodPraca = CodPraca;
        this.Mes = Mes;
        this.Entrega = Processo;
        this.Ano = Ano;
    }
    
    public List<familia> obterListaRetornoFamilia(List<Integer> F1, List<Integer> F3, List<Integer> F5) {

        List<familia> Familias = new ArrayList();

        for (int i = 0; i < F1.size(); i++) {

            Familias.add(new familia(retornoData(i+1,this.Mes,this.Ano),F1.get(i), F3.get(i), F5.get(i),this.Entrega.toString(),this.CodPraca));

        }

        return Familias;

    }

    public List<Integer> persistirPlanilhaObterT1() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_T1 = "Select * from " + obterPraca(this.CodPraca)+ " where BL='T1'";

        List<Integer> IdadeT1 = new LinkedList<>();

        
        
        Connection Conexao = getConexao(this.Entrega);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_T1);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                IdadeT1.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeT1;
    }

    public List<Integer> persistirPlanilhaObterT3() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_T3 = "Select * from " + obterPraca(this.CodPraca) + " where BL='T3'";

        List<Integer> IdadeT3 = new LinkedList<>();

        Connection Conexao = getConexao(this.Entrega);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_T3);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                IdadeT3.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeT3;
    }

    public List<Integer> persistirPlanilhaObterT5() throws FilloException {

        
        String STRING_CONEXAO_GET_IDADE_T5 = "Select * from " + obterPraca(this.CodPraca) + " where BL='T5'";

        List<Integer> IdadeT5 = new LinkedList<>();

        Connection Conexao = getConexao(this.Entrega);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_T5);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                IdadeT5.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeT5;
    }
    
    
    
    
     public void percorrerDadosSheet() throws FilloException {

        PRACA[] Pracas = PRACA.values();
        TIPOS_ENTREGAS Tipos[] = TIPOS_ENTREGAS.values();
        EntityManager em = new HibernateUtil().ConnectionFactoryJPA();
        
        for (PRACA praca : Pracas) {

            for (TIPOS_ENTREGAS Tipo : Tipos) {
                        
                PersistirDadosFamilia(praca, Tipo);

            }

        }

    }


     public void PersistirDadosFamilia(PRACA Praca,TIPOS_ENTREGAS Tipo) throws FilloException {

        FamiliaDao Familia = new FamiliaDao(Praca.getCodigo(), this.Mes, Tipo,this.Ano);
      
        List<familia> Familias =Familia.obterListaRetornoFamilia(Familia.persistirPlanilhaObterT1(),Familia.persistirPlanilhaObterT3(),Familia.persistirPlanilhaObterT5());

   

        Familias.forEach(x -> {

            this.em.persist(x);

        });

  


       

    }
    
    
    
    
    
    
    

    
}
