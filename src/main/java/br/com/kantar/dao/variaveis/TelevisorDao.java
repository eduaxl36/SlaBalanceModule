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
import br.com.kantar.model.variaveis.Cabo;
import br.com.kantar.model.variaveis.Televisor;
import br.com.kantar.util.Util;
import static br.com.kantar.util.Util.retornoData;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import java.io.IOException;
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
public class TelevisorDao {

    private int CodPraca;
    private int Mes;
    private TIPOS_ENTREGAS Processo;
    private int Ano;
    private EntityManager em;

    public TelevisorDao(int Mes, int Ano, EntityManager em) {
        this.Mes = Mes;
        this.Ano = Ano;
        this.em = em;
    }

    public TelevisorDao(int CodPraca, int Mes, int Ano, TIPOS_ENTREGAS Processo) {
        this.CodPraca = CodPraca;
        this.Mes = Mes;
        this.Processo = Processo;
        this.Ano = Ano;
    }

    public List<Televisor> obterListaRetornoTelevisores(List<Integer> Televisores1, List<Integer> Televisores2) throws IOException {

        List<Televisor> Televisores = new ArrayList();

        for (int i = 0; i < Televisores1.size(); i++) {
            Televisor Televisor = new Televisor(retornoData(i + 1, this.Mes, this.Ano),
                    Televisores1.get(i),
                    Televisores2.get(i), this.Processo.toString(), this.CodPraca
            );
            Televisores.add(Televisor);

        }

        return Televisores;

    }

    public List<Integer> persistirPlanilhaObterTelevisores1() throws FilloException {

        String STRING_CONEXAO_GET_TELEVISOR1 = "Select * from " + obterPraca(this.CodPraca) + " where BL='TV1'";
        List<Integer> Televisores1 = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ConexaoTv1 = Conexao.executeQuery(STRING_CONEXAO_GET_TELEVISOR1);

        while (ConexaoTv1.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                Televisores1.add(Integer.parseInt(ConexaoTv1.getField("" + i)));

            }

        }

        ConexaoTv1.close();
        ConexaoTv1.close();

        return Televisores1;
    }

    public List<Integer> persistirPlanilhaObterTelevisores2() throws FilloException {

        String STRING_CONEXAO_GET_TELEVISOR2 = "Select * from " + obterPraca(this.CodPraca) + " where BL='TV2'";

        List<Integer> Televisores2 = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ConexaoTv2 = Conexao.executeQuery(STRING_CONEXAO_GET_TELEVISOR2);

        while (ConexaoTv2.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                Televisores2.add(Integer.parseInt(ConexaoTv2.getField("" + i)));

            }

        }

        Conexao.close();
        ConexaoTv2.close();

        return Televisores2;
    }

    public void PersistirDadosTelevisor(PRACA Praca, TIPOS_ENTREGAS Tipo) throws FilloException, IOException {

        TelevisorDao TelevisorDao = new TelevisorDao(Praca.getCodigo(), this.Mes, this.Ano, Tipo);

        List<Televisor> Televisores = TelevisorDao.obterListaRetornoTelevisores(
                TelevisorDao.persistirPlanilhaObterTelevisores1(),
                TelevisorDao.persistirPlanilhaObterTelevisores2()
        );

        Televisores.forEach(x -> {

            em.persist(x);

        });

    }

    public void percorrerDadosSheet() throws FilloException, IOException {

        PRACA[] Pracas = PRACA.values();
        TIPOS_ENTREGAS Tipos[] = TIPOS_ENTREGAS.values();
        EntityManager em = new HibernateUtil().ConnectionFactoryJPA();

        for (PRACA praca : Pracas) {

            for (TIPOS_ENTREGAS Tipo : Tipos) {

                PersistirDadosTelevisor(praca, Tipo);

            }

        }

    }

}
