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
public class Nse  {
    private int Id;
    private LocalDate Data;
    private long Ab;
    private long C1;
    private long C2;
    private long De;
    private String Processo;
    private int CodPraca;

    public Nse(int Id, LocalDate Data, long Ab, long C1, long C2, long De, String Processo, int CodPraca) {
        this.Id = Id;
        this.Data = Data;
        this.Ab = Ab;
        this.C1 = C1;
        this.C2 = C2;
        this.De = De;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
    }

    public Nse(LocalDate Data, long Ab, long C1, long C2, long De, String Processo, int CodPraca) {
        this.Data = Data;
        this.Ab = Ab;
        this.C1 = C1;
        this.C2 = C2;
        this.De = De;
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

    public long getAb() {
        return Ab;
    }

    public void setAb(long Ab) {
        this.Ab = Ab;
    }

    public long getC1() {
        return C1;
    }

    public void setC1(long C1) {
        this.C1 = C1;
    }

    public long getC2() {
        return C2;
    }

    public void setC2(long C2) {
        this.C2 = C2;
    }

    public long getDe() {
        return De;
    }

    public void setDe(long De) {
        this.De = De;
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
        hash = 37 * hash + this.Id;
        hash = 37 * hash + Objects.hashCode(this.Data);
        hash = 37 * hash + (int) (this.Ab ^ (this.Ab >>> 32));
        hash = 37 * hash + (int) (this.C1 ^ (this.C1 >>> 32));
        hash = 37 * hash + (int) (this.C2 ^ (this.C2 >>> 32));
        hash = 37 * hash + (int) (this.De ^ (this.De >>> 32));
        hash = 37 * hash + Objects.hashCode(this.Processo);
        hash = 37 * hash + this.CodPraca;
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
        final Nse other = (Nse) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.Ab != other.Ab) {
            return false;
        }
        if (this.C1 != other.C1) {
            return false;
        }
        if (this.C2 != other.C2) {
            return false;
        }
        if (this.De != other.De) {
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
        return "Nse{" + "Id=" + Id + ", Data=" + Data + ", Ab=" + Ab + ", C1=" + C1 + ", C2=" + C2 + ", De=" + De + ", Processo=" + Processo + ", CodPraca=" + CodPraca + '}';
    }


    
    
    
    

}
