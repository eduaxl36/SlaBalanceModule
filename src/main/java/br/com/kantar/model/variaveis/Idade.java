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
public class Idade extends Variavel {
    
    private long I15;
    private long I35;
    private long I50;
   private TIPOS_ENTREGAS Categoria;
   private int CodPraca;

    public Idade() {
    }

    public Idade(long I15, long I35, long I50) {
        this.I15 = I15;
        this.I35 = I35;
        this.I50 = I50;
    }

    public Idade(LocalDate Data,long I15, long I35, long I50,TIPOS_ENTREGAS Categoria,int CodPraca) {
        super(Data);
        this.I15 = I15;
        this.I35 = I35;
        this.I50 = I50;
        this.Categoria=Categoria;
        this.CodPraca=CodPraca;
    }

    public long getI15() {
        return I15;
    }

    public void setI15(long I15) {
        this.I15 = I15;
    }

    public long getI35() {
        return I35;
    }

    public void setI35(long I35) {
        this.I35 = I35;
    }

    public long getI50() {
        return I50;
    }

    public void setI50(long I50) {
        this.I50 = I50;
    }

    public TIPOS_ENTREGAS getCategoria() {
        return Categoria;
    }

    public void setCategoria(TIPOS_ENTREGAS Categoria) {
        this.Categoria = Categoria;
    }

    public int getCodPraca() {
        return CodPraca;
    }

    public void setCodPraca(int CodPraca) {
        this.CodPraca = CodPraca;
    }

    
    
    
}
