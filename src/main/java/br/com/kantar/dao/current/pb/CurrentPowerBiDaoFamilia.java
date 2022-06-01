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
import static br.com.kantar.util.Util.retornoData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentPowerBiDaoFamilia {

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;

    public CurrentPowerBiDaoFamilia(int Ano, PRACA Praca, int Mes) {

        this.Ano = Ano;
        this.Praca = Praca;
        this.Mes = Mes;

        Conexao = new HibernateUtil().ConnectionFactoryJPA();

    }

    List<CurrentPowerBiModel> SintoniasFamilia(
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
                    (float) CalulaTaxa(CodPraca, Processados.get(i), Ano, Item));

            ItensFamilia.add(ProcessoFamilia);
        }

        return ItensFamilia;

    }

    public List<CurrentPowerBiModel> AdicionaFam1_2() throws IOException {

        List<familia> ItensFamilia_1_2 = this.Conexao.createQuery("from familia where CodPraca='" + this.Praca.getCodigo() + "' and data between '2022-04-01' and '2022-04-30'").getResultList();

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
        double Taxa = 0;

        for (familia familia : ItensFamilia_1_2) {

            Regiao = PRACA.obterRegiao(familia.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = familia.getCodPraca();
            Variavel = "TAMANHO DA FAMILIA";
            Item = "1-2 PESSOAS";
            Previsto = (int) new ConfiguracoesDao().obterPrevisto("1-2 PESSOAS", (int) familia.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;
            Taxa = 0;
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

        return SintoniasFamilia(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                Variavel,
                Item,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    public List<CurrentPowerBiModel> AdicionaFam3_4() throws IOException {

        List<familia> ItensFamilia_3_4 = this.Conexao.createQuery("from familia where CodPraca='" + this.Praca.getCodigo() + "' and data between '2022-04-01' and '2022-04-30'").getResultList();

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
        double Taxa = 0;

        for (familia familia : ItensFamilia_3_4) {

            Regiao = PRACA.obterRegiao(familia.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = familia.getCodPraca();
            Variavel = "TAMANHO DA FAMILIA";
            Item = "3-4 PESSOAS";
            Previsto = (int) new ConfiguracoesDao().obterPrevisto("3-4 PESSOAS", (int) familia.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;
            Taxa = 0;
//            
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

        return SintoniasFamilia(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                Variavel,
                Item,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

    public List<CurrentPowerBiModel> AdicionaFam_5() throws IOException {

        List<familia> ItensFamilia_5 = this.Conexao.createQuery("from familia where CodPraca='" + this.Praca.getCodigo() + "' and data between '2022-04-01' and '2022-04-30'").getResultList();

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
        double Taxa = 0;

        for (familia familia : ItensFamilia_5) {

            Regiao = PRACA.obterRegiao(familia.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca = familia.getCodPraca();
            Variavel = "TAMANHO DA FAMILIA";
            Item = "5+ PESSOAS";
            Previsto = (int) new ConfiguracoesDao().obterPrevisto("5+ PESSOAS", (int) familia.getCodPraca(), this.Ano);
            Processado = 0;
            Instalado = 0;
            Contratado = 0;
            Taxa = 0;
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

        return SintoniasFamilia(
                this.Ano,
                Regiao,
                Sigla,
                CodPraca,
                Variavel,
                Item,
                Previsto,
                Instalados,
                Contratados,
                Processados
        );

    }

  

    public static void main(String[] args) throws IOException {

        List<CurrentPowerBiModel> s = new CurrentPowerBiDaoFamilia(2022, PRACA.PNT, Calendar.APRIL).AdicionaFam1_2();

        s.forEach(x -> {

            System.out.println(
                    x.getDataIbope().replaceAll("\\-", "") + ";"
                    + x.getRegiao() + ";"
                    + x.getSigla() + ";"
                    + x.getCodPraca() + ";"
                    + x.getVariavel() + ";"
                    + x.getItem() + ";"
                    + x.getPrevisoProcessado() + ";"
                    + x.getContratado() + ";"
                    + x.getInstalado() + ";"
                    + x.getProcesado() + ";"
                    + String.valueOf(x.getTaxa()).replaceAll("\\.", ",")
            );

        });
//        




        List<CurrentPowerBiModel> sx = new CurrentPowerBiDaoFamilia(2022, PRACA.PNT, Calendar.APRIL).AdicionaFam3_4();

        sx.forEach(sxs -> {

            System.out.println(
                    sxs.getDataIbope().replaceAll("\\-", "") + ";"
                    + sxs.getRegiao() + ";"
                    + sxs.getSigla() + ";"
                    + sxs.getCodPraca() + ";"
                    + sxs.getVariavel() + ";"
                    + sxs.getItem() + ";"
                    + sxs.getPrevisoProcessado() + ";"
                    + sxs.getContratado() + ";"
                    + sxs.getInstalado() + ";"
                    + sxs.getProcesado() + ";"
                    + String.valueOf(sxs.getTaxa()).replaceAll("\\.", ",")
            );

        });
        
        
        
        
        
           List<CurrentPowerBiModel> sxx = new CurrentPowerBiDaoFamilia(2022, PRACA.PNT, Calendar.APRIL).AdicionaFam_5();

        sxx.forEach(sxs -> {

            System.out.println(
                    sxs.getDataIbope().replaceAll("\\-", "") + ";"
                    + sxs.getRegiao() + ";"
                    + sxs.getSigla() + ";"
                    + sxs.getCodPraca() + ";"
                    + sxs.getVariavel() + ";"
                    + sxs.getItem() + ";"
                    + sxs.getPrevisoProcessado() + ";"
                    + sxs.getContratado() + ";"
                    + sxs.getInstalado() + ";"
                    + sxs.getProcesado() + ";"
                    + String.valueOf(sxs.getTaxa()).replaceAll("\\.", ",")
            );

        });     
        
        
        
        
        
        
        

    }

}
