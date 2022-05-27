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
    
    CAM(103,"CAM"),
    GOI(106,"GOI"),
    BHZ(108,"BHZ"),
    GRJ(109,"GRJ"),
    GSP(110,"GSP"),
    DFE(133,"DFE"),
    CTA(240,"CTA"),
    FLO(241,"FLO"),
    POA(242,"POA"),
    FOR(357,"FOR"),
    REC(359,"REC"),
    SAL(360,"SAL"),
    GBE(465,"GBE"),
    MAN(466,"MAN"),
    GVI(985,"GVI");

    private PRACA(int Codigo,String Desc) {
        this.Codigo = Codigo;
        this.Descr = Desc;
    }
    
    private int Codigo;
    private String Descr;

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
    
    
    
}
