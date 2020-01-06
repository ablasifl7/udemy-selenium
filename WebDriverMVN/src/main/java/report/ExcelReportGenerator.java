package report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExcelReportGenerator {
	
	
	@SuppressWarnings("resource")
	public void generateExcelReport(String destFileName) throws ParserConfigurationException, SAXException, IOException {
		String path =  ExcelReportGenerator.class.getClassLoader().getResource("./").getPath();
		path = path.replace("/target/classes/", "/src/main/java/").replace("%c3%ad", "í").replace("%20-%20", " - ");
		File xmlFile = new File(path);
		xmlFile = new File(xmlFile.getParentFile().getParentFile()
				.getParentFile()+"/test-output/testng-results.xml");
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = fact.newDocumentBuilder();
		Document doc = build.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFCellStyle pass = book.createCellStyle();
		XSSFCellStyle fail = book.createCellStyle();
		
		NodeList test_list = doc.getElementsByTagName("test");
		
		for(int i = 0; i < test_list.getLength() ; i++ ){
			int r = 0;
			Node test_node = test_list.item(i);
			String test_name = ((Element)test_node).getAttribute("name");
			XSSFSheet sheet = book.createSheet(test_name);
			NodeList class_list = ((Element)test_node).getElementsByTagName("class");
		
			for(int j=0 ; j < class_list.getLength(); j++){
				Node class_node = class_list.item(j);
				String class_name = ((Element)class_node).getAttribute("name");
				NodeList test_method_list = ((Element)class_node).getElementsByTagName("test-method");
				
				for(int k=0 ; k < test_method_list.getLength(); k++){
					Node test_method_node = test_method_list.item(k);
					String test_method_name = ((Element)test_method_node).getAttribute("name");
					String test_method_status = ((Element)test_method_node).getAttribute("status");
					
					XSSFRow row = sheet.createRow(r++);
					XSSFCell cel_name = row.createCell(0);
					cel_name.setCellValue(class_name+"."+test_method_name);
					
					XSSFCell cel_status = row.createCell(1);
					cel_status.setCellValue(test_method_status);
					
					XSSFCell cel_exp;
					String exp_msg;
					
				
					fail.setFillForegroundColor(IndexedColors.RED.getIndex());
					pass.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					//fail.setFillBackgroundColor(HSSFColor.RED.index);
					//pass.setFillBackgroundColor(HSSFColor.GREEN.index);
					
					fail.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
					pass.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
					//fail.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
					//pass.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
					
					if("fail".equalsIgnoreCase(test_method_status)){
						cel_status.setCellStyle(fail);
					}else{
						cel_status.setCellStyle(pass);
					}
					
					
					if("fail".equalsIgnoreCase(test_method_status)){
						NodeList exc_list = ((Element)test_method_node).getElementsByTagName("exception");
						Node exp_node = exc_list.item(0);
						exp_msg = ((Element)exp_node).getAttribute("class");
					
						cel_exp = row.createCell(2);
						cel_exp.setCellValue(exp_msg);
						
					}
					
					
				}
			}
		
		}
		FileOutputStream fout = new FileOutputStream(path+"report/"+destFileName);
		book.write(fout);
		fout.close();
		System.out.println("Report Generated");
		
		
		
		
	}

	public static void main(String[] args) {
		try {
			new ExcelReportGenerator().generateExcelReport("report.xlsx");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
