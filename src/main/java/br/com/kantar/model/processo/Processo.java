/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.processo;

import br.com.kantar.model.categorias.Contratado;
import br.com.kantar.model.categorias.Instalado;
import br.com.kantar.model.categorias.Processado;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author eduax
 */
public class Processo {
    
  private LocalDate DataProcesso;  
    
  private Contratado Contratado;
  
  private Instalado Instalado;
  
  private Processado Processado;

    public Processo(LocalDate DataProcesso, Contratado Contratado, Instalado Instalado, Processado Processado) {
        this.DataProcesso = DataProcesso;
        this.Contratado = Contratado;
        this.Instalado = Instalado;
        this.Processado = Processado;
    }

    public Processo() {
    }

    public LocalDate getDataProcesso() {
        return DataProcesso;
    }

    public void setDataProcesso(LocalDate DataProcesso) {
        this.DataProcesso = DataProcesso;
    }

    public Contratado getContratado() {
        return Contratado;
    }

    public void setContratado(Contratado Contratado) {
        this.Contratado = Contratado;
    }

    public Instalado getInstalado() {
        return Instalado;
    }

    public void setInstalado(Instalado Instalado) {
        this.Instalado = Instalado;
    }

    public Processado getProcessado() {
        return Processado;
    }

    public void setProcessado(Processado Processado) {
        this.Processado = Processado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.DataProcesso);
        hash = 59 * hash + Objects.hashCode(this.Contratado);
        hash = 59 * hash + Objects.hashCode(this.Instalado);
        hash = 59 * hash + Objects.hashCode(this.Processado);
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
        final Processo other = (Processo) obj;
        if (!Objects.equals(this.DataProcesso, other.DataProcesso)) {
            return false;
        }
        if (!Objects.equals(this.Contratado, other.Contratado)) {
            return false;
        }
        if (!Objects.equals(this.Instalado, other.Instalado)) {
            return false;
        }
        return Objects.equals(this.Processado, other.Processado);
    }

    @Override
    public String toString() {
        return "Processo{" + "DataProcesso=" + DataProcesso + ", Contratado=" + Contratado + ", Instalado=" + Instalado + ", Processado=" + Processado + '}';
    }
  
  
  
  
  
    
}
