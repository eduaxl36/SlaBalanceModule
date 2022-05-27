/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.abs;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author eduax
 */
public abstract class Variavel {
    
 private LocalDate Data;

    public Variavel() {
    }

    public Variavel(LocalDate Data) {
        this.Data = Data;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate Data) {
        this.Data = Data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.Data);
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
        final Variavel other = (Variavel) obj;
        if (!Objects.equals(this.Data, other.Data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Variavel{Data=").append(Data);
        sb.append('}');
        return sb.toString();
    }
   

 
}
