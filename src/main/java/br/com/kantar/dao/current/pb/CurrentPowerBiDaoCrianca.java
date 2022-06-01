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
import br.com.kantar.model.variaveis.crianca;
import static br.com.kantar.util.Util.CalulaTaxa;
import static br.com.kantar.util.Util.retornoData;
import java.io.IOException;
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
public class CurrentPowerBiDaoCrianca {
    

    private EntityManager Conexao;
    private int Ano;
    private PRACA Praca;
    private int Mes;

    public CurrentPowerBiDaoCrianca(int Ano,PRACA Praca,int Mes) {
        
        this.Ano=Ano;
        this.Praca = Praca;
        this.Mes = Mes;
        
        Conexao = new HibernateUtil().ConnectionFactoryJPA();
        
    }
    
   
    List<CurrentPowerBiModel>SintoniasCriancas(
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
    
    
       List<CurrentPowerBiModel> ItensCrianca = new ArrayList();
        
        for(int i=0;i<Instalados.size();i++){
        
           CurrentPowerBiModel ProcessoCrianca = null;
           
           ProcessoCrianca = new CurrentPowerBiModel
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
            
           ItensCrianca.add(ProcessoCrianca); 
        }
    
    return ItensCrianca;
    
    
    }
    
   public List<CurrentPowerBiModel>AdicionaTemCrianca() throws IOException{
     

        List<crianca>ItensCrianca=this.Conexao.createQuery("from crianca where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-04-01' and '2022-04-30'").getResultList();
        
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
        
        
        for(crianca crianca:ItensCrianca){
        
            
            Regiao = PRACA.obterRegiao(crianca.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  crianca.getCodPraca();
            Variavel ="PRESENCA DE CRIANCA";
            Item="CRIANCA TEM";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("CRIANCA TEM", (int) crianca.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (crianca.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)crianca.getComCrianca());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)crianca.getComCrianca());
                    
                    break;
                default:

                    Processados.add((int)crianca.getComCrianca());
                    break;
            }
            
           
        }
        
        
        
      return  SintoniasCriancas(
                
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
   
    public List<CurrentPowerBiModel>AdicionaNaoTemCrianca() throws IOException{
     
        
       
        List<crianca>ItensCrianca=this.Conexao.createQuery("from crianca where CodPraca='"+this.Praca.getCodigo()+"' and data between '2022-04-01' and '2022-04-30'").getResultList();
        
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
        
        
        for(crianca crianca:ItensCrianca){
        
            
            Regiao = PRACA.obterRegiao(crianca.getCodPraca());
            Sigla = this.Praca.getDescr();
            CodPraca =  crianca.getCodPraca();
            Variavel ="PRESENCA DE CRIANCA";
            Item="CRIANCA NAO TEM";
            Previsto=(int) new ConfiguracoesDao().obterPrevisto("CRIANCA NAO TEM", (int) crianca.getCodPraca(), this.Ano);
            Processado=0;
            Instalado=0;
            Contratado=0;
            Taxa=0;
//            
            switch (crianca.getProcesso()) {
                
                case "INSTALADO":
                  
                    Instalados.add((int)crianca.getSemCrianca());
                    
                    break;
                case "CONTRATADO":
                
                    
                    Contratados.add((int)crianca.getSemCrianca());
                    
                    break;
                default:

                    Processados.add((int)crianca.getSemCrianca());
                    break;
            }
            
           
        }
        
        
        
      return  SintoniasCriancas(
                
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
        

//        List<CurrentPowerBiModel>s =new CurrentPowerBiDaoCrianca(2022,PRACA.PNT,Calendar.APRIL).AdicionaTemCrianca();
//        
//       
//        s.forEach(x->{
//        
//        
//            
//            System.out.println(
//                    
//                    
//                    x.getDataIbope().replaceAll("\\-", "")+";"+
//                    x.getRegiao()+";"+
//                    x.getSigla()+";"+
//                    x.getCodPraca()+";"+
//                    x.getVariavel()+";"+
//                    x.getItem()+";"+
//                    x.getPrevisoProcessado()+";"+
//                    x.getContratado()+";"+            
//                    x.getInstalado()+";"+            
//                    x.getProcesado()+";"+
//                    String.valueOf(x.getTaxa()).replaceAll("\\.",",")
//                                           
//                            
//            );
//        
//        });
//        
        
        
        List<CurrentPowerBiModel>sx =new CurrentPowerBiDaoCrianca(2022,PRACA.PNT,Calendar.APRIL).AdicionaNaoTemCrianca();
        
       
        sx.forEach(sxs->{
        
        
            
            System.out.println(
                    
                    
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
