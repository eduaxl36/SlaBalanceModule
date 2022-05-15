/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;

import br.com.kantar.model.abs.DESCRICOES;
import br.com.kantar.model.abs.Variavel;

/**
 *
 * @author eduax
 */
public class Televisor extends Variavel {
    
    private long Tv1;
    private long Tv2;

    public Televisor() {
    }

    public Televisor(long Tv1, long Tv2) {
        this.Tv1 = Tv1;
        this.Tv2 = Tv2;
    }

    public Televisor(long Tv1, long Tv2, DESCRICOES Descricao) {
        super(Descricao);
        this.Tv1 = Tv1;
        this.Tv2 = Tv2;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.Tv1 ^ (this.Tv1 >>> 32));
        hash = 29 * hash + (int) (this.Tv2 ^ (this.Tv2 >>> 32));
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
        final Televisor other = (Televisor) obj;
        if (this.Tv1 != other.Tv1) {
            return false;
        }
        return this.Tv2 == other.Tv2;
    }

    @Override
    public String toString() {
        return "Televisor{" + "Tv1=" + Tv1 + ", Tv2=" + Tv2 + '}';
    }
    
    
  
}
