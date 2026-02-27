package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {

	static FileInputStream f;//In-built class used to read files
	static XSSFWorkbook wb;//In-built class occurring in apache to read details from workbook
	static XSSFSheet sh;//to read details from the sheet
	
	public static String getStringData(int a,int b, String sheet) throws IOException 
	{
		f=new FileInputStream(Constant.TESTDATA);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);//method used to get details from the sheet
		XSSFRow r =sh.getRow(a);// used for Row
		XSSFCell c = r.getCell(b);//used for cell
		return c.getStringCellValue();//used to get string value from the cell
	}
	
	public static String getIntegerData(int a,int b, String sheet) throws IOException 
	{
		f=new FileInputStream(Constant.TESTDATA);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);//method used to get details from the sheet
		XSSFRow r =sh.getRow(a);// used for Row
		XSSFCell c = r.getCell(b);//used for cell
		int x=(int)c.getNumericCellValue();
		return String.valueOf(x);
		
	}

}
