/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;

import br.com.kantar.connectionFactory.TIPOS_ENTREGAS;
import br.com.kantar.model.abs.DESCRICOES;
import br.com.kantar.model.abs.Variavel;
import java.time.LocalDate;

/**
 *
 * @author eduax
 */
public class Familia extends Variavel {
    
   private long T1;
   private long T3;
   private long T5;
   private String Processo;
   private int CodPraca;

    public Familia() {
    }

    public Familia(long T1, long T3, long T5) {
        this.T1 = T1;
        this.T3 = T3;
        this.T5 = T5;
    }

    public Familia(LocalDate Data,long T1, long T3, long T5,String Processo,int CodPraca) {
        super(Data);
        this.T1 = T1;
        this.T3 = T3;
        this.T5 = T5;
        this.Processo=Processo;
        this.CodPraca=CodPraca;
    }

    public long getT1() {
        return T1;
    }

    public void setT1(long T1) {
        this.T1 = T1;
    }

    public long getT3() {
        return T3;
    }

    public void setT3(long T3) {
        this.T3 = T3;
    }

    public long getT5() {
        return T5;
    }

    public void setT5(long T5) {
        this.T5 = T5;
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
