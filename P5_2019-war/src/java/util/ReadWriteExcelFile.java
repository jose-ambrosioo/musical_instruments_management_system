/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 *
 * @author julio
 */
public class ReadWriteExcelFile {
    
        private  Object[][] matrizData;
        
        public  void readXLSFile(int numberSheet,String fileName, Object objecto)
	{
             try
             {
		InputStream ExcelFileToRead = new FileInputStream(fileName);
            
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet = wb.getSheetAt(numberSheet);
		HSSFRow row; 
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();
                
                int linhas = -1, colunas = -1;
                matrizData = new String[sheet.getPhysicalNumberOfRows()-1][objecto.getClass().getDeclaredFields().length];
                while (rows.hasNext())
		{
                       
                        row = (HSSFRow) rows.next();
			Iterator cells  =  row.cellIterator();
                        System.out.println("--------------------------------------"); 
			while (cells.hasNext())
			{
                            cell = (HSSFCell) cells.next();

                            if(linhas >= 0)
                            {
                                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
                                {
                                    matrizData[linhas][colunas] =  cell.getStringCellValue();
                                    System.out.print("nome : " + cell.getStringCellValue() + "\n");   
                                }
                                else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                                {
                                   matrizData[linhas][colunas] = String.valueOf(cell.getNumericCellValue());
                                   System.out.print("Id : " + cell.getNumericCellValue() +  "\n");   
                                }
                             }
                            ++colunas;
                        }
                        colunas = 0;
                        ++linhas;                 
		}
                System.err.println("Linhas : " + linhas);
             }
            catch(IOException ex)
            {
                System.err.println("Nao foi possivel fazer a leitura : " + ex.getMessage());
            }
	}

 
    public  Object[][] getMatrizData() 
    {
        return matrizData;
    }

    public  void setMatrizData(Object[][] matrizData) 
    {
       this.matrizData = matrizData;
    }
    
    public  int converteNumericoInteiro(String valor)
    {
        String str = valor.substring(0,valor.length()- 2);
        return Integer.parseInt(str);
    }
    
    
    public String substring(String str, String arg)
    {
       if(str.endsWith(arg))
       {
           return str.substring(0, str.length()- arg.length());
       }
       return str;  
    }
    
    public String gerarCodigoFK(String pk)
    {       
        String str = pk.substring(0,pk.lastIndexOf(".")).trim();
        System.err.println("string : " + str);
        return str;
    }
}