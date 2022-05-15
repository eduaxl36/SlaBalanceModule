/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.dao.cf;

import br.com.kantar.model.cf.Configuracoes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduax
 */
public class ConfiguracoesDao {
    
private File ArquivoPrevisto;
private Configuracoes Configuracao;
    
public ConfiguracoesDao(){

ArquivoPrevisto = new File("CF/previstoBalance.csv");

}
    

public Configuracoes Configuracao(String[]InstanciasLinha){

int Ano = Integer.parseInt(InstanciasLinha[0]);
int CodPraca = Integer.parseInt(InstanciasLinha[1]);
String Item = InstanciasLinha[2];
int Valor = Integer.parseInt(InstanciasLinha[3]);

Configuracao = new Configuracoes(Ano, CodPraca, Item, Valor);

return Configuracao;
   
} 




public List<Configuracoes> Configuracoes() throws FileNotFoundException, IOException{

List<Configuracoes>Configuracoes = new ArrayList<>();

BufferedReader Leitor = new BufferedReader(new FileReader(this.ArquivoPrevisto));
String Linha = Leitor.readLine();

while(Linha!=null)
{

    
 String [] ValoresLinha = Linha.split(";");
 Configuracoes.add(Configuracao(ValoresLinha));
 
   
 Linha = Leitor.readLine();
}


return Configuracoes;
}




    public static void main(String[] args) throws IOException {
        
        
        System.out.println(new ConfiguracoesDao().Configuracoes());
        
    }



    
}
