package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.LogHandler;

public class ExcelReader {
	
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	
	public ExcelReader(String path) {
		
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			System.out.println("Unable to find data");
			e.printStackTrace();
		} 
		
	}
	
	
	// returns the row count in a sheet
	public int getRowCount(String sheetName){
		try {
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return 0;
			else{
			sheet = workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
			}
		}catch(Exception e) {
			System.out.println("Unable to egt rows");
			e.printStackTrace();
		}
		return 0;
		
	}
	
	/*
	 * returns the rows count in a sheet based on sheet index 
	 */
//	public int getRowCount(int index) {
//		if(index < 1) {
//			log.debug("Rows can't be negative");
//			return 0;
//		}else {
//			sheet = workbook.getSheetAt(index);
//			int num = sheet.getLastRowNum() + 1;
//			log.debug(workbook.getSheetName(index)+" contains "+num+" of rows");
//			return num;
//		}
//	}
	/*
	 * return the columns in a sheet based on sheet index
	 */
	
//	public int getColumnCount(String sheetName) {
//		return 1;
//	}
	
	
	
	
	
	
	
	
	
	
	
}
