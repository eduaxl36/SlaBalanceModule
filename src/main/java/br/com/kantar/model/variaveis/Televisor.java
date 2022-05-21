/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;

import br.com.kantar.model.abs.Variavel;

/**
 *
 * @author eduax
 */
public class Televisor extends Variavel {
    
    private long Tv1;
    private long Tv2;
    private long PrevistoTv1;
    private long PrevistoTv2;
    
    
    public Televisor() {
    }

    public Televisor(long Tv1, long Tv2) {
        this.Tv1 = Tv1;
        this.Tv2 = Tv2;
    }

    public Televisor(long Tv1, long Tv2, long PrevistoTv1, long PrevistoTv2) {
        this.Tv1 = Tv1;
        this.Tv2 = Tv2;
        this.PrevistoTv1 = PrevistoTv1;
        this.PrevistoTv2 = PrevistoTv2;
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

    public long getPrevistoTv1() {
        return PrevistoTv1;
    }

    public void setPrevistoTv1(long PrevistoTv1) {
        this.PrevistoTv1 = PrevistoTv1;
    }

    public long getPrevistoTv2() {
        return PrevistoTv2;
    }

    public void setPrevistoTv2(long PrevistoTv2) {
        this.PrevistoTv2 = PrevistoTv2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.Tv1 ^ (this.Tv1 >>> 32));
        hash = 23 * hash + (int) (this.Tv2 ^ (this.Tv2 >>> 32));
        hash = 23 * hash + (int) (this.PrevistoTv1 ^ (this.PrevistoTv1 >>> 32));
        hash = 23 * hash + (int) (this.PrevistoTv2 ^ (this.PrevistoTv2 >>> 32));
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
        if (this.Tv2 != other.Tv2) {
            return false;
        }
        if (this.PrevistoTv1 != other.PrevistoTv1) {
            return false;
        }
        return this.PrevistoTv2 == other.PrevistoTv2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Televisor{");
        sb.append("Tv1=").append(Tv1);
        sb.append(", Tv2=").append(Tv2);
        sb.append(", PrevistoTv1=").append(PrevistoTv1);
        sb.append(", PrevistoTv2=").append(PrevistoTv2);
        sb.append('}');
        return sb.toString();
    }

  
    
    
  
}
