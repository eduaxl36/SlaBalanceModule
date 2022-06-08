/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.balancecolect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author Eduardo.Fernando
 */
public class teste {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileInputStream fs = new FileInputStream("\\\\bribfs01sp\\MD_Groups\\Audiencia Televisao\\RAD\\Campo\\999 (BRA)\\Processamento dos Indicadores\\Indicadores 2022\\04_Abril\\Balance\\Balance Amostral - Contratado - diário_202204.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fs);

        XSSFSheet sheet = workbook.getSheet("CAM");

        int rows =54;
        int cols = 33;

        for (int r = 0; r <= rows; r++) {

            XSSFRow row = sheet.getRow(r);

            for (int c = 0; c < cols; c++) {

                
                if(row!=null){
                
                
                
                
                
                
                        XSSFCell cell = row.getCell(c);

                
                if(cell!=null){
                
                
                     switch (cell.getCellType()) {

                    case XSSFCell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_FORMULA:
                        
                        if(cell!=null){
                        
                         System.out.print(cell.getNumericCellValue());
                        
                        }
                        
                       
                        break;

                }           
                
                
                
                }
                
               System.out.print(";");
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                }
                
                
        

            }
   System.out.println("");
        }

        workbook.close();

    }

}
