/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import br.com.kantar.dao.cf.ConfiguracoesDao;
import br.com.kantar.model.current.pb.CurrentPowerBiModel;
import br.com.kantar.model.variaveis.Nse;
import static br.com.kantar.util.Util.CalulaTaxa;
import static br.com.kantar.util.Util.PrimeiroDiaMes;
import static br.com.kantar.util.Util.UltimoDiaMes;
import static br.com.kantar.util.Util.retornoData;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentPowerBiDaoNse {

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;

    private final String Variavel = "NSE";
    private final String Item1 = "AB";
    private final String Item2 = "C1";
    private final String Item3 = "C2";
    private final String Item4 = "DE";
    private final String OutPrint = "c:/teste/teste.csv";

    public CurrentPowerBiDaoNse(int Ano, int Mes) {

        this.Ano = Ano;
        this.Mes = Mes;

    }

    public CurrentPowerBiDaoNse(int Ano, PRACA Praca, int Mes) {

        this.Ano = Ano;
        this.Praca = Praca;
        this.Mes = Mes;

        Conexao = new HibernateUtil().ConnectionFactoryJPA();

    }

    List<CurrentPowerBiModel> agregarListaNse(int Ano, String Regiao, String Sigla, int CodPraca, String Variavel, String Item, int Previsto, List<Integer> Instalados, List<Integer> Contratados, List<Integer> Processados) throws IOException {

        List<CurrentPowerBiModel> Itens = new ArrayList();

        for (int i = 0; i < Instalados.size(); i++) {

            CurrentPowerBiModel ProcessoNse = null;

            ProcessoNse = new CurrentPowerBiModel(
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

            Itens.add(ProcessoNse);
        }

        return Itens;

    }

    public List<CurrentPowerBiModel> retornaListaAB() throws IOException {

        List<Nse> ItensAb = this.Conexao.createQuery("from Nse where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

        List<Integer> Processados = new LinkedList();
        List<Integer> Contratados = new LinkedList();
        List<Integer> Instalados = new LinkedList();

        String Regiao = "";
        String Sigla = "";
        int CodPraca = 0;
        String Variavel = "";
        String Item = "";
        int Previsto = 0;
        int Processado = 0;
        int Instalado = 0;
        int Contratado = 0;

        for (Nse nse : ItensAb) {

            Regiao = PRACA.obterRegiao(nse.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = nse.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item1, (int) nse.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (nse.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) nse.getAb());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) nse.getAb());

                    break;
                default:

                    Processados.add((int) nse.getAb());
                    break;
            }

        }
  this.Conexao.close();
        return agregarListaNse(
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

    public List<CurrentPowerBiModel> retornaListaC1() throws IOException {

             
        List<Nse> ItensC1 = this.Conexao.createQuery("from Nse where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (Nse Nse : ItensC1) {

            Regiao = PRACA.obterRegiao(Nse.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = Nse.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item2, (int) Nse.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (Nse.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) Nse.getC1());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) Nse.getC1());

                    break;
                default:

                    Processados.add((int) Nse.getC1());
                    break;
            }

        }
  this.Conexao.close();
        return agregarListaNse(
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

    public List<CurrentPowerBiModel> retornaListaC2() throws IOException {

        List<Nse> ItensC2 = this.Conexao.createQuery("from Nse where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (Nse nse : ItensC2) {

            Regiao = PRACA.obterRegiao(nse.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = nse.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item3, (int) nse.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (nse.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) nse.getC2());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) nse.getC2());

                    break;
                default:

                    Processados.add((int) nse.getC2());
                    break;
            }

        }
  this.Conexao.close();
        return agregarListaNse(
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

    public List<CurrentPowerBiModel> retornaListaDe() throws IOException {

        List<Nse> ItensDe = this.Conexao.createQuery("from Nse where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (Nse Nse : ItensDe) {

            Regiao = PRACA.obterRegiao(Nse.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = Nse.getCodPraca();

            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item4, (int) Nse.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (Nse.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) Nse.getDe());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) Nse.getDe());

                    break;
                default:

                    Processados.add((int) Nse.getDe());
                    break;
            }

        }
  this.Conexao.close();
        return agregarListaNse(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                this.Variavel,
                this.Item4,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    
    
    public void printDataNseAb() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

             List<CurrentPowerBiModel>NsesAb =new CurrentPowerBiDaoNse(this.Ano,Pracas,this.Mes).retornaListaAB();
                NsesAb.forEach(Sintonias -> {

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
    
    
    
     public void printDataNseC1() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

             List<CurrentPowerBiModel>NsesC1 =new CurrentPowerBiDaoNse(this.Ano,Pracas,this.Mes).retornaListaC1();
                NsesC1.forEach(Sintonias -> {

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
    
    
     
     
     
     public void printDataNseC2() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

             List<CurrentPowerBiModel>NsesC2 =new CurrentPowerBiDaoNse(this.Ano,Pracas,this.Mes).retornaListaC2();
                NsesC2.forEach(Sintonias -> {

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
     
     
     

     public void printDataNseDe() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

             List<CurrentPowerBiModel>NsesDe =new CurrentPowerBiDaoNse(this.Ano,Pracas,this.Mes).retornaListaDe();
                NsesDe.forEach(Sintonias -> {

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
     
     
     
     
     
     
     
     
     
     
     
     
    
//   
    public static void main(String[] args) throws Exception {

            new CurrentPowerBiDaoNse(2022, Calendar.APRIL).printDataNseAb();
            new CurrentPowerBiDaoNse(2022, Calendar.APRIL).printDataNseC1();
          new CurrentPowerBiDaoNse(2022, Calendar.APRIL).printDataNseC2();
          new CurrentPowerBiDaoNse(2022, Calendar.APRIL).printDataNseDe();
       

    }

}
