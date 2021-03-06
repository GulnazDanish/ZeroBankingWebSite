package random;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

public static void main(String[] args) throws IOException {
		
		
		// specify the excel file containing test data
		File src = new File("C:\\BusyQAWorkspace\\ZeroBankingWebSite\\src\\test\\resources\\testData\\testdata.xlsx");
		
		
		// load the excel file
		FileInputStream fis = new FileInputStream(src);
		
		
		// load the workbook from the above excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		
		// load the sheet from above excel workbook
		XSSFSheet sheet = wb.getSheetAt(0);
		
		
		// read the excel data - row 4 and cell 0 ( row and col starts with 0)
		String data = sheet.getRow(2).getCell(0).getStringCellValue();
		System.out.println("Excel data is:  " + data);
		// close the workbook
		wb.close();
	}


}
