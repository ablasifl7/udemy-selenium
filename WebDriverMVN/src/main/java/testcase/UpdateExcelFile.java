package testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdateExcelFile {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		String file = (new File("")).getAbsolutePath()+"\\excel_file.xlsx";
		File excel_file = new File(file);
		FileInputStream fin = new FileInputStream(excel_file);
		
		
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sheet = book.getSheet("Test Data Sheet");
		
		XSSFRow row = sheet.getRow(0);
		XSSFCell cel = row.getCell(0);
		cel.setCellValue("Modified Value");
	
		XSSFRow row2 = sheet.createRow(4);
		XSSFCell cel2 = row2.createCell(0);
		cel2.setCellValue("Newly added cell");
		
		fin.close();
		
		FileOutputStream fout = new FileOutputStream(excel_file );
		
		book.write(fout);
		fout.close();
		System.out.println("Updata File");
		
	}

}
