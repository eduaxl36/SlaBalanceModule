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
import br.com.kantar.model.variaveis.crianca;
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
public class CriancaDao {

    private int CodPraca;
    private int Mes;
    private TIPOS_ENTREGAS Processo;
    private int Ano;
    private EntityManager em;

    public CriancaDao(int Mes, int Ano, EntityManager em) {

        this.Mes = Mes;

        this.Ano = Ano;

        this.em = em;
    }

    public CriancaDao(int CodPraca, int Mes, int Ano, TIPOS_ENTREGAS Processo) {
        this.CodPraca = CodPraca;
        this.Mes = Mes;
        this.Processo = Processo;
        this.Ano = Ano;
    }

    public CriancaDao() {
    }

    public List<crianca> obterListaRetornoCrianca(List<Integer> Tem, List<Integer> NaoTem) {

        List<crianca> Criancas = new ArrayList();

        for (int i = 0; i < Tem.size(); i++) {

            Criancas.add(new crianca(retornoData(i + 1, this.Mes, this.Ano), Tem.get(i), NaoTem.get(i), this.Processo.toString(), this.CodPraca));

        }

        return Criancas;

    }

    public List<Integer> persistirPlanilhaObterCTem() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_CTem = "Select * from " + obterPraca(this.CodPraca) + " where BL='CRT'";

        List<Integer> IdadeCRST = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_CTem);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                IdadeCRST.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeCRST;
    }

    public List<Integer> persistirPlanilhaObterCNTem() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_CNTem = "Select * from " + obterPraca(this.CodPraca) + " where BL='CRNT'";

        List<Integer> IdadeCRSNT = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_CNTem);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                IdadeCRSNT.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeCRSNT;
    }

    public void percorrerDadosSheet() throws FilloException {

        PRACA[] Pracas = PRACA.values();
        TIPOS_ENTREGAS Tipos[] = TIPOS_ENTREGAS.values();

        for (PRACA praca : Pracas) {

            for (TIPOS_ENTREGAS Tipo : Tipos) {

                PersistirDadosCrianca(praca, Tipo);

            }

        }

    }

    public void PersistirDadosCrianca(PRACA Praca, TIPOS_ENTREGAS Tipo) throws FilloException {

        CriancaDao CriancaDao = new CriancaDao(Praca.getCodigo(), this.Mes, this.Ano, Tipo);

        List<crianca> Cabos = CriancaDao.obterListaRetornoCrianca(
                CriancaDao.persistirPlanilhaObterCTem(),
                CriancaDao.persistirPlanilhaObterCNTem()
        );

        Cabos.forEach(x -> {

            this.em.persist(x);

        });

    }

    public static void main(String[] args) throws FilloException {

    }

}
