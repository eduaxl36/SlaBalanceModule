/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.abs;

import br.com.kantar.model.variaveis.Cabo;
import br.com.kantar.model.variaveis.Crianca;
import br.com.kantar.model.variaveis.Familia;
import br.com.kantar.model.variaveis.Idade;
import br.com.kantar.model.variaveis.Nse;
import br.com.kantar.model.variaveis.Televisor;
import java.util.Objects;

/**
 *
 * @author eduax
 */
public abstract class Categoria {
    
    private Cabo Cabo;
    private Crianca Crianca;
    private Familia Familia;
    private Idade Idade;
    private Nse Nse;
    private Televisor Televisor;

    public Categoria() {
    }

   
    public Categoria(Cabo Cabo, Crianca Crianca, Familia Familia, Idade Idade, Nse Nse, Televisor Televisor) {
        this.Cabo = Cabo;
        this.Crianca = Crianca;
        this.Familia = Familia;
        this.Idade = Idade;
        this.Nse = Nse;
        this.Televisor = Televisor;
    }

    public Cabo getCabo() {
        return Cabo;
    }

    public void setCabo(Cabo Cabo) {
        this.Cabo = Cabo;
    }

    public Crianca getCrianca() {
        return Crianca;
    }

    public void setCrianca(Crianca Crianca) {
        this.Crianca = Crianca;
    }

    public Familia getFamilia() {
        return Familia;
    }

    public void setFamilia(Familia Familia) {
        this.Familia = Familia;
    }

    public Idade getIdade() {
        return Idade;
    }

    public void setIdade(Idade Idade) {
        this.Idade = Idade;
    }

    public Nse getNse() {
        return Nse;
    }

    public void setNse(Nse Nse) {
        this.Nse = Nse;
    }

    public Televisor getTelevisor() {
        return Televisor;
    }

    public void setTelevisor(Televisor Televisor) {
        this.Televisor = Televisor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.Cabo);
        hash = 97 * hash + Objects.hashCode(this.Crianca);
        hash = 97 * hash + Objects.hashCode(this.Familia);
        hash = 97 * hash + Objects.hashCode(this.Idade);
        hash = 97 * hash + Objects.hashCode(this.Nse);
        hash = 97 * hash + Objects.hashCode(this.Televisor);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.Cabo, other.Cabo)) {
            return false;
        }
        if (!Objects.equals(this.Crianca, other.Crianca)) {
            return false;
        }
        if (!Objects.equals(this.Familia, other.Familia)) {
            return false;
        }
        if (!Objects.equals(this.Idade, other.Idade)) {
            return false;
        }
        if (!Objects.equals(this.Nse, other.Nse)) {
            return false;
        }
        return Objects.equals(this.Televisor, other.Televisor);
    }

    @Override
    public String toString() {
        return "Categoria{" + "Cabo=" + Cabo + ", Crianca=" + Crianca + ", Familia=" + Familia + ", Idade=" + Idade + ", Nse=" + Nse + ", Televisor=" + Televisor + '}';
    }
    
  
}
