package testcase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void main(String[] args) throws IOException {
		File excel_file = new File("excel_file.xlsx");
		FileOutputStream fout = new FileOutputStream(excel_file);
		
		XSSFWorkbook book = new XSSFWorkbook(); // create workbook
		XSSFSheet sheet =  book.createSheet("Test Data Sheet"); // create sheet
		for(int i=0; i <4; i++){
			XSSFRow row = sheet.createRow(i); // create the row
			for(int j=0; j<4;j++){
				XSSFCell cel = row.createCell(j); // create the column
				cel.setCellValue("Data_"+j); // set the cel value
			}
		}
		book.write(fout);
		fout.close();
		System.out.println("file created");
	}

}
