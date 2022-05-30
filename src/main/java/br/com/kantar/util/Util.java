/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.kantar.util;

import br.com.kantar.dao.cf.ConfiguracoesDao;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author eduax
 */
public class Util {
    
    public static double CalulaTaxa(int CodPraca,int Processado,int Ano,String Item) throws IOException{
    
            double PrevistoConvertido =   new ConfiguracoesDao().obterPrevisto(Item, CodPraca, Ano);  
            double ProcessadoConvertido=Processado;
            double Taxa = ProcessadoConvertido/PrevistoConvertido;

            return Taxa;
    }

    public static LocalDate retornoData(int Adicional,int Mes,int Ano){
      
    LocalDate DataRecebida = LocalDate.of(Ano, Mes+1, 1);
    
    if(Adicional==1){
    return DataRecebida;
    }
    else{
    
    return DataRecebida.plusDays(Adicional-1);
    
    }
    
    }
    
    public static int obterUltimoDiaMes(int Mes){
    
    
        Calendar DataCalendario = Calendar.getInstance();
        DataCalendario.set(Calendar.MONTH,Mes);
        return DataCalendario.getActualMaximum(Calendar.DAY_OF_MONTH);
        
    }
    
    public static List<String>obterListaPracas(){
    
    
        List<String> Pracas = 
                     Arrays.asList
                    ("CAM",
                     "GOI",
                     "BHZ",
                     "GRJ",
                     "GSP",
                     "DFE",
                     "CTA",
                     "POA",
                     "FOR",
                     "REC",
                     "SAL",
                     "GBE",
                     "MAN",
                     "GVI"
                    );
    
        return Pracas;
    
    }
    
    public static void main(String[] args) {
        
        System.out.println(retornoData(31,Calendar.JANUARY,2022 ));  
        
        
    }
}
