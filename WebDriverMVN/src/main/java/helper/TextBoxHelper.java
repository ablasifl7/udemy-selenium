package helper;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import antlr.Parser;

public class TextBoxHelper extends StartWebDriver {
	
	private static final Logger oLog = LoggerHelper.getLogger(TextBoxHelper.class);
	
	public static void typeInTextBox(String locator, String value) {
		WebElement ele = getElement(locator);
		ele.sendKeys(value);
		oLog.info(" typeInTextBox : "+locator+", value : "+value);
	}
	public static void clear(String locator) {
		WebElement ele = getElement(locator);
		ele.clear();
		oLog.info(" clear");
	}
	public static void clearXpath(String locator) {
		WebElement ele = getXpathElement(locator);
		ele.clear();
		oLog.info(" clearXpath : "+locator);
	}

	
	public static void typeUsingKeyword(XSSFRow row,FormulaEvaluator evaluator){
		if(evaluator.evaluate(row.getCell(3)).getCellTypeEnum() == CellType.STRING){
			typeInTextBox(	row.getCell(2).getStringCellValue(),
					row.getCell(3).getStringCellValue());
		}else if(evaluator.evaluate(row.getCell(3)).getCellTypeEnum() == CellType.NUMERIC){
			typeInTextBox(	row.getCell(2).getStringCellValue(),
					Double.toString(row.getCell(3).getNumericCellValue()));
		}
			
	}
}
