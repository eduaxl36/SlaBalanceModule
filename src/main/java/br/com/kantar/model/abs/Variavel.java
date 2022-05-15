/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.model.abs;

/**
 *
 * @author eduax
 */
public abstract class Variavel {
    
    private DESCRICOES Descricao;

    public Variavel() {
    }

    public Variavel(DESCRICOES Descricao) {
        this.Descricao = Descricao;
    }

    public DESCRICOES getDescricao() {
        return Descricao;
    }
    
   
}
