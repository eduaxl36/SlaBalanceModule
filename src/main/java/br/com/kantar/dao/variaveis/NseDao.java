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
import br.com.kantar.model.variaveis.Nse;
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
public class NseDao {

    private int CodPraca;
    private int Mes;
    private TIPOS_ENTREGAS Processo;
    private int Ano;
    private EntityManager em;

    public NseDao(int Mes, int Ano, EntityManager em) {
        this.em = em;
        this.Mes = Mes;
        this.Ano = Ano;
    }

    public NseDao(int CodPraca, int Mes, TIPOS_ENTREGAS Processo, int Ano) {
        this.CodPraca = CodPraca;
        this.Mes = Mes;
        this.Processo = Processo;
        this.Ano = Ano;

    }

    public List<Nse> obterListaRetornoNSE(List<Integer> Ab, List<Integer> C1, List<Integer> C2, List<Integer> De) {

        List<Nse> ClassesNse = new ArrayList();

        for (int i = 0; i < Ab.size(); i++) {

            ClassesNse.add(new Nse(retornoData(i + 1, this.Mes, this.Ano), Ab.get(i), C1.get(i), C2.get(i), De.get(i), this.Processo.toString(), this.CodPraca));

        }

        return ClassesNse;

    }

    public List<Integer> persistirPlanilhaObterNseAb() throws FilloException {

        String STRING_CONEXAO_GET_AB = "Select * from " + obterPraca(this.CodPraca) + " where BL='AB'";

        List<Integer> NsesAB = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

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

        String STRING_CONEXAO_GET_C1 = "Select * from " + obterPraca(this.CodPraca) + " where BL='C1'";

        List<Integer> NsesC1 = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

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

        String STRING_CONEXAO_GET_C2 = "Select * from " + obterPraca(this.CodPraca) + " where BL='C2'";

        List<Integer> NsesC2 = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

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

        String STRING_CONEXAO_GET_DE = "Select * from " + obterPraca(this.CodPraca) + " where BL='DE'";

        List<Integer> NsesDE = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

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

    public void percorrerDadosSheet() throws FilloException {

        PRACA[] Pracas = PRACA.values();
        TIPOS_ENTREGAS Tipos[] = TIPOS_ENTREGAS.values();

        EntityManager em = new HibernateUtil().ConnectionFactoryJPA();

        for (PRACA praca : Pracas) {

            for (TIPOS_ENTREGAS Tipo : Tipos) {

                PersistirDadosNse(praca, Tipo);

            }

        }

    }

    public void PersistirDadosNse(PRACA Praca, TIPOS_ENTREGAS Tipo) throws FilloException {

        NseDao Nse = new NseDao(Praca.getCodigo(), this.Mes, Tipo, this.Ano);

        List<Nse> Nses = Nse.obterListaRetornoNSE(Nse.persistirPlanilhaObterNseAb(), Nse.persistirPlanilhaObterNseC1(), Nse.persistirPlanilhaObterNseC2(), Nse.persistirPlanilhaObterNseDE());

        Nses.forEach(x -> {

            em.persist(x);

        });

    }

}
