/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.kantar.connectionFactory;

/**
 *
 * @author eduax
 */
public enum TIPOS_ENTREGAS {
    
    INSTALADO("C:\\Users\\eduardo.fernando\\Desktop\\Projetos\\BalanceColect\\SlaBalanceModule\\FONTE\\INSTALADO.xlsx"),
    PROCESSADO("C:\\Users\\eduardo.fernando\\Desktop\\Projetos\\BalanceColect\\SlaBalanceModule\\FONTE\\PROCESSADO.xlsx"),
    CONTRATADO("C:\\Users\\eduardo.fernando\\Desktop\\Projetos\\BalanceColect\\SlaBalanceModule\\FONTE\\CONTRATADO.xlsx");
    
    private String CaminhoArquivo;

    private TIPOS_ENTREGAS(String CaminhoArquivo) {
        this.CaminhoArquivo = CaminhoArquivo;
    }

    public String getCaminhoArquivo() {
        return CaminhoArquivo;
    }

    public void setCaminhoArquivo(String CaminhoArquivo) {
        this.CaminhoArquivo = CaminhoArquivo;
    }
    
    
    
    
}
