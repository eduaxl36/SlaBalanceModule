/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.current.pb;

/**
 *
 * @author Eduardo.Fernando
 */
public class CurrentPowerBiModel {
    
    private String DataIbope;
    private String Regiao;
    private String Sigla;
    private int CodPraca;
    private String Variavel;
    private String Item;
    private int PrevisoProcessado;
    private int Contratado;
    private int Instalado;
    private int Procesado;
    private float Taxa;

    public CurrentPowerBiModel() {
    }

    public CurrentPowerBiModel(String DataIbope, String Regiao, String Sigla, int CodPraca, String Variavel, String Item, int PrevisoProcessado, int Contratado, int Instalado, int Procesado, float Taxa) {
        this.DataIbope = DataIbope;
        this.Regiao = Regiao;
        this.Sigla = Sigla;
        this.CodPraca = CodPraca;
        this.Variavel = Variavel;
        this.Item = Item;
        this.PrevisoProcessado = PrevisoProcessado;
        this.Contratado = Contratado;
        this.Instalado = Instalado;
        this.Procesado = Procesado;
        this.Taxa = Taxa;
    }

    public String getDataIbope() {
        return DataIbope;
    }

    public void setDataIbope(String DataIbope) {
        this.DataIbope = DataIbope;
    }

    public String getRegiao() {
        return Regiao;
    }

    public void setRegiao(String Regiao) {
        this.Regiao = Regiao;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public int getCodPraca() {
        return CodPraca;
    }

    public void setCodPraca(int CodPraca) {
        this.CodPraca = CodPraca;
    }

    public String getVariavel() {
        return Variavel;
    }

    public void setVariavel(String Variavel) {
        this.Variavel = Variavel;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public int getPrevisoProcessado() {
        return PrevisoProcessado;
    }

    public void setPrevisoProcessado(int PrevisoProcessado) {
        this.PrevisoProcessado = PrevisoProcessado;
    }

    public int getContratado() {
        return Contratado;
    }

    public void setContratado(int Contratado) {
        this.Contratado = Contratado;
    }

    public int getInstalado() {
        return Instalado;
    }

    public void setInstalado(int Instalado) {
        this.Instalado = Instalado;
    }

    public int getProcesado() {
        return Procesado;
    }

    public void setProcesado(int Procesado) {
        this.Procesado = Procesado;
    }

    public float getTaxa() {
        return Taxa;
    }

    public void setTaxa(float Taxa) {
        this.Taxa = Taxa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrentPowerBiModel{DataIbope=").append(DataIbope);
        sb.append(", Regiao=").append(Regiao);
        sb.append(", Sigla=").append(Sigla);
        sb.append(", CodPraca=").append(CodPraca);
        sb.append(", Variavel=").append(Variavel);
        sb.append(", Item=").append(Item);
        sb.append(", PrevisoProcessado=").append(PrevisoProcessado);
        sb.append(", Contratado=").append(Contratado);
        sb.append(", Instalado=").append(Instalado);
        sb.append(", Procesado=").append(Procesado);
        sb.append(", Taxa=").append(Taxa);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
}
