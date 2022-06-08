/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.balancecolect;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;

/**
 *
 * @author Eduardo.Fernando
 */
public class NewClass {
    
    public static void main(String[] args) {
        
        
                LocalDate data = LocalDate.parse("2023-01-16");
        	
                LocalDateTime dt = data.atTime(10, 30);
		
                ZonedDateTime Zn = dt.atZone(ZoneId.of("America/New_York"));
               
                int week = Zn.get ( IsoFields.WEEK_OF_WEEK_BASED_YEAR );
               
                System.out.println(week);
                
                System.out.println(dt.getDayOfWeek().getValue());
        
        
    }
    
    
}
