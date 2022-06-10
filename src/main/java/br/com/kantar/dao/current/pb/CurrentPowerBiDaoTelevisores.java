/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import br.com.kantar.dao.cf.ConfiguracoesDao;
import br.com.kantar.model.current.pb.CurrentPowerBiModel;
import br.com.kantar.model.variaveis.Televisor;
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
public class CurrentPowerBiDaoTelevisores {

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;
    private final String Variavel = "QTD TVS";
    private final String Item1 = "1 TV";
    private final String Item2 = "2+ TVS";
    private final String OutPrint = "c:/teste/teste.csv";

    public CurrentPowerBiDaoTelevisores(int Ano, int Mes,EntityManager Conexao) {

        this.Ano = Ano;
        this.Mes = Mes;
        this.Conexao = Conexao;
   
    }

    public CurrentPowerBiDaoTelevisores(int Ano, PRACA Praca, int Mes,EntityManager Conexao) {

        this.Ano = Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        this.Conexao = Conexao;

    }

    List<CurrentPowerBiModel> agregarListaTelevisores(int Ano, String Regiao, String Sigla, int CodPraca, String Variavel, String Item, int Previsto, List<Integer> Instalados, List<Integer> Contratados, List<Integer> Processados) throws IOException {

        List<CurrentPowerBiModel> Televisores = new ArrayList();

        for (int i = 0; i < Instalados.size(); i++) {

            CurrentPowerBiModel ProcessoTv1 = null;

            ProcessoTv1 = new CurrentPowerBiModel(
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

            Televisores.add(ProcessoTv1);
        }

        return Televisores;

    }

    public List<CurrentPowerBiModel> retornaListaTv1() throws IOException {

        List<Televisor> ItensTv1 = this.Conexao.createQuery("from Televisor where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (Televisor televisor : ItensTv1) {

            Regiao = PRACA.obterRegiao(televisor.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = televisor.getCodPraca();

            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item1, (int) televisor.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (televisor.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) televisor.getTv1());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) televisor.getTv1());

                    break;
                default:

                    Processados.add((int) televisor.getTv1());
                    break;
            }

        }
 
  
        return agregarListaTelevisores(
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
//   

    public List<CurrentPowerBiModel> retornaListaTv2() throws IOException {

//        Query query = session.createQuery(
//    "SELECT d FROM Deal d WHERE d.status=:o or d.status=:a");
//query.setParameter("a", MyEnum.A);
//query.setParameter("o", MyEnum.O);
        List<Televisor> ItensTv2 = this.Conexao.createQuery("from Televisor where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (Televisor televisor : ItensTv2) {

            Regiao = PRACA.obterRegiao(televisor.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = televisor.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item2, (int) televisor.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (televisor.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) televisor.getTv2());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) televisor.getTv2());

                    break;
                default:

                    Processados.add((int) televisor.getTv2());
                    break;
            }

        }
 
        return agregarListaTelevisores(
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

    public void printDataTelevisor_1() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> Televisores_1 = new CurrentPowerBiDaoTelevisores(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaTv1();
                Televisores_1.forEach(Sintonias -> {

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

    public void printDataTelevisor_2() throws IOException {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> Televisores_1 = new CurrentPowerBiDaoTelevisores(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaTv2();
                Televisores_1.forEach(Sintonias -> {

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



}
