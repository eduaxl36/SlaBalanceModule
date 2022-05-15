/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.categorias;

import br.com.kantar.model.abs.Categoria;

/**
 *
 * @author eduax
 */
public class Processado extends Categoria {
    
    private float Porcentagem;
    
    private long Previsto;

    public Processado() {
    }

    public Processado(float Porcentagem, long Previsto) {
        this.Porcentagem = Porcentagem;
        this.Previsto = Previsto;
    }

    public Processado(float Porcentagem, long Previsto, br.com.kantar.model.variaveis.Cabo Cabo, br.com.kantar.model.variaveis.Crianca Crianca, br.com.kantar.model.variaveis.Familia Familia, br.com.kantar.model.variaveis.Idade Idade, br.com.kantar.model.variaveis.Nse Nse, br.com.kantar.model.variaveis.Televisor Televisor) {
        super(Cabo, Crianca, Familia, Idade, Nse, Televisor);
        this.Porcentagem = Porcentagem;
        this.Previsto = Previsto;
    }

    public float getPorcentagem() {
        return Porcentagem;
    }

    public void setPorcentagem(float Porcentagem) {
        this.Porcentagem = Porcentagem;
    }

    public long getPrevisto() {
        return Previsto;
    }

    public void setPrevisto(long Previsto) {
        this.Previsto = Previsto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Float.floatToIntBits(this.Porcentagem);
        hash = 53 * hash + (int) (this.Previsto ^ (this.Previsto >>> 32));
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
        final Processado other = (Processado) obj;
        if (Float.floatToIntBits(this.Porcentagem) != Float.floatToIntBits(other.Porcentagem)) {
            return false;
        }
        return this.Previsto == other.Previsto;
    }

    @Override
    public String toString() {
        return "Processado{" + "Porcentagem=" + Porcentagem + ", Previsto=" + Previsto + '}';
    }

    
    
    
}
