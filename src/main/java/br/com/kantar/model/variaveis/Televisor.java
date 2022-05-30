/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;



import java.time.LocalDate;
import java.util.Objects;


/**
 *
 * @author eduax
 */
public class Televisor {
    private int Id;
    private LocalDate Data;
    private long Tv1;
    private long Tv2;
    private String Processo;
    private int CodPraca;

    public Televisor(int Id, LocalDate Data, long Tv1, long Tv2, String Processo, int CodPraca) {
        this.Id = Id;
        this.Data = Data;
        this.Tv1 = Tv1;
        this.Tv2 = Tv2;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    public Televisor(LocalDate Data, long Tv1, long Tv2, String Processo, int CodPraca) {
        this.Data = Data;
        this.Tv1 = Tv1;
        this.Tv2 = Tv2;
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

    public long getTv1() {
        return Tv1;
    }

    public void setTv1(long Tv1) {
        this.Tv1 = Tv1;
    }

    public long getTv2() {
        return Tv2;
    }

    public void setTv2(long Tv2) {
        this.Tv2 = Tv2;
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
        hash = 23 * hash + Objects.hashCode(this.Data);
        hash = 23 * hash + (int) (this.Tv1 ^ (this.Tv1 >>> 32));
        hash = 23 * hash + (int) (this.Tv2 ^ (this.Tv2 >>> 32));
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
        final Televisor other = (Televisor) obj;
        if (this.Tv1 != other.Tv1) {
            return false;
        }
        if (this.Tv2 != other.Tv2) {
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
        return "Televisor{" + "Id=" + Id + ", Data=" + Data + ", Tv1=" + Tv1 + ", Tv2=" + Tv2 + ", Processo=" + Processo + ", CodPraca=" + CodPraca + '}';
    }
    
    
   


    
  
}
