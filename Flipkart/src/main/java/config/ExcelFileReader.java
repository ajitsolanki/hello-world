package config;

import java.util.ArrayList;
import java.util.List;

public class ExcelFileReader {

	ArrayList<String> data = new ArrayList<String>();

	public List<String> excelReader() {
		ExcelConfig exc = new ExcelConfig("G:\\JAVA\\Selenium\\ExcelData\\TestData1.xlsx");

		int sheetnumber = exc.sheetCount();
		for (int i = 0; i < 1; i++) {
			int rownum = exc.rowCount(i);
			rownum++;

			for (int j = 1; j < rownum; j++) {

				int columnno = exc.columnCount(i, j);

				for (int k = 0; k <= columnno+1; k++) {
					try {
						String excData = exc.getData(i, j, k);
						data.add(excData);
					} catch (NullPointerException e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}
			}
		}
		return data;
	}
}
