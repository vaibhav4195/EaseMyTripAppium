package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	static String excel;
	static String dataproviderexcel;
	public static List<String> list = null;

	// Description:getexceldatainMap is used for storing excel data to map;
	public static List<Map<String, String>> getexceldatainMap(int SheetNo) throws IOException {
		excel=BasicMethods.configReader("excel");
		dataproviderexcel=BasicMethods.configReader("dataProviderExcel");
		List<Map<String, String>> testDataAll = null;
		Map<String, String> testData = null;
		DataFormatter objData = new DataFormatter();

		FileInputStream File = new FileInputStream(dataproviderexcel);

		try (Workbook wb = new XSSFWorkbook(File)) {
			FormulaEvaluator objformula = new XSSFFormulaEvaluator((XSSFWorkbook) wb);
			Sheet sheet = wb.getSheetAt(SheetNo);
			int lastRow = sheet.getLastRowNum();

			int lastcol = sheet.getRow(0).getLastCellNum();
			// System.out.println(lastRow);
			// System.out.println(lastcol);
			list = new ArrayList<String>();
			for (int i = 0; i < lastcol; i++) {
				Row r = sheet.getRow(0);
				Cell cell = r.getCell(i);
				String rowHeader=null;
				if(cell==null) {

					list.add(rowHeader);
				}else {
					rowHeader = cell.getStringCellValue().trim();
					list.add(rowHeader);
				}


				// System.out.println(list);

			}
			testDataAll = new ArrayList<Map<String, String>>();
			// System.out.println(testDataAll);
			for (int j = 1; j <= lastRow; j++) {
				Row row = sheet.getRow(j);
				testData = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

				for (int k = 0; k < lastcol; k++) {
					Cell cell = row.getCell(k);
					// String colval=cell.getStringCellValue();
					objformula.evaluate(cell);// this will evaluate the cell and return string value
					String colval = objData.formatCellValue(cell, objformula);

					testData.put(list.get(k), colval);

					// System.out.println(list.get(k));
				}

				testDataAll.add(testData);


			}

			wb.close();
		}

		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return testDataAll;

	}

	// Description: It is use for writing pass and fail in excel sheet by taking two
	// values row and boolean;

//	public static void writexcel(boolean write, int r) throws IOException,NullPointerException { 
//		FileInputStream File = new FileInputStream(excel); try
//	(Workbook wb = new XSSFWorkbook(File)) { // CellStyle style =
//		wb.createCellStyle(); Sheet sheet = wb.getSheetAt(0);
//
//		// int lastRow=sheet.getLastRowNum(); int lastcol =
//		sheet.getRow(0).getLastCellNum(); FileOutputStream file1 = new
//				FileOutputStream(excel); //
//		sheet.getRow(0).createCell(lastcol).setCellValue("RESULT"); if (write ==
//				true) {
//
//			sheet.getRow(r).createCell(lastcol).setCellValue("PASS"); wb.write(file1); }
//		else { // FileOutputStream file1=new FileOutputStream(excel);
//			sheet.getRow(r).createCell(lastcol).setCellValue("FAIL"); wb.write(file1);
//
//		} wb.close();
//
//	}
//
//	}



}
