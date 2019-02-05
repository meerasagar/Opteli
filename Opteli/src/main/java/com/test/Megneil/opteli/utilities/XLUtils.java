package com.test.Megneil.opteli.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

public static FileInputStream fis;
	
	public static XSSFWorkbook wb;
	
	public static XSSFSheet ws;
	
	public static XSSFRow row;
	
	public static XSSFCell cell;
	
	
	
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		fis = new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fis);
		
		ws = wb.getSheet(xlsheet);
		
		int rowcount = ws.getLastRowNum();
		
		wb.close();
		
		fis.close();
		
		return rowcount;
		
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fis = new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fis);
		
		ws = wb.getSheet(xlsheet);
		
		XSSFRow row = ws.getRow(rownum);
		
		int cellNum = row.getLastCellNum();
		
		wb.close();
		
		fis.close();
		
		return cellNum;
			
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum,int colnum) throws IOException
	{
		fis = new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fis);
		
		ws = wb.getSheet(xlsheet);
		
		row = ws.getRow(rownum);
		
		cell =row.getCell(colnum);
		
	    String data;
	    try{
	    	
	    	DataFormatter formater = new DataFormatter();
	    	String cellData = formater.formatCellValue(cell);
	    	return cellData;
	    }
	    catch(Exception e)
	    {
	    	data ="";
	    }
		
		wb.close();
		
		fis.close();
		
		return data;
		
	}
	public static void setCellData(String xlfile, String xlsheet, int rownum,int colnum, String data) throws IOException
	{
		fis = new FileInputStream(xlfile);
		
		wb = new XSSFWorkbook(fis);
		
		ws = wb.getSheet(xlsheet);
		
		row = ws.getRow(rownum);
		
		cell =row.createCell(colnum);
		
		cell.setCellValue(data);
		
		FileOutputStream fo = new FileOutputStream(xlfile);
		
		wb.write(fo);
		
		wb.close();
		
		fis.close();
		fo.close();
		
	}
}
