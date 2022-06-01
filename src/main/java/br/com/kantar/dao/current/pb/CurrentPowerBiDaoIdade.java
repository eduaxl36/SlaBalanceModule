/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import br.com.kantar.dao.cf.ConfiguracoesDao;
import br.com.kantar.model.current.pb.CurrentPowerBiModel;
import br.com.kantar.model.variaveis.Idade;
import static br.com.kantar.util.Util.CalulaTaxa;
import static br.com.kantar.util.Util.retornoData;
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
public class CurrentPowerBiDaoIdade {
    

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;

    public CurrentPowerBiDaoIdade(int Ano,PRACA Praca,int Mes) {
        
        this.Ano=Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        
        Conexao = new HibernateUtil().ConnectionFactoryJPA();
        
    }
    
    
    
    List<CurrentPowerBiModel>SintoniasIdade(
            int Ano,
            String Regiao,
            String Sigla,
            int CodPraca,
            String Variavel,
            String Item,
            int Previsto,
            List<Integer>Instalados,
            List<Integer>Contratados,
            List<Integer>Processados
           
            ) throws IOException
    {
    
    
       List<CurrentPowerBiModel> ItensIdade = new ArrayList();
        
        for(int i=0;i<Instalados.size();i++){
        
           CurrentPowerBiModel ProcessoIdade = null;
           
           ProcessoIdade = new CurrentPowerBiModel
           (
                   
           retornoData(i+1,this.Mes,this.Ano).toString(),
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
            
            ItensIdade.add(ProcessoIdade); 
        }
    
    return ItensIdade;
    
    }
    
   public List<CurrentPowerBiModel>AdicionaIdade15_34() throws IOException{
     

        List<Idade>ItensIdade15_34=this.Conexao.createQuery("from Idade where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-05-01' and '2022-05-31'").getResultList();
        
        List<Integer>Processados = new LinkedList();
        List<Integer>Contratados = new LinkedList();
        List<Integer>Instalados = new LinkedList();
        
        
        String Regiao="";
        String Sigla ="";
        int CodPraca=0;
        String Variavel="";
        String Item="";
        int Previsto=0;
        int Processado=0;
        int Instalado=0;
        int Contratado=0;
        double Taxa=0;
        
        
        for(Idade idade:ItensIdade15_34){
        
            
            Regiao = PRACA.obterRegiao(idade.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  idade.getCodPraca();
            Variavel ="IDADE DA DC";
            Item="15-34";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("15-34", (int) idade.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (idade.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)idade.getI15());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)idade.getI15());
                    
                    break;
                default:

                    Processados.add((int)idade.getI15());
                    break;
            }
            
           
        }
        
        
        
      return  SintoniasIdade(
                
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
   
    public List<CurrentPowerBiModel>AdicionaIdade35_49() throws IOException{
     

        List<Idade>ItensIdade35_49=this.Conexao.createQuery("from Idade where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-05-01' and '2022-05-31'").getResultList();
        
        List<Integer>Processados = new LinkedList();
        List<Integer>Contratados = new LinkedList();
        List<Integer>Instalados = new LinkedList();
        
        
        String Regiao="";
        String Sigla ="";
        int CodPraca=0;
        String Variavel="";
        String Item="";
        int Previsto=0;
        int Processado=0;
        int Instalado=0;
        int Contratado=0;
        double Taxa=0;
        
        
        for(Idade idade:ItensIdade35_49){
        
            
            Regiao = PRACA.obterRegiao(idade.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  idade.getCodPraca();
            Variavel ="IDADE DA DC";
            Item="35-49";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("35-49", (int) idade.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (idade.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)idade.getI35());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)idade.getI35());
                    
                    break;
                default:

                    Processados.add((int)idade.getI35());
                    break;
            }
            
           
        }
        
        
        
      return  SintoniasIdade(
                
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
    
    
    
    
    
     public List<CurrentPowerBiModel>AdicionaIdade_50() throws IOException{
     

        List<Idade>ItensIdade50=this.Conexao.createQuery("from Idade where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-05-01' and '2022-05-31'").getResultList();
        
        List<Integer>Processados = new LinkedList();
        List<Integer>Contratados = new LinkedList();
        List<Integer>Instalados = new LinkedList();
        
        
        String Regiao="";
        String Sigla ="";
        int CodPraca=0;
        String Variavel="";
        String Item="";
        int Previsto=0;
        int Processado=0;
        int Instalado=0;
        int Contratado=0;
        double Taxa=0;
        
        
        for(Idade idade:ItensIdade50){
        
            
            Regiao = PRACA.obterRegiao(idade.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  idade.getCodPraca();
            Variavel ="IDADE DA DC";
            Item="50+";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("50+", (int) idade.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (idade.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)idade.getI50());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)idade.getI50());
                    
                    break;
                default:

                    Processados.add((int)idade.getI50());
                    break;
            }
            
           
        }
        
        
        
      return  SintoniasIdade(
                
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
        

        
        PrintWriter pw = new PrintWriter("c:/teste/teste.txt");
        
        
        br.com.kantar.connectionFactory.PRACA pracas[]=PRACA.values();
        
        for(PRACA pr:pracas){
        

        
        
        List<CurrentPowerBiModel>s =new CurrentPowerBiDaoIdade(2022,pr,Calendar.MAY).AdicionaIdade15_34();
        
       
        s.forEach(x->{
        
        
            
            pw.println(
                    
                    
                    x.getDataIbope().replaceAll("\\-", "")+";"+
                    x.getRegiao()+";"+
                    x.getSigla()+";"+
                    x.getCodPraca()+";"+
                    x.getVariavel()+";"+
                    x.getItem()+";"+
                    x.getPrevisoProcessado()+";"+
                    x.getContratado()+";"+            
                    x.getInstalado()+";"+            
                    x.getProcesado()+";"+
                    String.valueOf(x.getTaxa()).replaceAll("\\.",",")
                                           
                            
            );
        
        });
//        
        
        
        List<CurrentPowerBiModel>sx =new CurrentPowerBiDaoIdade(2022,pr,Calendar.MAY).AdicionaIdade35_49();
        
       
        sx.forEach(sxs->{
        
        
            
            pw.println(
                    
                    
                    sxs.getDataIbope().replaceAll("\\-", "")+";"+
                    sxs.getRegiao()+";"+
                    sxs.getSigla()+";"+
                    sxs.getCodPraca()+";"+
                    sxs.getVariavel()+";"+
                    sxs.getItem()+";"+
                    sxs.getPrevisoProcessado()+";"+
                    sxs.getContratado()+";"+            
                    sxs.getInstalado()+";"+            
                    sxs.getProcesado()+";"+
                    String.valueOf(sxs.getTaxa()).replaceAll("\\.",",")
                                           
                            
            );
        
        });    
    
        
        
        
        
        
        
        
        
        
          List<CurrentPowerBiModel>sxx =new CurrentPowerBiDaoIdade(2022,pr,Calendar.MAY).AdicionaIdade_50();
        
       
        sxx.forEach(sxs->{
        
        
            
            pw.println(
                    
                    
                    sxs.getDataIbope().replaceAll("\\-", "")+";"+
                    sxs.getRegiao()+";"+
                    sxs.getSigla()+";"+
                    sxs.getCodPraca()+";"+
                    sxs.getVariavel()+";"+
                    sxs.getItem()+";"+
                    sxs.getPrevisoProcessado()+";"+
                    sxs.getContratado()+";"+            
                    sxs.getInstalado()+";"+            
                    sxs.getProcesado()+";"+
                    String.valueOf(sxs.getTaxa()).replaceAll("\\.",",")
                                           
                            
            );
        
        });          
        
        
        
       
        
        
        
        
        
        
        }
        
        
        
        
       
        
        
        pw.close();
        
    }
    
    
    
}
