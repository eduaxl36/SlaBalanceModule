/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import br.com.kantar.dao.cf.ConfiguracoesDao;
import br.com.kantar.model.current.pb.CurrentPowerBiModel;
import br.com.kantar.model.variaveis.crianca;
import static br.com.kantar.util.Util.CalulaTaxa;
import static br.com.kantar.util.Util.PrimeiroDiaMes;
import static br.com.kantar.util.Util.UltimoDiaMes;
import static br.com.kantar.util.Util.retornoData;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentPowerBiDaoCrianca {

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;
    private String Variavel = "PRESENCA DE CRIANCA";
    private String Item2 = "NAO TEM";
    private String Item1 = "TEM";
    private final String OutPrint = "c:/teste/teste.csv";

    public CurrentPowerBiDaoCrianca(int Ano, int Mes,EntityManager Conexao) {

        this.Ano = Ano;
        this.Mes = Mes;
        this.Conexao= Conexao;

    }

    public CurrentPowerBiDaoCrianca(int Ano, PRACA Praca, int Mes,EntityManager Conexao) {

        this.Ano = Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        Conexao = new HibernateUtil().ConnectionFactoryJPA();
        this.Conexao= Conexao;
    }

    List<CurrentPowerBiModel> agregarListaCrianca(int Ano,String Regiao,String Sigla,int CodPraca,String Variavel,String Item,int Previsto,List<Integer> Instalados,List<Integer> Contratados,List<Integer> Processados) throws IOException {

        List<CurrentPowerBiModel> ItensCrianca = new ArrayList();

        for (int i = 0; i < Instalados.size(); i++) {

            CurrentPowerBiModel ProcessoCrianca = null;

            ProcessoCrianca = new CurrentPowerBiModel(
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

            ItensCrianca.add(ProcessoCrianca);
        }

        return ItensCrianca;

    }

    public List<CurrentPowerBiModel> retornaListaTemCrianca() throws IOException {

        List<crianca> ItensCrianca = this.Conexao.createQuery("from crianca where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (crianca crianca : ItensCrianca) {

            Regiao = PRACA.obterRegiao(crianca.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = crianca.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(Variavel, this.Item1, (int) crianca.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (crianca.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) crianca.getComCrianca());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) crianca.getComCrianca());

                    break;
                default:

                    Processados.add((int) crianca.getComCrianca());
                    break;
            }

        }
  
        return agregarListaCrianca(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                Variavel,
                this.Item1,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    public List<CurrentPowerBiModel> retornaListaNaoTemCrianca() throws IOException {

        String te = "from crianca where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'";

        List<crianca> ItensCrianca = this.Conexao.createQuery("from crianca where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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
        
        for (crianca crianca : ItensCrianca) {

            Regiao = PRACA.obterRegiao(crianca.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = crianca.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item2, (int) crianca.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;
//            
            switch (crianca.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) crianca.getSemCrianca());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) crianca.getSemCrianca());

                    break;
                default:

                    Processados.add((int) crianca.getSemCrianca());
                    break;
            }

        }

        return agregarListaCrianca(
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

    public void printDataNaoTemCrianca() {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> SintoniaCriancas = new CurrentPowerBiDaoCrianca(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaNaoTemCrianca();

                SintoniaCriancas.forEach(Sintonias -> {

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

        } catch (IOException e) {

            System.err.println(e);

        }

    }

    public void printDataTemCrianca() {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> SintoniaCriancas = new CurrentPowerBiDaoCrianca(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaTemCrianca();

                SintoniaCriancas.forEach(Sintonias -> {

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

        } catch (IOException e) {

            System.err.println(e);

        }

    }



}
