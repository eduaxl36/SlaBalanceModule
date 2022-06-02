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
import br.com.kantar.model.variaveis.Televisor;
import static br.com.kantar.util.Util.CalulaTaxa;
import static br.com.kantar.util.Util.retornoData;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentPowerBiDaoTelevisores {
    

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;

    public CurrentPowerBiDaoTelevisores(int Ano,PRACA Praca,int Mes) {
        
        this.Ano=Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        
        Conexao = new HibernateUtil().ConnectionFactoryJPA();
        
    }
    
    
    
    List<CurrentPowerBiModel>Televisores(int Ano,String Regiao,String Sigla,int CodPraca,String Variavel,String Item,int Previsto,List<Integer>Instalados,List<Integer>Contratados,List<Integer>Processados) throws IOException
    {
    
       List<CurrentPowerBiModel> Itens = new ArrayList();
        
        for(int i=0;i<Instalados.size();i++){
        
           CurrentPowerBiModel ProcessoTv1 = null;
           
           ProcessoTv1 = new CurrentPowerBiModel
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
           (float) CalulaTaxa(CodPraca, Processados.get(i), Ano, Item,Variavel));
            
            Itens.add(ProcessoTv1); 
        }
    
    return Itens;
    
    }
    
   public List<CurrentPowerBiModel>obterSintoniaTv1() throws IOException{
     

        List<Televisor>ItensTv1=this.Conexao.createQuery("from Televisor where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-05-01' and '2022-05-31'").getResultList();
        
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
        
        
        for(Televisor televisor:ItensTv1){
        
            
            Regiao = PRACA.obterRegiao(televisor.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  televisor.getCodPraca();
            Variavel ="QTD TVS";
            Item="1 TV";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto(Variavel,"1 TV", (int) televisor.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (televisor.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)televisor.getTv1());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)televisor.getTv1());
                    
                    break;
                default:

                    Processados.add((int)televisor.getTv1());
                    break;
            }
            
           
        }
        
        
        
      return  Televisores(
                
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
    public List<CurrentPowerBiModel>obterSintoniaTv2() throws IOException{
     

//        Query query = session.createQuery(
//    "SELECT d FROM Deal d WHERE d.status=:o or d.status=:a");
//query.setParameter("a", MyEnum.A);
//query.setParameter("o", MyEnum.O);
        
         List<Televisor>ItensTv2=this.Conexao.createQuery("from Televisor where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-05-01' and '2022-05-31'").getResultList();
        
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
        
        
        for(Televisor televisor:ItensTv2){
        
            
            Regiao = PRACA.obterRegiao(televisor.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  televisor.getCodPraca();
            Variavel ="QTD TVS";
            Item="2+ TVS";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto(Variavel,"2+ TVS", (int) televisor.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (televisor.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)televisor.getTv2());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)televisor.getTv2());
                    
                    break;
                default:

                    Processados.add((int)televisor.getTv2());
                    break;
            }
            
           
        }
        
        
        
      return  Televisores(
                
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
        

                                try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("c:/teste/teste.txt", true)))) {
        
                      br.com.kantar.connectionFactory.PRACA pracas[]=PRACA.values();
             for(PRACA pr:pracas){
             
             
                 
        List<CurrentPowerBiModel>s =new CurrentPowerBiDaoTelevisores(2022,pr,Calendar.MAY).obterSintoniaTv1();
        
       
        s.forEach(x->{
        
        
            
            out.println(
                    
                    
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
        
        
        List<CurrentPowerBiModel>sx =new CurrentPowerBiDaoTelevisores(2022,pr,Calendar.MAY).obterSintoniaTv2();
        
       
        sx.forEach(sxs->{
        
        
            
           out.println(
                    
                    
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
                                
                                
                                }
        
        
      
    
        
    }
    
    
    
}
