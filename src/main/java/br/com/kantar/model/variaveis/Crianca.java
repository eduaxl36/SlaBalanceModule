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
public class Crianca extends Variavel {
    
    private long ComCrianca;
    private long SemCrianca;
    private String Processo;
    private int CodPraca;

    public Crianca() {
    }

    public Crianca(LocalDate Data,long ComCrianca, long SemCrianca,String Processo,int CodPraca) {
        super(Data);
        this.ComCrianca = ComCrianca;
        this.SemCrianca = SemCrianca;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    public long getComCrianca() {
        return ComCrianca;
    }

    public void setComCrianca(long ComCrianca) {
        this.ComCrianca = ComCrianca;
    }

    public long getSemCrianca() {
        return SemCrianca;
    }

    public void setSemCrianca(long SemCrianca) {
        this.SemCrianca = SemCrianca;
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
