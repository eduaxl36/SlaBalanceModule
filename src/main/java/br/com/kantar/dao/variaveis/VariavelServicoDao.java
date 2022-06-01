/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.variaveis;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.model.variaveis.Cabo;
import br.com.kantar.util.Util;
import com.codoid.products.exception.FilloException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo.Fernando
 */
public class VariavelServicoDao {

    private int Mes;
    private int Ano;

    public VariavelServicoDao(int Mes, int Ano) {
        this.Mes = Mes;
        this.Ano = Ano;
    }

    public void persistirVariaveis() throws FilloException, IOException {

        EntityManager factory = new HibernateUtil().ConnectionFactoryJPA();

        factory.getTransaction().begin();

        new CaboDao(this.Mes, this.Ano, factory).percorrerDadosSheet();
        new CriancaDao(this.Mes, this.Ano, factory).percorrerDadosSheet();
        new FamiliaDao(this.Mes, this.Ano, factory).percorrerDadosSheet();
        new IdadeDao(this.Mes, this.Ano, factory).percorrerDadosSheet();
        new TelevisorDao(this.Mes, this.Ano, factory).percorrerDadosSheet();
        new NseDao(this.Mes, this.Ano, factory).percorrerDadosSheet();

        factory.getTransaction().commit();
        factory.close();

    }

    public boolean validarSeExisteData(int Mes) {

        EntityManager factory = new HibernateUtil().ConnectionFactoryJPA();

        List<Cabo> ItensCabo = factory.createQuery("from Cabo WHERE CodPraca=103").getResultList();

        return   ItensCabo.stream()
                 .anyMatch(x->x.getData().equals(Util.PrimeiroDiaMes(Ano,Mes)));
        
        

    }

    public static void main(String[] args) throws FilloException, IOException {

        new VariavelServicoDao(Calendar.MAY, 2022).persistirVariaveis();


      //  System.out.println(new VariavelServicoDao(Calendar.JULY, 2022).validarSeExisteData(Calendar.JULY));


    }

}
