/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import br.com.kantar.dao.cf.ConfiguracoesDao;
import br.com.kantar.model.current.pb.CurrentPowerBiModel;
import br.com.kantar.model.variaveis.Idade;
import static br.com.kantar.util.Util.CalulaTaxa;
import static br.com.kantar.util.Util.PrimeiroDiaMes;
import static br.com.kantar.util.Util.UltimoDiaMes;
import static br.com.kantar.util.Util.retornoData;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentPowerBiDaoIdade {

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;
    private final String Variavel = "IDADE DA DC";
    private final String Item1 = "15-34 anos";
    private final String Item2 = "35-49 anos";
    private final String Item3 = "50+ anos";
    private final String OutPrint = "c:/teste/teste.csv";

    
        public CurrentPowerBiDaoIdade(int Ano, int Mes) {

        this.Ano = Ano;
        this.Mes = Mes;


    }
    
    public CurrentPowerBiDaoIdade(int Ano, PRACA Praca, int Mes) {

        this.Ano = Ano;
        this.Praca = Praca;
        this.Mes = Mes;

        Conexao = new HibernateUtil().ConnectionFactoryJPA();

    }

    List<CurrentPowerBiModel> agregarListaIdade(
            int Ano,
            String Regiao,
            String Sigla,
            int CodPraca,
            String Variavel,
            String Item,
            int Previsto,
            List<Integer> Instalados,
            List<Integer> Contratados,
            List<Integer> Processados
    ) throws IOException {

        List<CurrentPowerBiModel> ItensIdade = new ArrayList();

        for (int i = 0; i < Instalados.size(); i++) {

            CurrentPowerBiModel ProcessoIdade = null;

            ProcessoIdade = new CurrentPowerBiModel(
                    retornoData(i + 1, this.Mes, this.Ano).toString(),
                    Regiao,
                    Sigla,
                    CodPraca,
                    Variavel,
                    Item,
                    Previsto,
                    Contratados.get(i),
                    Instalados.get(i),
                    Processados.get(i),
                    (float) CalulaTaxa(CodPraca, Processados.get(i), Ano, Item, Variavel));

            ItensIdade.add(ProcessoIdade);
        }
  this.Conexao.close();
        return ItensIdade;

    }

    public List<CurrentPowerBiModel> retornaListaIdade_15_34() throws IOException {

        List<Idade> ItensIdade15_34 = this.Conexao.createQuery("from Idade where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

        List<Integer> Processados = new LinkedList();
        List<Integer> Contratados = new LinkedList();
        List<Integer> Instalados = new LinkedList();

        String Regiao = "";
        String Sigla = "";
        int CodPraca = 0;
        int Previsto = 0;
        int Processado = 0;
        int Instalado = 0;
        int Contratado = 0;
      

        for (Idade idade : ItensIdade15_34) {

            Regiao = PRACA.obterRegiao(idade.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = idade.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item1, (int) idade.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;
          
//            
            switch (idade.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) idade.getI15());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) idade.getI15());

                    break;
                default:

                    Processados.add((int) idade.getI15());
                    break;
            }

        }
  this.Conexao.close();
        return agregarListaIdade(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                this.Variavel,
                this.Item1,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    public List<CurrentPowerBiModel> retornaListaIdade35_49() throws IOException {

      
        List<Idade>ItensIdade35_49=this.Conexao.createQuery("from Idade where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();
        
        List<Integer>Processados = new LinkedList();
        List<Integer>Contratados = new LinkedList();
        List<Integer>Instalados = new LinkedList();
        
        
        String Regiao="";
        String Sigla ="";
        int CodPraca=0;
        int Previsto=0;
        int Processado=0;
        int Instalado=0;
        int Contratado=0;

        
        
        for(Idade idade:ItensIdade35_49){
        
            
            Regiao = PRACA.obterRegiao(idade.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  idade.getCodPraca();
            Previsto=(int) new ConfiguracoesDao().obterPrevisto(this.Variavel,this.Item2, (int) idade.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
   
//            
            switch (idade.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)idade.getI35());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)idade.getI35());
                    
                    break;
                default:

                    Processados.add((int)idade.getI35());
                    break;
            }
            
           
        }
  this.Conexao.close();
        return agregarListaIdade(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                this.Variavel,
                this.Item2,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    public List<CurrentPowerBiModel> retornaListaIdade_50() throws IOException {

        List<Idade> ItensIdade50 = this.Conexao.createQuery("from Idade where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

        List<Integer> Processados = new LinkedList();
        List<Integer> Contratados = new LinkedList();
        List<Integer> Instalados = new LinkedList();

        String Regiao = "";
        String Sigla = "";
        int CodPraca = 0;
        int Previsto = 0;
        int Processado = 0;
        int Instalado = 0;
        int Contratado = 0;
   

        for (Idade idade : ItensIdade50) {

            Regiao = PRACA.obterRegiao(idade.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = idade.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item3, (int) idade.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

          
            switch (idade.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) idade.getI50());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) idade.getI50());

                    break;
                default:

                    Processados.add((int) idade.getI50());
                    break;
            }

        }
  this.Conexao.close();
        return agregarListaIdade(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                this.Variavel,
                this.Item3,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    
    
    public void printDataIdade_15_34() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

              List<CurrentPowerBiModel> Idades15_34 = new CurrentPowerBiDaoIdade(this.Ano, Pracas, this.Mes).retornaListaIdade_15_34();
                Idades15_34.forEach(Sintonias -> {

                    out.println(
                              Sintonias.getDataIbope().replaceAll("\\-", "") + ";"
                            + Sintonias.getRegiao() + ";"
                            + Sintonias.getSigla() + ";"
                            + Sintonias.getCodPraca() + ";"
                            + Sintonias.getVariavel() + ";"
                            + Sintonias.getItem() + ";"
                            + Sintonias.getPrevisoProcessado() + ";"
                            + Sintonias.getContratado() + ";"
                            + Sintonias.getInstalado() + ";"
                            + Sintonias.getProcesado() + ";"
                            + String.valueOf(Sintonias.getTaxa()).replaceAll("\\.", ",")
                    );

                });

            }

        }

    }
    
    
    
    
    
    public void printDataIdade_35_49() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

              List<CurrentPowerBiModel> Idades35_49 = new CurrentPowerBiDaoIdade(this.Ano, Pracas, this.Mes).retornaListaIdade35_49();
                Idades35_49.forEach(Sintonias -> {

                    out.println(
                              Sintonias.getDataIbope().replaceAll("\\-", "") + ";"
                            + Sintonias.getRegiao() + ";"
                            + Sintonias.getSigla() + ";"
                            + Sintonias.getCodPraca() + ";"
                            + Sintonias.getVariavel() + ";"
                            + Sintonias.getItem() + ";"
                            + Sintonias.getPrevisoProcessado() + ";"
                            + Sintonias.getContratado() + ";"
                            + Sintonias.getInstalado() + ";"
                            + Sintonias.getProcesado() + ";"
                            + String.valueOf(Sintonias.getTaxa()).replaceAll("\\.", ",")
                    );

                });

            }

        }

    }
    
    
    
    
    
    
    public void printDataIdade_50() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

              List<CurrentPowerBiModel> Idades_50 = new CurrentPowerBiDaoIdade(this.Ano, Pracas, this.Mes).retornaListaIdade_50();
                Idades_50.forEach(Sintonias -> {

                    out.println(
                              Sintonias.getDataIbope().replaceAll("\\-", "") + ";"
                            + Sintonias.getRegiao() + ";"
                            + Sintonias.getSigla() + ";"
                            + Sintonias.getCodPraca() + ";"
                            + Sintonias.getVariavel() + ";"
                            + Sintonias.getItem() + ";"
                            + Sintonias.getPrevisoProcessado() + ";"
                            + Sintonias.getContratado() + ";"
                            + Sintonias.getInstalado() + ";"
                            + Sintonias.getProcesado() + ";"
                            + String.valueOf(Sintonias.getTaxa()).replaceAll("\\.", ",")
                    );

                });

            }

        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws IOException {
 
      new CurrentPowerBiDaoIdade(2022,Calendar.APRIL).printDataIdade_15_34();
      new CurrentPowerBiDaoIdade(2022,Calendar.APRIL).printDataIdade_35_49();
      new CurrentPowerBiDaoIdade(2022,Calendar.APRIL).printDataIdade_50();

    }

}
