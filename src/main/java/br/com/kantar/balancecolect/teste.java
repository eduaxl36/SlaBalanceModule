/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.balancecolect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author Eduardo.Fernando
 */
public class teste {

    private final int IndexColuna = 33;
    private final int IndexLinha = 35;
    private String CaminhoProduto;
    private String Praca;

        public teste(String CaminhoProduto) {
        this.CaminhoProduto = CaminhoProduto;
   
    }
    public teste(String CaminhoProduto, String Praca) {
        this.CaminhoProduto = CaminhoProduto;
        this.Praca = Praca;
    }

    public teste() {
    }

    public String captarLinhasGerais() throws FileNotFoundException, IOException {

        FileInputStream ArquivoExcel = new FileInputStream(this.CaminhoProduto);
        StringBuilder ExcelEmTexto;

        try ( XSSFWorkbook ConfExcel = new XSSFWorkbook(ArquivoExcel)) {

            XSSFSheet sheet = ConfExcel.getSheet(this.Praca);
            ExcelEmTexto = new StringBuilder();

            for (int r = 0; r <= IndexLinha; r++) {

                XSSFRow row = sheet.getRow(r);

                for (int c = 0; c < IndexColuna; c++) {

                    if (row != null) {

                        XSSFCell cell = row.getCell(c);

                        if (cell != null) {

                            switch (cell.getCellType()) {

                                case XSSFCell.CELL_TYPE_STRING:

                                  
                                    
                                    ExcelEmTexto.append(cell.getStringCellValue());
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:


                                   
                                    ExcelEmTexto.append(cell.getRawValue());
                                    break;
                                case XSSFCell.CELL_TYPE_BOOLEAN:

                                    ExcelEmTexto.append(cell.getBooleanCellValue());
                                    break;
                                case XSSFCell.CELL_TYPE_FORMULA:

                                    if (cell != null) {

                                        ExcelEmTexto.append((int) Double.parseDouble(""+cell.getNumericCellValue()));

                                    }

                                    break;

                            }

                        }

                        ExcelEmTexto.append(";");

                    }

                }
                ExcelEmTexto.append("\n");
            }
        }

        return ExcelEmTexto.toString();
    }

    public String FiltrarVariaveis() throws IOException {

        String[] valores = captarLinhasGerais().split("\n");
        StringBuilder LinhasExcel = new StringBuilder();

        for (String x : valores) {

            if (x.matches("[Cc]lasse.*")) {

                LinhasExcel.append(x).append("\n");

            }

            if (x.matches(".*[Pp]aga.*")) {

                LinhasExcel.append(x).append("\n");

            }

            if (x.matches(".*[Cc]ria.*")) {

                LinhasExcel.append(x).append("\n");

            }

            if (x.matches(".*[Ii]dade.*")) {

                LinhasExcel.append(x).append("\n");

            }

            if (x.matches(".*[Tt]am [Ff]a.*")) {

                LinhasExcel.append(x).append("\n");

            }

            if (x.matches(".*[Tt][Vv][Ss].*")) {

                LinhasExcel.append(x).append("\n");

            }

        }

        return LinhasExcel.toString();
    }

    public Map<Integer, Object[]> gerarMapaComDados() throws IOException {

        String ValoresBalance[] = FiltrarVariaveis().split("\n");

        //This data needs to be written (Object[])
        Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();

        data.put(1, new Object[]{"VAR", "BL", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});

        int Contador = 2;

        for (String x : ValoresBalance) {

            String[] g = x.split(";");
 
            data.put(Contador, new Object[]{g[0], g[1], g[2], g[3], g[4], g[5], g[6], g[7], g[8], g[9], g[10], g[11], g[12], g[13], g[14], g[15], g[16], g[17], g[18], g[19], g[20], g[21], g[22], g[23], g[24], g[25], g[26], g[27], g[28], g[29], g[30], g[31],g[32]});

            Contador++;

        }

        return data;

    }

    public void GravarExcel(XSSFWorkbook workbook) throws IOException {

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet(this.Praca);

        //Iterate over data and write to sheet
        Set<Integer> keyset = gerarMapaComDados().keySet();
        int rownum = 0;
        for (Integer key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = gerarMapaComDados().get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }

    }

    
    
    public void gerarPlanilhaRotacionalPracas() throws IOException{
    
     
        List Pracas = Arrays.asList("CAM","GOI","BHZ","GRJ","GSP","DFE","CTA","FLO","POA","FOR","REC","SAL","GBE","MAN","GVI");
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        for(Object Praca:Pracas){
        
         
        new teste(this.CaminhoProduto, (String) Praca).GravarExcel(workbook);
        
        
        }
        
 
        
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("c:\\teste\\howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        new teste("\\\\bribfs01sp\\MD_Groups\\Audiencia Televisao\\RAD\\Campo\\999 (BRA)\\Processamento dos Indicadores\\Indicadores 2022\\06_Junho\\Balance\\Balance Amostral - Contratado - diário_202206.xlsx").gerarPlanilhaRotacionalPracas();
        
        
//        XSSFWorkbook workbook = new XSSFWorkbook();
//
//        new teste("\\\\bribfs01sp\\MD_Groups\\Audiencia Televisao\\RAD\\Campo\\999 (BRA)\\Processamento dos Indicadores\\Indicadores 2022\\06_Junho\\Balance\\Balance Amostral - Contratado - diário_202206.xlsx", "CAM").GravarExcel(workbook);
//        new teste("\\\\bribfs01sp\\MD_Groups\\Audiencia Televisao\\RAD\\Campo\\999 (BRA)\\Processamento dos Indicadores\\Indicadores 2022\\06_Junho\\Balance\\Balance Amostral - Contratado - diário_202206.xlsx", "GOI").GravarExcel(workbook);
//
//        try {
//            //Write the workbook in file system
//            FileOutputStream out = new FileOutputStream(new File("c:\\teste\\howtodoinjava_demo.xlsx"));
//            workbook.write(out);
//            out.close();
//            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        System.out.println(new teste("\\\\bribfs01sp\\MD_Groups\\Audiencia Televisao\\RAD\\Campo\\999 (BRA)\\Processamento dos Indicadores\\Indicadores 2022\\06_Junho\\Balance\\Balance Amostral - Contratado - diário_202206.xlsx", "CAM").teste());       
//        
//        System.out.println(new teste().gerarLinhasGerais("\\\\bribfs01sp\\MD_Groups\\Audiencia Televisao\\RAD\\Campo\\999 (BRA)\\Processamento dos Indicadores\\Indicadores 2022\\06_Junho\\Balance\\Balance Amostral - Contratado - diário_202206.xlsx", "CAM"));
////    
//    
    }

}
