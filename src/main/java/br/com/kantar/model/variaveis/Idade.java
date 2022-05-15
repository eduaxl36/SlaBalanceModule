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
public class Idade extends Variavel {
    
    private long I15;
    private long I35;
    private long I50;

    public Idade() {
    }

    public Idade(long I15, long I35, long I50) {
        this.I15 = I15;
        this.I35 = I35;
        this.I50 = I50;
    }

    public Idade(long I15, long I35, long I50, DESCRICOES Descricao) {
        super(Descricao);
        this.I15 = I15;
        this.I35 = I35;
        this.I50 = I50;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.I15 ^ (this.I15 >>> 32));
        hash = 23 * hash + (int) (this.I35 ^ (this.I35 >>> 32));
        hash = 23 * hash + (int) (this.I50 ^ (this.I50 >>> 32));
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
        final Idade other = (Idade) obj;
        if (this.I15 != other.I15) {
            return false;
        }
        if (this.I35 != other.I35) {
            return false;
        }
        return this.I50 == other.I50;
    }

    @Override
    public String toString() {
        return "Idade{" + "I15=" + I15 + ", I35=" + I35 + ", I50=" + I50 + '}';
    }
    
    
    
    
}
