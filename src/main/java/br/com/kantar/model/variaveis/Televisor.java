/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;


import br.com.kantar.model.abs.Variavel;
import java.time.LocalDate;


/**
 *
 * @author eduax
 */
public class Televisor extends Variavel {
    
    private long Tv1;
    private long Tv2;
    private String Processo;
    private int CodPraca;
    
    public Televisor( LocalDate Data,long Tv1, long Tv2,String Processo, int CodPraca) {
        super(Data);
        this.Tv1 = Tv1;
        this.Tv2 = Tv2;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
        
    }

    public long getTv1() {
        return Tv1;
    }

    public void setTv1(long Tv1) {
        this.Tv1 = Tv1;
    }

    public long getTv2() {
        return Tv2;
    }

    public void setTv2(long Tv2) {
        this.Tv2 = Tv2;
    }

    public String getProcesso() {
        return Processo;
    }

    public void setProcesso(String Processo) {
        this.Processo = Processo;
    }

    public int getCodPraca() {
        return CodPraca;
    }

    public void setCodPraca(int CodPraca) {
        this.CodPraca = CodPraca;
    }

   


    
  
}
