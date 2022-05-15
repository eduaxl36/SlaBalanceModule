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
public class Familia extends Variavel {
    
   private long T1;
   private long T3;
   private long T5;

    public Familia() {
    }

    public Familia(long T1, long T3, long T5) {
        this.T1 = T1;
        this.T3 = T3;
        this.T5 = T5;
    }

    public Familia(long T1, long T3, long T5, DESCRICOES Descricao) {
        super(Descricao);
        this.T1 = T1;
        this.T3 = T3;
        this.T5 = T5;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.T1 ^ (this.T1 >>> 32));
        hash = 53 * hash + (int) (this.T3 ^ (this.T3 >>> 32));
        hash = 53 * hash + (int) (this.T5 ^ (this.T5 >>> 32));
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
        final Familia other = (Familia) obj;
        if (this.T1 != other.T1) {
            return false;
        }
        if (this.T3 != other.T3) {
            return false;
        }
        return this.T5 == other.T5;
    }

    @Override
    public String toString() {
        return "Familia{" + "T1=" + T1 + ", T3=" + T3 + ", T5=" + T5 + '}';
    }
    
   
   
    }
