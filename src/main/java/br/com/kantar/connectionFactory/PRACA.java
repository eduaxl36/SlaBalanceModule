/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.kantar.connectionFactory;

/**
 *
 * @author Eduardo.Fernando
 */
public enum PRACA {
    
    CAM(103,"CAM","Campinas"),
    GOI(106,"GOI","Goiania"),
    BHZ(108,"BHZ","Belo Horizonte"),
    GRJ(109,"GRJ","Rio de Janeiro"),
    GSP(110,"GSP","São Paulo"),
    DFE(133,"DFE","Distrito Federal"),
    CTA(240,"CTA","Curitiba"),
    FLO(241,"FLO","Florianopolis"),
    POA(242,"POA","Porto Alegre"),
    FOR(357,"FOR","Fortaleza"),
    REC(359,"REC","Recife"),
    SAL(360,"SAL","Salvador"),
    GBE(465,"GBE","Grande Belem"),
    MAN(466,"MAN","Manaus"),
    GVI(985,"GVI","Grande Vitoria");

    private PRACA(int Codigo,String Desc,String Regiao) {
        this.Codigo = Codigo;
        this.Descr = Desc;
        this.Regiao=Regiao;
    }
    
    private int Codigo;
    private String Descr;
    private String Regiao;

    @Override
    public String toString() {
        return "PRACA{" + "Codigo=" + Codigo + ", Descr=" + Descr + '}';
    }

    public static PRACA getCAM() {
        return CAM;
    }

    public static PRACA getGOI() {
        return GOI;
    }

    public static PRACA getBHZ() {
        return BHZ;
    }

    public static PRACA getGRJ() {
        return GRJ;
    }

    public static PRACA getGSP() {
        return GSP;
    }

    public static PRACA getDFE() {
        return DFE;
    }

    public static PRACA getCTA() {
        return CTA;
    }

    public static PRACA getFLO() {
        return FLO;
    }

    public static PRACA getPOA() {
        return POA;
    }

    public static PRACA getFOR() {
        return FOR;
    }

    public static PRACA getREC() {
        return REC;
    }

    public static PRACA getSAL() {
        return SAL;
    }

    public static PRACA getGBE() {
        return GBE;
    }

    public static PRACA getMAN() {
        return MAN;
    }

    public static PRACA getGVI() {
        return GVI;
    }

    public int getCodigo() {
        return Codigo;
    }

    public String getDescr() {
        return Descr;
    }

   
    
    public static String obterPraca(int Codigo){
    
        PRACA[]Pracas = PRACA.values();
        
        for(PRACA Praca:Pracas){
        
        if(Praca.getCodigo()==Codigo){
        
        
        return Praca.getDescr();
        
        }
        
        }
    
    return null;
    
    }
    
    
     public static String obterRegiao(int Codigo){
    
        PRACA[]Pracas = PRACA.values();
        
        for(PRACA Praca:Pracas){
        
        if(Praca.getCodigo()==Codigo){
        
        
        return Praca.getRegiao();
        
        }
        
        }
    
    return null;
    
    }

    public String getRegiao() {
        return Regiao;
    }

    public void setRegiao(String Regiao) {
        this.Regiao = Regiao;
    }
    
    
    
}
