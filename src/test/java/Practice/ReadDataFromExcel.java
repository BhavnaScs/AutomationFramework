package Practice;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		//step1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
         
		//step2: create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3: get control of sheet
		Sheet sh = wb.getSheet("contacts");
		
		//step4 : get control of Row
		Row rw = sh.getRow(4);
		
		//step5: get  control of cell
		Cell ce = rw.getCell(2);
		
		//step 6: read the data from 
		String value = ce.getStringCellValue();
        System.out.println(value);
	}

}
