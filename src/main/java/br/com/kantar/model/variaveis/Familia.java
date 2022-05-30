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
public class Familia{
    
   private int Id;
   private LocalDate Data;
   private long T1;
   private long T3;
   private long T5;
   private String Processo;
   private int CodPraca;

    public Familia(int Id, LocalDate Data, long T1, long T3, long T5, String Processo, int CodPraca) {
        this.Id = Id;
        this.Data = Data;
        this.T1 = T1;
        this.T3 = T3;
        this.T5 = T5;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    public Familia(LocalDate Data, long T1, long T3, long T5, String Processo, int CodPraca) {
        this.Data = Data;
        this.T1 = T1;
        this.T3 = T3;
        this.T5 = T5;
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

    public long getT1() {
        return T1;
    }

    public void setT1(long T1) {
        this.T1 = T1;
    }

    public long getT3() {
        return T3;
    }

    public void setT3(long T3) {
        this.T3 = T3;
    }

    public long getT5() {
        return T5;
    }

    public void setT5(long T5) {
        this.T5 = T5;
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
    public String toString() {
        return "Familia{" + "Id=" + Id + ", Data=" + Data + ", T1=" + T1 + ", T3=" + T3 + ", T5=" + T5 + ", Processo=" + Processo + ", CodPraca=" + CodPraca + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.Data);
        hash = 23 * hash + (int) (this.T1 ^ (this.T1 >>> 32));
        hash = 23 * hash + (int) (this.T3 ^ (this.T3 >>> 32));
        hash = 23 * hash + (int) (this.T5 ^ (this.T5 >>> 32));
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
        final Familia other = (Familia) obj;
        if (this.T1 != other.T1) {
            return false;
        }
        if (this.T3 != other.T3) {
            return false;
        }
        if (this.T5 != other.T5) {
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

   



   
    }
