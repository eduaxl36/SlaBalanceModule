/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
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
          
          
//        new CurrentPowerBiDaoTelevisores(Ano, Mes).printDataTelevisor_1();
//        new CurrentPowerBiDaoTelevisores(Ano, Mes).printDataTelevisor_2();
//
//        new CurrentPowerBiDaoNse(Ano, Mes).printDataNseAb();
//        new CurrentPowerBiDaoNse(Ano, Mes).printDataNseC1();
//        new CurrentPowerBiDaoNse(Ano, Mes).printDataNseC2();
//        new CurrentPowerBiDaoNse(Ano, Mes).printDataNseDe();
//
//        new CurrentPowerBiDaoIdade(Ano, Mes).printDataIdade_15_34();
//        new CurrentPowerBiDaoIdade(Ano, Mes).printDataIdade_35_49();
//        new CurrentPowerBiDaoIdade(Ano, Mes).printDataIdade_50();
//
//        new CurrentPowerBiDaoFamilia(Ano, Mes).printDataFamilia1_2();
//        new CurrentPowerBiDaoFamilia(Ano, Mes).printDataFamilia_3_4();
//        new CurrentPowerBiDaoFamilia(Ano, Mes).printDataFamilia_5();

    }

    
    public static void main(String[] args) throws IOException {
        
        new CurrentServicoPowerBi().gerarIndicador(2022, Calendar.MAY);
        
        
    }
    
    
}
