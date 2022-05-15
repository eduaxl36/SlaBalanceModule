/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.kantar.model.abs;

/**
 *
 * @author eduax
 */
public enum DESCRICOES {
    

    CABO("TV PAGA","TEM","NAO TEM"),
    TELEVISOR("QTD TVS","1 TV","2+ TVS"),
    PRESENCA_CRIANCA("PRESENCA DE CRIANCA","TEM","NAO TEM"),
    TAMANHO_FAMILIA("TAMANHO DA FAMILIA","1-2 pessoas","3-4 pessoas","5 E+ pessoas"),
    IDADE_DC("15-34 anos","35-49 anos","50 E+ anos"),
    NSE("AB","C1","C2","DE");
   
    private final Object [] Itens;

    DESCRICOES(Object... Itens) {
        this.Itens = Itens;
    }

    public Object[] getItens() {
        return Itens;
    }

    
    
    
    
}
