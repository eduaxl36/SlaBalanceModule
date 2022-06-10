/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import java.io.IOException;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentServicoPowerBi {

    public void gerarIndicador(int Ano, int Mes) throws IOException {

        EntityManager Conexao =  new HibernateUtil().ConnectionFactoryJPA();
     
        new CurrentPowerBiDaoCabo(Ano, Mes, Conexao).printDataTemCabo();
        new CurrentPowerBiDaoCabo(Ano, Mes, Conexao).printDataNaoTemCabo();

        new CurrentPowerBiDaoCrianca(Ano, Mes, Conexao).printDataNaoTemCrianca();
        new CurrentPowerBiDaoCrianca(Ano, Mes, Conexao).printDataTemCrianca();

        new CurrentPowerBiDaoFamilia(Ano, Mes, Conexao).printDataFamilia1_2();
        new CurrentPowerBiDaoFamilia(Ano, Mes, Conexao).printDataFamilia_3_4();
        new CurrentPowerBiDaoFamilia(Ano, Mes, Conexao).printDataFamilia_5();

        new CurrentPowerBiDaoIdade(Ano, Mes, Conexao).printDataIdade_15_34();
        new CurrentPowerBiDaoIdade(Ano, Mes, Conexao).printDataIdade_35_49();
        new CurrentPowerBiDaoIdade(Ano, Mes, Conexao).printDataIdade_50();

        new CurrentPowerBiDaoTelevisores(Ano, Mes, Conexao).printDataTelevisor_1();
        new CurrentPowerBiDaoTelevisores(Ano, Mes, Conexao).printDataTelevisor_2();



        new CurrentPowerBiDaoNse(Ano, Mes,Conexao).printDataNseAb();
        new CurrentPowerBiDaoNse(Ano, Mes,Conexao).printDataNseC1();
        new CurrentPowerBiDaoNse(Ano, Mes,Conexao).printDataNseC2();
        new CurrentPowerBiDaoNse(Ano, Mes,Conexao).printDataNseDe();


    }

    
    public static void main(String[] args) throws IOException {
        
        new CurrentServicoPowerBi().gerarIndicador(2022, Calendar.MAY);
        
        
    }
    
    
}
