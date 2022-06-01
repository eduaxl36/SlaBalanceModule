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
import br.com.kantar.model.variaveis.Idade;
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

/**
 *
 * @author Eduardo.Fernando
 */
public class IdadeDao {

    private int CodPraca;
    private int Mes;
    private TIPOS_ENTREGAS Processo;
    private int Ano;
    EntityManager em;

    public IdadeDao(int Mes, int Ano, EntityManager em) {

        this.Mes = Mes;
        this.Ano = Ano;
        this.em = em;
    }

    public IdadeDao(int CodPraca, int Mes, TIPOS_ENTREGAS Processo, int Ano) {
        this.CodPraca = CodPraca;
        this.Mes = Mes;
        this.Processo = Processo;
        this.Ano = Ano;
    }

    public IdadeDao() {
    }

    public List<Idade> obterListaRetornoIdade(List<Integer> I15, List<Integer> I35, List<Integer> I50) {

        List<Idade> Idades = new ArrayList();

        for (int i = 0; i < I15.size(); i++) {

            Idades.add(new Idade(retornoData(i + 1, this.Mes, this.Ano), I15.get(i), I35.get(i), I50.get(i), this.Processo.toString(), this.CodPraca));

        }

        return Idades;

    }

    public List<Integer> persistirPlanilhaObterI15() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_I15 = "Select * from " + obterPraca(this.CodPraca) + " where BL='I15'";

        List<Integer> IdadeI15 = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_I15);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                IdadeI15.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeI15;
    }

    public List<Integer> persistirPlanilhaObteI35() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_I35 = "Select * from " + obterPraca(this.CodPraca) + " where BL='I35'";

        List<Integer> IdadeI35 = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_I35);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                IdadeI35.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeI35;
    }

    public List<Integer> persistirPlanilhaObterI50() throws FilloException {

        String STRING_CONEXAO_GET_IDADE_I50 = "Select * from " + obterPraca(this.CodPraca) + " where BL='I50'";

        List<Integer> IdadeI50 = new LinkedList<>();

        Connection Conexao = getConexao(this.Processo);

        Recordset ResultSet = Conexao.executeQuery(STRING_CONEXAO_GET_IDADE_I50);

        while (ResultSet.next()) {

            for (int i = 1; i <= Util.obterUltimoDiaMes(this.Mes); i++) {

                IdadeI50.add(Integer.parseInt(ResultSet.getField("" + i)));

            }

        }

        ResultSet.close();
        Conexao.close();

        return IdadeI50;
    }

    public void percorrerDadosSheet() throws FilloException {

        PRACA[] Pracas = PRACA.values();
        TIPOS_ENTREGAS Tipos[] = TIPOS_ENTREGAS.values();

        for (PRACA praca : Pracas) {

            for (TIPOS_ENTREGAS Tipo : Tipos) {

                PersistirDadosIdade(praca, Tipo);

            }

        }

    }

    public void PersistirDadosIdade(PRACA Praca, TIPOS_ENTREGAS Tipo) throws FilloException {

        IdadeDao Idade = new IdadeDao(Praca.getCodigo(), this.Mes, Tipo, this.Ano);

        List<Idade> Idades = Idade.obterListaRetornoIdade(Idade.persistirPlanilhaObterI15(), Idade.persistirPlanilhaObteI35(), Idade.persistirPlanilhaObterI50());

        Idades.forEach(x -> {

            this.em.persist(x);

        });

    }

    public static void main(String[] args) throws FilloException {

  
    }

}
