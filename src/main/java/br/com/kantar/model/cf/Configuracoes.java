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
    String Item;
    private int Valor;

    public Configuracoes() {
    }

    public Configuracoes(int Ano, int CodPraca, String Item, int Valor) {
        this.Ano = Ano;
        this.CodPraca = CodPraca;
        this.Item = Item;
        this.Valor = Valor;
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
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.Ano;
        hash = 59 * hash + this.CodPraca;
        hash = 59 * hash + Objects.hashCode(this.Item);
        hash = 59 * hash + this.Valor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Configuracoes other = (Configuracoes) obj;
        if (this.Ano != other.Ano) {
            return false;
        }
        if (this.CodPraca != other.CodPraca) {
            return false;
        }
        if (this.Valor != other.Valor) {
            return false;
        }
        return Objects.equals(this.Item, other.Item);
    }

    @Override
    public String toString() {
        return "Configuracoes{" + "Ano=" + Ano + ", CodPraca=" + CodPraca + ", Item=" + Item + ", Valor=" + Valor + '}';
    }
    
    
   
    
}
