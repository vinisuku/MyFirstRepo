package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 200;
	public static long IMPLICIT_WAIT = 10;
	public static String TestData_Sheet_Path = "D:\\desktop backup\\workspace\\MyOwnPomProject\\src\\main\\java\\com\\crm\\qa\\testdata\\MyOwnPomTestData.xlsx";
	static Workbook wb;
	static Sheet sheet;
	
	
	public void swtichToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		try{
			file = new FileInputStream(TestData_Sheet_Path);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}	
		try{
			wb = WorkbookFactory.create(file);
		}catch(InvalidFormatException e1){
			e1.printStackTrace();
		}catch(IOException e2){
			e2.printStackTrace();
		}
		 
		Sheet sheet= wb.getSheet(sheetName);
		Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i=0; i<sheet.getLastRowNum();i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).getStringCellValue();
			}
		}
		
		return data;
		
		}
	}	




