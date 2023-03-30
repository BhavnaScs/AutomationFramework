package vtiger.GenericUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to excel file
 * @author Bhavna
 *
 */



public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet based on row and cell value
	 * @param sheet
	 * @param row
	 * @param cel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromExcel(String sheet, int row, int cel) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(row);
		Cell ce = rw.getCell(cel);
		String value = ce.getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method will get count of row
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
		
	}
	/**
	 * This method will write the data into the excel sheet.
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int cel, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Row rw = wb.getSheet(sheet).getRow(row);
		rw.createCell(cel).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantUtility.ExcelFilePath);
		wb.write(fos);
		System.out.println(value+" --> data added");
		wb.close();
	}
	
	
	/**
	 * This method  will load the data from data provider
	 * @param Sheetname
	 * @return
	 * @throws IOException,EncryptedDocumentException
	 */
	public Object[][] ReadMultipleData(String Sheetname) throws EncryptedDocumentException,IOException
	{
	    FileInputStream  fis= new FileInputStream(IConstantUtility.ExcelFilePath);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb .getSheet(Sheetname);
	    int lastRow = sh.getLastRowNum();
	    int lastcel = sh.getRow(0).getLastCellNum();
	    
	    Object[][]data = new Object[lastRow][lastcel];
	    
	    for(int i=0 ; i<lastcel;i++)
	    {
	    	for(int j =0;j<lastcel;j++)
	    	{
	    		data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
	    		
	    	}
	    }
	    return data;
	}
	
	
}