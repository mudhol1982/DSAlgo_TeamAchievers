package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    // Method to read Excel file and return the code from the provided sheet and row
    public static String getCodeFromExcel(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
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
}
