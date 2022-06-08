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
public class CurrentPowerBiDaoCabo {

    private EntityManager Conexao;
    private final int Ano;
    private PRACA Praca;
    private final int Mes;
    private final String Variavel = "TV PAGA";
    private final String Item1 = "TEM";
    private final String Item2 = "NAO TEM";
    private final String OutPrint = "c:/teste/teste.csv";

    
    public CurrentPowerBiDaoCabo(int Ano, PRACA Praca, int Mes,EntityManager Conexao) {

        this.Ano = Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        this.Conexao = Conexao;
      

    }

    public CurrentPowerBiDaoCabo(int Ano, int Mes,EntityManager Conexao) {
        this.Ano = Ano;
        this.Mes = Mes;
        this.Conexao = Conexao;

    }

    List<CurrentPowerBiModel> agregarListaCabo(int Ano, String Regiao, String Sigla, int CodPraca, String Variavel, String Item, int Previsto, List<Integer> Instalados, List<Integer> Contratados, List<Integer> Processados) throws IOException {

        List<CurrentPowerBiModel> ItensCaboRet = new ArrayList();

        for (int i = 0; i < Instalados.size(); i++) {

            CurrentPowerBiModel ProcessoTemCabo = null;

            ProcessoTemCabo = new CurrentPowerBiModel(
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

            ItensCaboRet.add(ProcessoTemCabo);
        }

        return ItensCaboRet;

    }

    public List<CurrentPowerBiModel> retornaListaSemCabo() throws IOException {

        List<Cabo> ItensCabo = this.Conexao.createQuery("from Cabo where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (Cabo cabo : ItensCabo) {

            Regiao = PRACA.obterRegiao(cabo.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = cabo.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item2, (int) cabo.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

//            
            switch (cabo.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) cabo.getSemCabo());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) cabo.getSemCabo());

                    break;
                default:

                    Processados.add((int) cabo.getSemCabo());
                    break;
            }

        }

        return agregarListaCabo(
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

    public List<CurrentPowerBiModel> retornaListaCabo() throws IOException {

        List<Cabo> ItensCabo = this.Conexao.createQuery("from Cabo where CodPraca='" + this.Praca.getCodigo() + "' and data between '" + PrimeiroDiaMes(this.Ano, this.Mes) + "' and '" + UltimoDiaMes(this.Ano, this.Mes) + "'").getResultList();

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

        for (Cabo cabo : ItensCabo) {

            Regiao = PRACA.obterRegiao(cabo.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = cabo.getCodPraca();
            Previsto = (int) new ConfiguracoesDao().obterPrevisto(this.Variavel, this.Item1, (int) cabo.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;

            switch (cabo.getProcesso()) {

                case "INSTALADO":

                    Instalados.add((int) cabo.getComCabo());

                    break;
                case "CONTRATADO":

                    Contratados.add((int) cabo.getComCabo());

                    break;
                default:

                    Processados.add((int) cabo.getComCabo());
                    break;
            }

        }
 
        return agregarListaCabo(
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

    public void printDataTemCabo() {

        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> SintoniasComCabo = new CurrentPowerBiDaoCabo(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaCabo();

                SintoniasComCabo.forEach(Sintonias -> {

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

    public void printDataNaoTemCabo() {

        
        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.OutPrint, true)))) {

            br.com.kantar.connectionFactory.PRACA pracas[] = PRACA.values();
            for (PRACA Pracas : pracas) {

                List<CurrentPowerBiModel> SintoniasComCabo = new CurrentPowerBiDaoCabo(this.Ano, Pracas, this.Mes,this.Conexao).retornaListaSemCabo();

                SintoniasComCabo.forEach(Sintonias -> {

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

        } catch (Exception e) {
            System.err.println(e);
        }

    }

//    public static void main(String[] args) throws IOException {
//
//        CurrentPowerBiDaoCabo ds = new CurrentPowerBiDaoCabo(2022,Calendar.APRIL);
//        ds.printDataTemCabo();
//        ds.printDataNaoTemCabo();
//
//    }

}
