/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import br.com.kantar.dao.cf.ConfiguracoesDao;
import br.com.kantar.model.current.pb.CurrentPowerBiModel;
import br.com.kantar.model.variaveis.Cabo;
import br.com.kantar.model.variaveis.familia;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentPowerBiDaoFamilia {

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;
    private final String Variavel = "TAMANHO DA FAMILIA";
    private final String Item1 = "1-2 pessoas";
    private final String Item2 = "3-4 pessoas";
    private final String Item3 = "5 E+ pessoas";
    private final String OutPrint = "c:/teste/teste.csv";
  
    
    
    public CurrentPowerBiDaoFamilia(int Ano, int Mes,EntityManager Conexao) {

        this.Ano = Ano;
        this.Mes = Mes;

        this.Conexao = Conexao;

    }
    
    public CurrentPowerBiDaoFamilia(int Ano, PRACA Praca, int Mes,EntityManager Conexao) {

        this.Ano = Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        this.Conexao = Conexao;

    }

    List<CurrentPowerBiModel> agregarListaFamiliar(
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

        List<CurrentPowerBiModel> ItensFamilia = new ArrayList();

        for (int i = 0; i < Instalados.size(); i++) {

            CurrentPowerBiModel ProcessoFamilia = null;

            ProcessoFamilia = new CurrentPowerBiModel(
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

            ItensFamilia.add(ProcessoFamilia);
        }

        return ItensFamilia;

    }

    public List<CurrentPowerBiModel> retornaListaFamilia_1_2() throws IOException {

        List<familia> ItensFamilia_1_2 = this.Conexao.createQuery("from familia where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (familia familia : ItensFamilia_1_2) {

            Regiao = PRACA.obterRegiao(familia.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = familia.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item1, (int) familia.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (familia.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) familia.getT1());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) familia.getT1());

                    break;
                default:

                    Processados.add((int) familia.getT1());
                    break;
            }

        }
 
        return agregarListaFamiliar(
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

    public List<CurrentPowerBiModel> retornaListaFamilia_3_4() throws IOException {

        List<familia> ItensFamilia_3_4 = this.Conexao.createQuery("from familia where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (familia familia : ItensFamilia_3_4) {

            Regiao = PRACA.obterRegiao(familia.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = familia.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item2, (int) familia.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

            switch (familia.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) familia.getT3());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) familia.getT3());

                    break;
                default:

                    Processados.add((int) familia.getT3());
                    break;
            }

        }
 
        return agregarListaFamiliar(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                Variavel,
                this.Item2,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    public List<CurrentPowerBiModel> retornaListaFamilia_5() throws IOException {

       List<familia> ItensFamilia_5 = this.Conexao.createQuery("from familia where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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
    

        for (familia familia : ItensFamilia_5) {

            Regiao = PRACA.obterRegiao(familia.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = familia.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(Variavel,this.Item3, (int) familia.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;
//            
            switch (familia.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) familia.getT5());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) familia.getT5());

                    break;
                default:

                    Processados.add((int) familia.getT5());
                    break;
            }

        }

        return agregarListaFamiliar(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                Variavel,
                this.Item3,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    public void printDataFamilia1_2() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> Familias_1_2 = new CurrentPowerBiDaoFamilia(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaFamilia_1_2();
                Familias_1_2.forEach(Sintonias -> {

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

    public void printDataFamilia_3_4() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> Familias_3_4 = new CurrentPowerBiDaoFamilia(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaFamilia_3_4();
                Familias_3_4.forEach(Sintonias -> {

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

    public void printDataFamilia_5() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> Familias_5 = new CurrentPowerBiDaoFamilia(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaFamilia_5();
                Familias_5.forEach(Sintonias -> {

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

//        new CurrentPowerBiDaoFamilia(2022,java.util.Calendar.APRIL).printDataFamilia1_2();
//         new CurrentPowerBiDaoFamilia(2022,java.util.Calendar.APRIL).printDataFamilia_3_4();
//          new CurrentPowerBiDaoFamilia(2022,java.util.Calendar.APRIL).printDataFamilia_5();
       
    }

}
