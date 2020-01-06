package keyword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.*;

import helper.ButtonHelper;
import helper.ComboBoxHelper;
import helper.GenericHelper;
import helper.LinkHelper;
import helper.TextBoxHelper;
import customeException.KeyWordNotFoundException;

public class KeywordStepDfn {
	
	private static XSSFWorkbook book;
	private static FormulaEvaluator evaluator;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	private static FileInputStream readExcel;
	
	public static void performactionWithKeyword(String aFilePath,String bSheetName) throws IOException{
		try {
			readExcel = new FileInputStream(new File(aFilePath));
			book = new XSSFWorkbook(readExcel);
			sheet = book.getSheet(bSheetName);
			evaluator = book.getCreationHelper().createFormulaEvaluator();
			
			for(int i = 2 ; i <= sheet.getLastRowNum(); i++ ){
				row = sheet.getRow(i);
				switch (row.getCell(0).getStringCellValue()) {
				case "Click":
					LinkHelper.clickUsingKeyword(row);
					break;
				case "TextBox":
					TextBoxHelper.typeUsingKeyword(row,evaluator );
					break;
				case "Radio Button":
					ButtonHelper.clickUsingKeyword(row);
					break;
				case "Button click":
					ButtonHelper.clickUsingKeyword(row);
					break;
				case "Select":
					ComboBoxHelper.selectUsingKeyword(row);
					break;
				case "WaitForEle":
					GenericHelper.waitUsingKeyword(row);
					break;
				default:
					throw new KeyWordNotFoundException(row.getCell(0)
							.getStringCellValue()+" : was not found");
	
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(book != null){
				book = null;
			}
			if(readExcel != null){
				readExcel.close();
				readExcel = null;
			}
		}
	}

}
