/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.com.kantar.balancecolect;

import br.com.kantar.model.variaveis.Televisor;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author eduax
 */
public class BalanceColect {

    public Connection getInstaladosConexao() throws FilloException {

        System.setProperty("ROW", "4");//Table start row
        System.setProperty("COLUMN", "2");//Table start column
        Fillo fillo = new Fillo();
        Connection Conexao = fillo.getConnection("C:\\Users\\eduax\\Desktop\\Projetos\\BalanceColect\\FONTE\\teste.xlsx");
        return Conexao;

    }
    
    
    
    public int obterUltimoDiaMes(int Mes){
    
    
        Calendar DataCalendario = Calendar.getInstance();
        DataCalendario.set(Calendar.MONTH,Mes);
        return DataCalendario.getActualMaximum(Calendar.DAY_OF_MONTH);
        
    }
    
    public List<String>obterListaPracas(){
    
    
        List<String> Pracas = 
                     Arrays.asList
                    ("CAM",
                     "GOI",
                     "BHZ",
                     "GRJ",
                     "GSP",
                     "DFE",
                     "CTA",
                     "POA",
                     "FOR",
                     "REC",
                     "SAL",
                     "GBE",
                     "MAN",
                     "GVI"
                    );
    
        return Pracas;
    
    }
    
    
    
    public static void main(String[] args) throws FilloException {
        
    int ultimodia = new BalanceColect().obterUltimoDiaMes(Calendar.APRIL);
    long Televisor=0;
    List<Long> Televisores1 =new LinkedList<>();
    List<Long> Televisores2 =new LinkedList<>();
    
    
        
        System.setProperty("ROW", "4");//Table start row
System.setProperty("COLUMN", "2");//Table start column
Fillo fillo=new Fillo();
Connection connection=fillo.getConnection("C:\\Users\\eduax\\Desktop\\Projetos\\BalanceColect\\FONTE\\teste.xlsx");

String strQuery="Select * from CAM where BL='TV1'";
Recordset recordset=connection.executeQuery(strQuery);
 
while(recordset.next()){

    
for(int i=1;i<ultimodia;i++){

    
System.out.println(recordset.getField(""+i));
Televisores1.add(Long.parseLong(""+i));


}    
    

}
 

String strQuerytv2="Select * from CAM where BL='TV2'";
Recordset recordsettv2=connection.executeQuery(strQuerytv2);
 
while(recordsettv2.next()){

    
for(int i=1;i<ultimodia;i++){

    
System.out.println(recordsettv2.getField(""+i));
Televisores2.add(Long.parseLong(""+i));


}    
    

}





recordset.close();
connection.close();



    }
}
