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
public class Crianca extends Variavel {
    
    private long ComCrianca;
    private long SemCrianca;

    public Crianca() {
    }

    public Crianca(long ComCrianca, long SemCrianca) {
        this.ComCrianca = ComCrianca;
        this.SemCrianca = SemCrianca;
    }

    public Crianca(long ComCrianca, long SemCrianca, DESCRICOES Descricao) {
        super(Descricao);
        this.ComCrianca = ComCrianca;
        this.SemCrianca = SemCrianca;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (this.ComCrianca ^ (this.ComCrianca >>> 32));
        hash = 37 * hash + (int) (this.SemCrianca ^ (this.SemCrianca >>> 32));
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
        final Crianca other = (Crianca) obj;
        if (this.ComCrianca != other.ComCrianca) {
            return false;
        }
        return this.SemCrianca == other.SemCrianca;
    }

    @Override
    public String toString() {
        return "Crianca{" + "ComCrianca=" + ComCrianca + ", SemCrianca=" + SemCrianca + '}';
    }
    
    
    
    
    
}
