//package Utilities;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelReader {
//
//    // Method to read Excel file and return the code from the provided sheet and row
//    public static String getCodeFromExcel(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
//        // Open the Excel file
//        FileInputStream fis = new FileInputStream(new File(filePath));
//        
//        // Create workbook instance (for .xlsx files)
//        Workbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the sheet by name
//        Sheet sheet = workbook.getSheet(sheetName);
//        
//        // Get the row from the sheet
//        Row row = sheet.getRow(rowNum);
//        
//        // Get the cell from the row
//        Cell cell = row.getCell(cellNum);
//        
//        // Read the cell content as a String
//        String code = cell.getStringCellValue();
//        
//        // Close the workbook and input stream
//        workbook.close();
//        fis.close();
//
//        return code;
//    }
//    
//    
//    
//}




package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

	public static int totalRow;

	// Method to read Excel file and return the code from the provided sheet and row
	public static String getCodeFromExcel(String filePath, String sheetName, int rowNum, int cellNum)
			throws IOException {
		// Open the Excel file
		FileInputStream fis = new FileInputStream(new File(filePath));

		// Create workbook instance (for .xlsx files)
		Workbook workbook = new XSSFWorkbook(fis);

		// Get the sheet by name
		Sheet sheet = workbook.getSheet(sheetName);

		// Get the row from the sheet
		Row row = sheet.getRow(rowNum);

		// Get the cell from the row
		Cell cell = row.getCell(cellNum);

		// Read the cell content as a String
		String code = cell.getStringCellValue();

		// Close the workbook and input stream
		workbook.close();
		fis.close();

		return code;
	}

	// Method to read Excel file and return the code from the provided sheet and row
	public List<Map<String, String>> readFromExcel(String filePath, String sheetName)
			throws IOException {
		// Open the Excel file
		FileInputStream fis = new FileInputStream(new File(filePath));

		// Create workbook instance (for .xlsx files)
		Workbook workbook = new XSSFWorkbook(fis);
		// Get the sheet by name
		Sheet sheet = workbook.getSheet(sheetName);
		// Get the row from the sheet
		Row row;
		Cell cell;
		totalRow = sheet.getLastRowNum();
		System.out.println("totalRow--->" + totalRow);

		List<Map<String, String>> excelRows = new ArrayList<>();

		for (int currentRow = 1; currentRow <= totalRow; currentRow++) { // reading rows
			row = sheet.getRow(currentRow);
			int totalColumn = row.getLastCellNum();
			//System.out.println("totalColumn--->" + totalColumn);
			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();

			String data = null;

			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) { // reading columns of that row
																						// of first for loop
				cell = row.getCell(currentColumn);

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue(); // reading headers
				// String columnHeaderName =
				// sheet.getRow(0).getCell(currentColumn).getStringCellValue();

				if (cell != null) {
					if (cell.getCellType() == CellType.STRING) {
						data = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.NUMERIC) {
						data = String.valueOf(cell.getNumericCellValue());
					} else if (cell.getCellType() == CellType.BLANK) {
						data = String.valueOf(cell.getStringCellValue());
					}
				} else {
					data = "";

				}
				columnMapdata.put(columnHeaderName, data);
			}

			excelRows.add(columnMapdata);
		}

		return excelRows;

	}
}
