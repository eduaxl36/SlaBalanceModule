/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.categorias;

import br.com.kantar.model.abs.Categoria;
import br.com.kantar.model.variaveis.Cabo;
import br.com.kantar.model.variaveis.Crianca;
import br.com.kantar.model.variaveis.Familia;
import br.com.kantar.model.variaveis.Idade;
import br.com.kantar.model.variaveis.Nse;
import br.com.kantar.model.variaveis.Televisor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author eduax
 */
public class Instalado extends Categoria {

    List<Cabo> SintoniasCabo = new ArrayList();
    List<Crianca> SintoniasCrianca = new ArrayList();
    List<Familia> SintoniasFamilia = new ArrayList();
    List<Idade> SintoniasIdade = new ArrayList();
    List<Nse> SintoniasNse = new ArrayList();
    List<Televisor> SintoniasTelevisor = new ArrayList();

    public Instalado() {
    }

    public Instalado(List<Cabo> Cabo, List<Crianca> Crianca, List<Familia> Familia, List<Idade> Idade, List<Nse> Nse, List<Televisor> Televisor) {
        super(Cabo, Crianca, Familia, Idade, Nse, Televisor);
    }

    public List<Cabo> getSintoniasCabo() {
        return SintoniasCabo;
    }

    public List<Crianca> getSintoniasCrianca() {
        return SintoniasCrianca;
    }

    public List<Familia> getSintoniasFamilia() {
        return SintoniasFamilia;
    }

    public List<Idade> getSintoniasIdade() {
        return SintoniasIdade;
    }

    public List<Nse> getSintoniasNse() {
        return SintoniasNse;
    }

    public List<Televisor> getSintoniasTelevisor() {
        return SintoniasTelevisor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.SintoniasCabo);
        hash = 29 * hash + Objects.hashCode(this.SintoniasCrianca);
        hash = 29 * hash + Objects.hashCode(this.SintoniasFamilia);
        hash = 29 * hash + Objects.hashCode(this.SintoniasIdade);
        hash = 29 * hash + Objects.hashCode(this.SintoniasNse);
        hash = 29 * hash + Objects.hashCode(this.SintoniasTelevisor);
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
        if (!Objects.equals(this.SintoniasCabo, other.SintoniasCabo)) {
            return false;
        }
        if (!Objects.equals(this.SintoniasCrianca, other.SintoniasCrianca)) {
            return false;
        }
        if (!Objects.equals(this.SintoniasFamilia, other.SintoniasFamilia)) {
            return false;
        }
        if (!Objects.equals(this.SintoniasIdade, other.SintoniasIdade)) {
            return false;
        }
        if (!Objects.equals(this.SintoniasNse, other.SintoniasNse)) {
            return false;
        }
        if (!Objects.equals(this.SintoniasTelevisor, other.SintoniasTelevisor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instalado{SintoniasCabo=").append(SintoniasCabo);
        sb.append(", SintoniasCrianca=").append(SintoniasCrianca);
        sb.append(", SintoniasFamilia=").append(SintoniasFamilia);
        sb.append(", SintoniasIdade=").append(SintoniasIdade);
        sb.append(", SintoniasNse=").append(SintoniasNse);
        sb.append(", SintoniasTelevisor=").append(SintoniasTelevisor);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
