package frameworkUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxReader {
	XSSFWorkbook workbook;
	public XlsxReader(String path) throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		workbook = new XSSFWorkbook(new FileInputStream(path));
	}
	public String getData(String columnName) {
		return getData(FrameworkParameters.currentTestdataSheet, FrameworkParameters.currentTestCaseName, columnName);
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 */
	
	public String getData(String sheetName , int rowNum , int colNum) {
		XSSFCell cell = workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum);
		if(cell.getCellType().equals(CellType.NUMERIC)) {

			if(DateUtil.isCellDateFormatted(cell)) {
			
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				return sdf.format(cell.getDateCellValue());
				
			}
			return cell.getNumericCellValue()+"";
		}else if(cell.getCellType().equals(CellType.STRING)) {
			return cell.getStringCellValue();
		}
		
		return null;
	}
	/**
	 * 
	 * @param sheetName
	 * @param colName
	 * @param rowNum
	 * @return
	 */
	
	public String getData(String sheetName , String colName , int rowNum ) {
		return getData(sheetName, rowNum, getColNumberFromColName(sheetName, colName));
	}
	/**
	 * 
	 * @param sheetName
	 * @param testCaseName
	 * @param colName
	 * @return
	 */
	public String getData(String sheetName , String testCaseName , String colName) {
		return getData(sheetName, colName, getRowNumberFromTestCaseName(sheetName, testCaseName));
		
	}
	private int getColumnCount(String sheetName) {
		return workbook.getSheet(sheetName).getRow(0).getLastCellNum();
	}
	private int getRowCount(String sheetName) {
		return workbook.getSheet(sheetName).getLastRowNum();
	}
	/**
	 * 
	 */
	
	private int getColNumberFromColName(String sheetName , String colName) {
		XSSFRow row = workbook.getSheet(sheetName).getRow(0);
		for (int i = 0; i <= getColumnCount(sheetName); i++) {
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				return i;
			}
		}
		return -1;
	}
	private int getRowNumberFromTestCaseName(String sheetName , String testCaseName) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		for (int i = 0; i <=getRowCount(sheetName); i++) {
			if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equals(testCaseName.trim())) {

				return i;
			}
			
		}
		return -1;
	}
	
	
	

}
