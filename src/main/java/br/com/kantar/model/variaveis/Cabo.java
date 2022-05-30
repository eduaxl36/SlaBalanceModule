/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author eduax
 */

@Entity
public class Cabo implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    
    private LocalDate Data;
    private long ComCabo;
    private long SemCabo;
    private String Processo;
    private int CodPraca;
   
  
    public Cabo() {
    }

    public Cabo(int Id, LocalDate Data, long ComCabo, long SemCabo, String Processo, int CodPraca) {
        this.Id = Id;
        this.Data = Data;
        this.ComCabo = ComCabo;
        this.SemCabo = SemCabo;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    
    public Cabo(LocalDate Data,long ComCabo, long SemCabo,String Processo,int CodPraca) {
        this.Data=Data;
        this.ComCabo = ComCabo;
        this.SemCabo = SemCabo;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate Data) {
        this.Data = Data;
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

    public String getProcesso() {
        return Processo;
    }

    public void setProcesso(String Processo) {
        this.Processo = Processo;
    }

    public int getCodPraca() {
        return CodPraca;
    }

    public void setCodPraca(int CodPraca) {
        this.CodPraca = CodPraca;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.Data);
        hash = 41 * hash + (int) (this.ComCabo ^ (this.ComCabo >>> 32));
        hash = 41 * hash + (int) (this.SemCabo ^ (this.SemCabo >>> 32));
        hash = 41 * hash + Objects.hashCode(this.Processo);
        hash = 41 * hash + this.CodPraca;
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
        if (this.SemCabo != other.SemCabo) {
            return false;
        }
        if (this.CodPraca != other.CodPraca) {
            return false;
        }
        if (!Objects.equals(this.Processo, other.Processo)) {
            return false;
        }
        if (!Objects.equals(this.Data, other.Data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cabo{" + "Id=" + Id + ", Data=" + Data + ", ComCabo=" + ComCabo + ", SemCabo=" + SemCabo + ", Processo=" + Processo + ", CodPraca=" + CodPraca + '}';
    }




    
    


 
     
    
    
    
}
