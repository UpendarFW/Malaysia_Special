package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel_Utility {

	public String getExcelData(String SHEETNAME,int ROWNUMBER,int CELLNUMBER) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstant_Utility.excelFile);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(SHEETNAME);
		Row r=sh.getRow(ROWNUMBER);
		Cell c=r.getCell(CELLNUMBER);
		String value=c.getStringCellValue();
		return value;
	}
	
	public void WriteDatainExcel(String SHEETNAME,int ROWNUMBER,int CELLNUMBER,String CELLVALUE) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstant_Utility.excelFile);
        Workbook book=WorkbookFactory.create(fis);
        Sheet sh=book.getSheet(SHEETNAME);
        Row r=sh.createRow(ROWNUMBER);
        Cell c=r.createCell(CELLNUMBER);
        c.setCellValue(CELLVALUE);
        
        FileOutputStream fos=new FileOutputStream(IConstant_Utility.excelFile);
        book.write(fos);
        System.out.println(CELLVALUE+"---->"+"Added sucessfully");
        
	}
	
	public Object[][] readMultipledata(String SHEETNAME,int ROWNUMBER,int CELLNUMBER) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstant_Utility.excelFile);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(SHEETNAME);
		int lastRow =sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}
}
