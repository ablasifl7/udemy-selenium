package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	

	@SuppressWarnings("deprecation")
	public static Object[][] getExcelData(String fileName,String sheetName) throws IOException{
		
		XSSFWorkbook book = new XSSFWorkbook(ReadExcelFile
				.class.getClassLoader()
				.getResourceAsStream("resource\\"+fileName));
		XSSFSheet sheet = book.getSheet(sheetName);
//		for(int row = sheet.getFirstRowNum();row <= sheet.getLastRowNum();row++){
//			XSSFRow r = sheet.getRow(row);
//			for( int col = r.getFirstCellNum();col < r.getLastCellNum();col++){
//				XSSFCell cel = r.getCell(col);
//				System.err.println("Value : "+cel.getStringCellValue());
//			}
//		}
		XSSFRow row = null;
		XSSFCell cel = null;
		Map<String, Object> map = null;
	
		row = sheet.getRow(0);
		String[] header = new String[row.getLastCellNum()];
		Object[][] data = new Object[sheet.getLastRowNum()][1];
		for(int j = row.getFirstCellNum();j < row.getLastCellNum();j++){
			cel = row.getCell(j);
			header[j] = cel.getStringCellValue();
		}
		for(int i = sheet.getFirstRowNum() + 1 ; i <= sheet.getLastRowNum();i++){
			 row = sheet.getRow(i);
			 map = new LinkedHashMap<String , Object>();
				for( int j = row.getFirstCellNum() ; j < row.getLastCellNum();j++){
					cel = row.getCell(j);
					switch (cel.getCellType()) {
					case XSSFCell.CELL_TYPE_STRING:
						map.put(header[j], cel.getStringCellValue());
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						map.put(header[j], cel.getNumericCellValue());
						break;
					default:
						break;
					}
				}
				data[i-1][0] = map;
		}
		return data;
	}
	public static void UpdateToExcel(int colIndex,String srcFile,
			String descFile,String sheetName,ArrayList<String> status) throws IOException {
		String path = ReadExcelFile.class.getClassLoader().getResource("resource/").getPath();
		
		path = path.replace("/target/classes/", "/src/main/java/").replace("%c3%ad", "í").replace("%20-%20", " - ");

		@SuppressWarnings("resource")
		XSSFWorkbook book = new XSSFWorkbook(ReadExcelFile
					.class.getClassLoader()
					.getResourceAsStream("resource/"+srcFile));
		XSSFSheet sheet = book.getSheet(sheetName);
		for( int i = 1 ; i <= sheet.getLastRowNum() ; i++){
				XSSFRow row =  sheet.getRow(i);
				XSSFCell cel = row.createCell(colIndex);
				cel.setCellValue(status.get(i - 1));
		}
		FileOutputStream fout = new FileOutputStream (new File(path + descFile));
			 book.write(fout);
			 fout.close();
	
	}

}
