package config;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelConfig {
    FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet Sheet1;
	ArrayList<String> a = new ArrayList<String>();

	public ExcelConfig(String excelpath) {

		try {
			fis = new FileInputStream(excelpath);

			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	public String getData(int sheetnumber, int rownum, int columnno) throws NullPointerException {

		Sheet1 = wb.getSheetAt(sheetnumber);
		String data = null;
		try {
			XSSFCell c = Sheet1.getRow(rownum).getCell(columnno);
			if (c.getCellTypeEnum() == CellType.STRING) {
				data = Sheet1.getRow(rownum).getCell(columnno).getStringCellValue();
			} else {
				data = NumberToTextConverter.toText(c.getNumericCellValue());
			//	log.info("Cell Data retrive");
			}
		} catch (NullPointerException e) {
			//log.error("Error occured inside getData() method");
			
		}

		return data;
	}

	public int sheetCount() {
		int sheets = wb.getNumberOfSheets();
		//log.info("Sheet number retrieved");
		return sheets;
	}

	public int rowCount(int i) {
		Sheet1 = wb.getSheetAt(i);
		//log.info("");
		int count = Sheet1.getLastRowNum();
		return count;
	}
	int column;
	public int columnCount(int i, int j) {
		// TODO Auto-generated method stub

		Sheet1 = wb.getSheetAt(i);

		// Sheet1.getRow(j);

		Iterator<Row> rows = Sheet1.iterator();
		Row currentRow;
		try {
			currentRow = rows.next();

			Iterator<org.apache.poi.ss.usermodel.Cell> ce = currentRow.cellIterator();
			int k = 0;
			 column = 0;

			while (ce.hasNext()) {
				org.apache.poi.ss.usermodel.Cell value = ce.next();
				column++;

				return column;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return j;

		

	}

}