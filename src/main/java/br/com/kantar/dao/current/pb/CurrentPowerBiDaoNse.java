/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.current.pb;

import br.com.kantar.connectionFactory.HibernateUtil;
import br.com.kantar.connectionFactory.PRACA;
import br.com.kantar.dao.cf.ConfiguracoesDao;
import br.com.kantar.model.current.pb.CurrentPowerBiModel;
import br.com.kantar.model.variaveis.Nse;
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
public class CurrentPowerBiDaoNse {
    

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;

    public CurrentPowerBiDaoNse(int Ano,PRACA Praca,int Mes) {
        
        this.Ano=Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        
        Conexao = new HibernateUtil().ConnectionFactoryJPA();
        
    }
    
    
    
    List<CurrentPowerBiModel>Nses(int Ano,String Regiao,String Sigla,int CodPraca,String Variavel,String Item,int Previsto,List<Integer>Instalados,List<Integer>Contratados,List<Integer>Processados) throws IOException
    {
    
       List<CurrentPowerBiModel> Itens = new ArrayList();
        
        for(int i=0;i<Instalados.size();i++){
        
           CurrentPowerBiModel ProcessoNse = null;
           
           ProcessoNse = new CurrentPowerBiModel
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
            
            Itens.add(ProcessoNse); 
        }
    
    return Itens;
    
    }
    
   public List<CurrentPowerBiModel>obterSintoniaAB() throws IOException{
     

        List<Nse>ItensAb=this.Conexao.createQuery("from Nse where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-04-01' and '2022-04-30'").getResultList();
        
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
        
        
        for(Nse nse:ItensAb){
        
            
            Regiao = PRACA.obterRegiao(nse.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  nse.getCodPraca();
            Variavel ="NSE";
            Item="AB";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("AB", (int) nse.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (nse.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)nse.getAb());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)nse.getAb());
                    
                    break;
                default:

                    Processados.add((int)nse.getAb());
                    break;
            }
            
           
        }
        
        
        
      return  Nses(
                
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
   
   
   
   
   
    public List<CurrentPowerBiModel>obterSintoniaC1() throws IOException{
     

        List<Nse>ItensAb=this.Conexao.createQuery("from Nse where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-04-01' and '2022-04-30'").getResultList();
        
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
        
        
        for(Nse nse:ItensAb){
        
            
            Regiao = PRACA.obterRegiao(nse.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  nse.getCodPraca();
            Variavel ="NSE";
            Item="C1";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("C1", (int) nse.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (nse.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)nse.getC1());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)nse.getC1());
                    
                    break;
                default:

                    Processados.add((int)nse.getC1());
                    break;
            }
            
           
        }
        
        
        
      return  Nses(
                
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
   
   
   
   
   
    public List<CurrentPowerBiModel>obterSintoniaC2() throws IOException{
     

        List<Nse>ItensAb=this.Conexao.createQuery("from Nse where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-04-01' and '2022-04-30'").getResultList();
        
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
        
        
        for(Nse nse:ItensAb){
        
            
            Regiao = PRACA.obterRegiao(nse.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  nse.getCodPraca();
            Variavel ="NSE";
            Item="C2";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("C2", (int) nse.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (nse.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)nse.getC2());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)nse.getC2());
                    
                    break;
                default:

                    Processados.add((int)nse.getC2());
                    break;
            }
            
           
        }
        
        
        
      return  Nses(
                
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
   
   
   
   
    public List<CurrentPowerBiModel>obterSintoniaDE() throws IOException{
     

        List<Nse>ItensAb=this.Conexao.createQuery("from Nse where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-04-01' and '2022-04-30'").getResultList();
        
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
        
        
        for(Nse nse:ItensAb){
        
            
            Regiao = PRACA.obterRegiao(nse.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  nse.getCodPraca();
            Variavel ="NSE";
            Item="DE";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("DE", (int) nse.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (nse.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)nse.getDe());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)nse.getDe());
                    
                    break;
                default:

                    Processados.add((int)nse.getDe());
                    break;
            }
            
           
        }
        
        
        
      return  Nses(
                
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
   
   
//   
    
    public static void main(String[] args) throws Exception {
        

        List<CurrentPowerBiModel>abs =new CurrentPowerBiDaoNse(2022,PRACA.CAM,Calendar.APRIL).obterSintoniaAB();
        
       
        abs.forEach(x->{
        
        
            
            System.out.println(
                    
                    
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
        
     
        


   List<CurrentPowerBiModel>c1s =new CurrentPowerBiDaoNse(2022,PRACA.CAM,Calendar.APRIL).obterSintoniaC1();
        
       
        c1s.forEach(x->{
        
        
            
            System.out.println(
                    
                    
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








 List<CurrentPowerBiModel>c2s =new CurrentPowerBiDaoNse(2022,PRACA.CAM,Calendar.APRIL).obterSintoniaC2();
        
       
        c2s.forEach(x->{
        
        
            
            System.out.println(
                    
                    
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







 List<CurrentPowerBiModel>des =new CurrentPowerBiDaoNse(2022,PRACA.CAM,Calendar.APRIL).obterSintoniaDE();
        
       
        des.forEach(x->{
        
        
            
            System.out.println(
                    
                    
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












    }
    
    
    
 
    
    
     
        

        
     
        
    
    
    
    
    
    
    
    
    
    
    
    
    
}
        
