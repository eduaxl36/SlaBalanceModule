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
import java.util.stream.Collectors;

/**
 *
 * @author eduax
 */
public class ConfiguracoesDao {
    
private final File ArquivoPrevisto;
private Configuracoes Configuracao;
    
public ConfiguracoesDao(){

ArquivoPrevisto = new File("CF/previstoBalance.csv");

}
    

public Configuracoes Configuracao(String[]InstanciasLinha){

int Ano = Integer.parseInt(InstanciasLinha[0]);
int CodPraca = Integer.parseInt(InstanciasLinha[1]);
String Variavel =  InstanciasLinha[3];
String Item = InstanciasLinha[2];
int Valor = Integer.parseInt(InstanciasLinha[4]);

Configuracao = new Configuracoes(Ano, CodPraca,Variavel,Item, Valor);

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



public long obterPrevisto(String Item,int Praca,int Ano) throws IOException{

   
    
    List<Configuracoes> Configuracao= new ConfiguracoesDao().Configuracoes()
            
            .stream()
            .filter(x->x.getCodPraca()==Praca)
            .filter(x->x.getAno()==Ano)
            .filter(x->x.getItem().equals(Item))
            .collect(Collectors.toList());
            
    
    
     return Configuracao.get(0).getValor();

}



    public static void main(String[] args) throws IOException {
        
        
        System.out.println(new ConfiguracoesDao().obterPrevisto("1TV", 103,2022));
        
    }



    
}
