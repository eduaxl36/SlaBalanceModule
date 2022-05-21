/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.kantar.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author eduax
 */
public class Util {
    
    
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
}
