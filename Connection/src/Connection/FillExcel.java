package Connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class FillExcel {          
    public static void excel(String cell, String string) throws Exception {
        String userHomeFolder = System.getProperty("user.home");
        File file = new File(userHomeFolder + "/Balance Billing Test Review.xls");
        
        if (!file.exists()) {
			Automation.printFileNotFound();
        }
        else {
	        try {
//	        	FileInputStream input_document = new FileInputStream(new File(userHomeFolder + "/Balance Billing Test Review.xls"));
	        	FileInputStream input_document = new FileInputStream(file);
	        
			    @SuppressWarnings("resource")
				HSSFWorkbook workbook = new HSSFWorkbook(input_document); 
				Sheet sheet = workbook.getSheetAt(0);
			
				Double num = Double.parseDouble(string.replaceAll(",", ""));
				
				CellReference ref = new CellReference(cell);
				Row r = sheet.getRow(ref.getRow());
				if (r != null) {
					Cell c = null;
					c = r.getCell(ref.getCol());
					c.setCellValue(num);
				}
		        FileOutputStream output_file = new FileOutputStream(new File(userHomeFolder + "/Balance Billing Test Review.xls"));
		        workbook.write(output_file);
		        output_file.close();
	        
	        } catch (Exception e) {
				StringWriter sw = new StringWriter();
	            PrintWriter pw = new PrintWriter(sw);
	            e.printStackTrace(pw);
	            Automation.printError(sw.toString());
	        }
        }
    }
}