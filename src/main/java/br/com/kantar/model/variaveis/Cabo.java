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
public class Cabo extends Variavel {
    
    private long ComCabo;
    private long SemCabo;
    private String Processo;
    private int CodPraca;
    
  
    public Cabo() {
    }

    public Cabo(LocalDate Data,long ComCabo, long SemCabo,String Processo,int CodPraca) {
        super(Data);
        this.ComCabo = ComCabo;
        this.SemCabo = SemCabo;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    public long getComCabo() {
        return ComCabo;
    }

    public void setComCabo(long ComCabo) {
        this.ComCabo = ComCabo;
    }

    public long getSemCabo() {
        return SemCabo;
    }

    public void setSemCabo(long SemCabo) {
        this.SemCabo = SemCabo;
    }

    public String getCategoria() {
        return Processo;
    }

    public void setCategoria(String Processo) {
        this.Processo = Processo;
    }

    public int getPraca() {
        return CodPraca;
    }

    public void setPraca(int CodPraca) {
        this.CodPraca = CodPraca;
    }



    
    


 
     
    
    
    
}
