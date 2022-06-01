/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.abs;

import br.com.kantar.model.variaveis.Cabo;
import br.com.kantar.model.variaveis.crianca;
import br.com.kantar.model.variaveis.familia;
import br.com.kantar.model.variaveis.Idade;
import br.com.kantar.model.variaveis.Nse;
import br.com.kantar.model.variaveis.Televisor;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author eduax
 */
public abstract class Categoria {
    
    private List<Cabo> Cabo;
    private List<crianca> Crianca;
    private List<familia> Familia;
    private List<Idade> Idade;
    private List<Nse> Nse;
    private List<Televisor> Televisor;

    public Categoria() {
    }

    public Categoria(List<Cabo> Cabo, List<crianca> Crianca, List<familia> Familia, List<Idade> Idade, List<Nse> Nse, List<Televisor> Televisor) {
        this.Cabo = Cabo;
        this.Crianca = Crianca;
        this.Familia = Familia;
        this.Idade = Idade;
        this.Nse = Nse;
        this.Televisor = Televisor;
    }

    public List<Cabo> getCabo() {
        return Cabo;
    }

    public void setCabo(List<Cabo> Cabo) {
        this.Cabo = Cabo;
    }

    public List<crianca> getCrianca() {
        return Crianca;
    }

    public void setCrianca(List<crianca> Crianca) {
        this.Crianca = Crianca;
    }

    public List<familia> getFamilia() {
        return Familia;
    }

    public void setFamilia(List<familia> Familia) {
        this.Familia = Familia;
    }

    public List<Idade> getIdade() {
        return Idade;
    }

    public void setIdade(List<Idade> Idade) {
        this.Idade = Idade;
    }

    public List<Nse> getNse() {
        return Nse;
    }

    public void setNse(List<Nse> Nse) {
        this.Nse = Nse;
    }

    public List<Televisor> getTelevisor() {
        return Televisor;
    }

    public void setTelevisor(List<Televisor> Televisor) {
        this.Televisor = Televisor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.Cabo);
        hash = 79 * hash + Objects.hashCode(this.Crianca);
        hash = 79 * hash + Objects.hashCode(this.Familia);
        hash = 79 * hash + Objects.hashCode(this.Idade);
        hash = 79 * hash + Objects.hashCode(this.Nse);
        hash = 79 * hash + Objects.hashCode(this.Televisor);
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
