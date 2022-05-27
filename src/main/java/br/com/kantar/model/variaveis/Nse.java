/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.variaveis;


import br.com.kantar.model.abs.Variavel;
import java.time.LocalDate;

/**
 *
 * @author eduax
 */
public class Nse extends Variavel {

    private long Ab;
    private long C1;
    private long C2;
    private long De;
    private String Processo;
    private int CodPraca;

    public Nse() {
    }

    public Nse(LocalDate Data, long Ab, long C1, long C2, long De, String Processo, int CodPraca) {
        super(Data);
        this.Ab = Ab;
        this.C1 = C1;
        this.C2 = C2;
        this.De = De;
        this.Processo = Processo;
        this.CodPraca = CodPraca;
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



}
