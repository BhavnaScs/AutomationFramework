package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

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
				
				//step6: set the value to the cell
				ce.setCellValue("wasa");
				
				//step 7: open the document in write mode
				FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
                 
				//step 8: write the data
				wb.write(fos);
				System.out.println("data added");
	            wb.close();
	
	}

}
