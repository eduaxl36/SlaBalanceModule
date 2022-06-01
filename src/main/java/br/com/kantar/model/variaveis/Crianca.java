/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;
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
public class crianca {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    
    private LocalDate Data;
    private long ComCrianca;
    private long SemCrianca;
    private String Processo;
    private int CodPraca;

    public crianca(int Id, LocalDate Data, long ComCrianca, long SemCrianca, String Processo, int CodPraca) {
        this.Id = Id;
        this.Data = Data;
        this.ComCrianca = ComCrianca;
        this.SemCrianca = SemCrianca;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    public crianca(LocalDate Data, long ComCrianca, long SemCrianca, String Processo, int CodPraca) {
        this.Data = Data;
        this.ComCrianca = ComCrianca;
        this.SemCrianca = SemCrianca;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    public crianca() {
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
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.Data);
        hash = 43 * hash + (int) (this.ComCrianca ^ (this.ComCrianca >>> 32));
        hash = 43 * hash + (int) (this.SemCrianca ^ (this.SemCrianca >>> 32));
        hash = 43 * hash + Objects.hashCode(this.Processo);
        hash = 43 * hash + this.CodPraca;
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
        final crianca other = (crianca) obj;
        if (this.ComCrianca != other.ComCrianca) {
            return false;
        }
        if (this.SemCrianca != other.SemCrianca) {
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
        return "Crianca{" + "Id=" + Id + ", Data=" + Data + ", ComCrianca=" + ComCrianca + ", SemCrianca=" + SemCrianca + ", Processo=" + Processo + ", CodPraca=" + CodPraca + '}';
    }
    
    

    
    
    
    
}
