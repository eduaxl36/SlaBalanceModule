/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.cf;

import java.util.Objects;

/**
 *
 * @author eduax
 */
public class Configuracoes {
    
    private int Ano;
    private int CodPraca;
    private String Variavel;
    private String Item;
    private int Valor;

    public Configuracoes(int Ano, int CodPraca, String Variavel, String Item, int Valor) {
        this.Ano = Ano;
        this.CodPraca = CodPraca;
        this.Variavel = Variavel;
        this.Item = Item;
        this.Valor = Valor;
    }

    public Configuracoes() {
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public int getCodPraca() {
        return CodPraca;
    }

    public void setCodPraca(int CodPraca) {
        this.CodPraca = CodPraca;
    }

    public String getVariavel() {
        return Variavel;
    }

    public void setVariavel(String Variavel) {
        this.Variavel = Variavel;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Configuracoes{Ano=").append(Ano);
        sb.append(", CodPraca=").append(CodPraca);
        sb.append(", Variavel=").append(Variavel);
        sb.append(", Item=").append(Item);
        sb.append(", Valor=").append(Valor);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
    
   
    
}
