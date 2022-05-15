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
public class Nse extends Variavel {
  
    private long Ab;
    private long C1;
    private long C2;
    private long De;

    public Nse() {
    }

    public Nse(long Ab, long C1, long C2, long De) {
        this.Ab = Ab;
        this.C1 = C1;
        this.C2 = C2;
        this.De = De;
    }

    public Nse(long Ab, long C1, long C2, long De, DESCRICOES Descricao) {
        super(Descricao);
        this.Ab = Ab;
        this.C1 = C1;
        this.C2 = C2;
        this.De = De;
    }

    public long getAb() {
        return Ab;
    }

    public void setAb(long Ab) {
        this.Ab = Ab;
    }

    public long getC1() {
        return C1;
    }

    public void setC1(long C1) {
        this.C1 = C1;
    }

    public long getC2() {
        return C2;
    }

    public void setC2(long C2) {
        this.C2 = C2;
    }

    public long getDe() {
        return De;
    }

    public void setDe(long De) {
        this.De = De;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.Ab ^ (this.Ab >>> 32));
        hash = 37 * hash + (int) (this.C1 ^ (this.C1 >>> 32));
        hash = 37 * hash + (int) (this.C2 ^ (this.C2 >>> 32));
        hash = 37 * hash + (int) (this.De ^ (this.De >>> 32));
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
        final Nse other = (Nse) obj;
        if (this.Ab != other.Ab) {
            return false;
        }
        if (this.C1 != other.C1) {
            return false;
        }
        if (this.C2 != other.C2) {
            return false;
        }
        return this.De == other.De;
    }

    @Override
    public String toString() {
        return "Nse{" + "Ab=" + Ab + ", C1=" + C1 + ", C2=" + C2 + ", De=" + De + '}';
    }
    
    
     
}
