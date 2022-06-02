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
import static br.com.kantar.util.Util.CalulaTaxa;
import static br.com.kantar.util.Util.retornoData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentPowerBiDaoCabo {
    

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;

    public CurrentPowerBiDaoCabo(int Ano,PRACA Praca,int Mes) {
        
        this.Ano=Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        
        Conexao = new HibernateUtil().ConnectionFactoryJPA();
        
    }
    
    
    
    List<CurrentPowerBiModel>SintoniasCabo(
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
    
    
       List<CurrentPowerBiModel> ItensCaboRet = new ArrayList();
        
        for(int i=0;i<Instalados.size();i++){
        
           CurrentPowerBiModel ProcessoTemCabo = null;
           
           ProcessoTemCabo = new CurrentPowerBiModel
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
            
            ItensCaboRet.add(ProcessoTemCabo); 
        }
    
    return ItensCaboRet;
    
    }
    
   public List<CurrentPowerBiModel>AdicionaNaoTemCabo() throws IOException{
     

        List<Cabo>ItensCabo=this.Conexao.createQuery("from Cabo where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-05-01' and '2022-05-31'").getResultList();
        
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
        
        
        for(Cabo cabo:ItensCabo){
        
            
            Regiao = PRACA.obterRegiao(cabo.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  cabo.getCodPraca();
            Variavel ="TV PAGA";
            Item="NAO TEM";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("TV PAGA","NAO TEM", (int) cabo.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (cabo.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)cabo.getSemCabo());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)cabo.getSemCabo());
                    
                    break;
                default:

                    Processados.add((int)cabo.getSemCabo());
                    break;
            }
            
           
        }
        
        
        
      return  SintoniasCabo(
                
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
   
    public List<CurrentPowerBiModel>AdicionaTemCabo() throws IOException{
     
     
        List<Cabo>ItensCabo=this.Conexao.createQuery("from Cabo where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-05-01' and '2022-05-31'").getResultList();
        
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
        
        
        for(Cabo cabo:ItensCabo){
        
            
            Regiao = PRACA.obterRegiao(cabo.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  cabo.getCodPraca();
            Variavel ="TV PAGA";
            Item="TEM";
                     
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("TV PAGA","TEM", (int) cabo.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (cabo.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)cabo.getComCabo());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)cabo.getComCabo());
                    
                    break;
                default:

                    Processados.add((int)cabo.getComCabo());
                    break;
            }
            
           
        }
        
        
        
      return  SintoniasCabo(
                
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
        
        
      
        
            List<CurrentPowerBiModel>s =new CurrentPowerBiDaoCabo(2022,pr,Calendar.MAY).AdicionaTemCabo();
        
       
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
      
       List<CurrentPowerBiModel>sc =new CurrentPowerBiDaoCabo(2022,pr,Calendar.MAY).AdicionaNaoTemCabo();
        
       
        sc.forEach(x->{
        
        
            
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
        
       
        }
            
            
            
            
}catch (IOException e) {
    System.err.println(e);
}
        
        
   
        
    }
    
    
    
}
