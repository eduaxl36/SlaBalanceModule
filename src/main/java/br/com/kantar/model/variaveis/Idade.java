/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;

import br.com.kantar.connectionFactory.TIPOS_ENTREGAS;
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
public class Idade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    
    private LocalDate Data;
    private long I15;
    private long I35;
    private long I50;
    private String Processo;
    private int CodPraca;

    public Idade() {
    }

    
    
    
    
    
    public Idade(LocalDate Data, long I15, long I35, long I50, String Categoria, int CodPraca) {
        this.Data = Data;
        this.I15 = I15;
        this.I35 = I35;
        this.I50 = I50;
        this.Processo = Categoria;
        this.CodPraca = CodPraca;
    }

    
    
    
    public Idade(int Id, LocalDate Data, long I15, long I35, long I50, String Categoria, int CodPraca) {
        this.Id = Id;
        this.Data = Data;
        this.I15 = I15;
        this.I35 = I35;
        this.I50 = I50;
        this.Processo = Categoria;
        this.CodPraca = CodPraca;
    }

    public String getProcesso() {
        return Processo;
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

    public long getI15() {
        return I15;
    }

    public void setI15(long I15) {
        this.I15 = I15;
    }

    public long getI35() {
        return I35;
    }

    public void setI35(long I35) {
        this.I35 = I35;
    }

    public long getI50() {
        return I50;
    }

    public void setI50(long I50) {
        this.I50 = I50;
    }

    public String getCategoria() {
        return Processo;
    }

    public void setCategoria(String Categoria) {
        this.Processo = Categoria;
    }

    public int getCodPraca() {
        return CodPraca;
    }

    public void setCodPraca(int CodPraca) {
        this.CodPraca = CodPraca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.Data);
        hash = 23 * hash + (int) (this.I15 ^ (this.I15 >>> 32));
        hash = 23 * hash + (int) (this.I35 ^ (this.I35 >>> 32));
        hash = 23 * hash + (int) (this.I50 ^ (this.I50 >>> 32));
        hash = 23 * hash + Objects.hashCode(this.Processo);
        hash = 23 * hash + this.CodPraca;
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
        final Idade other = (Idade) obj;
        if (this.I15 != other.I15) {
            return false;
        }
        if (this.I35 != other.I35) {
            return false;
        }
        if (this.I50 != other.I50) {
            return false;
        }
        if (this.CodPraca != other.CodPraca) {
            return false;
        }
        if (!Objects.equals(this.Data, other.Data)) {
            return false;
        }
        if (this.Processo != other.Processo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Idade{" + "Id=" + Id + ", Data=" + Data + ", I15=" + I15 + ", I35=" + I35 + ", I50=" + I50 + ", Categoria=" + Processo + ", CodPraca=" + CodPraca + '}';
    }
    
    
    
    

}
