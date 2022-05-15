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
public class Cabo extends Variavel {
    
    private long ComCabo;
    private long SemCabo;


    public Cabo() {
    }

    public Cabo(long ComCabo, long SemCabo) {
        this.ComCabo = ComCabo;
        this.SemCabo = SemCabo;
    }

    public Cabo(long ComCabo, long SemCabo, DESCRICOES Descricao) {
        super(Descricao);
        this.ComCabo = ComCabo;
        this.SemCabo = SemCabo;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (this.ComCabo ^ (this.ComCabo >>> 32));
        hash = 11 * hash + (int) (this.SemCabo ^ (this.SemCabo >>> 32));
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
        final Cabo other = (Cabo) obj;
        if (this.ComCabo != other.ComCabo) {
            return false;
        }
        return this.SemCabo == other.SemCabo;
    }

    @Override
    public String toString() {
        return "Cabo{" + "ComCabo=" + ComCabo + ", SemCabo=" + SemCabo + '}';
    }
   
    
    
    
    
}
