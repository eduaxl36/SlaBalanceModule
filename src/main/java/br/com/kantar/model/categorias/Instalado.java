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
public class Instalado extends Categoria {
  private float Porcentagem;    

    public Instalado(float Porcentagem) {
        this.Porcentagem = Porcentagem;
    }

    public Instalado(float Porcentagem, br.com.kantar.model.variaveis.Cabo Cabo, br.com.kantar.model.variaveis.Crianca Crianca, br.com.kantar.model.variaveis.Familia Familia, br.com.kantar.model.variaveis.Idade Idade, br.com.kantar.model.variaveis.Nse Nse, br.com.kantar.model.variaveis.Televisor Televisor) {
        super(Cabo, Crianca, Familia, Idade, Nse, Televisor);
        this.Porcentagem = Porcentagem;
    }

    public Instalado() {
    }

    public float getPorcentagem() {
        return Porcentagem;
    }

    public void setPorcentagem(float Porcentagem) {
        this.Porcentagem = Porcentagem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Float.floatToIntBits(this.Porcentagem);
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
        final Instalado other = (Instalado) obj;
        return Float.floatToIntBits(this.Porcentagem) == Float.floatToIntBits(other.Porcentagem);
    }

    @Override
    public String toString() {
        return "Instalado{" + "Porcentagem=" + Porcentagem + '}';
    }
  
  
  
  
  
}
