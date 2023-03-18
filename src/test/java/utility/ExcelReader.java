package utility;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import base.LogHandler;

public class ExcelReader {
	public String path;
	public String sheetName;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public Logger log = LogHandler.log;
	
	
	public ExcelReader(String path, String sheetName) {
		this.path = path;
		this.sheetName = sheetName;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook();
			sheet = workbook.getSheet("cred");
			
		}catch(Exception e) {
			log.debug("Couldn't load the excel file with name and path specified "+ e);
		}
		
	}
	
	/*
	 * returns the rows count in a sheet based on sheet name
	 */
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if(index == -1) {
			log.debug("Can't find the sheet with name specified"+ sheetName);
			return 0;
		}
		else {
			sheet = workbook.getSheet(sheetName);
			int num = sheet.getLastRowNum() + 1;
			log.debug(sheetName+" contains "+num+" of rows");
			return  num;
		}
	}
	
	/*
	 * returns the rows count in a sheet based on sheet index 
	 */
	public int getRowCount(int index) {
		if(index < 1) {
			log.debug("Rows can't be negative");
			return 0;
		}else {
			sheet = workbook.getSheetAt(index);
			int num = sheet.getLastRowNum() + 1;
			log.debug(workbook.getSheetName(index)+" contains "+num+" of rows");
			return num;
		}
	}
	/*
	 * return the columns in a sheet based on sheet index
	 */
	
	public int getColumnCount(String sheetName) {
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
}
