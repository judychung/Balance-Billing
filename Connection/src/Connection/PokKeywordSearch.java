package Connection;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class PokKeywordSearch {
	public static int searchKeywords(File file, String string, int count) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(file, "UTF-8");
	
	    	while (scanner.hasNextLine()) {
	    	   String lineFromFile = scanner.nextLine();
	    	   if(lineFromFile.contains(string) && count != 2) { 	    	   
	    	       if (file.getName().equals("BICHS1A")) {
	    	    	   if (count == 0) {
			        	   String[] line = lineFromFile.split(":");
			               String B3 = line[1].trim();
			               System.out.println("B3="+B3);
			               FillExcel.excel("B3", B3);
			               count++;
			               break;
	    	    	   }
	    	    	   else if (count == 1) {
	    	    		   String[] line = lineFromFile.split("G2");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C3 = line1[0];
	    	    		   System.out.println("C3="+C3);
			               FillExcel.excel("C3", C3);
	    	    		   count++;
			               break;
	    	    	   }
	    	    	   else if (count == 3){
	    	    		   String[] line = lineFromFile.split(":");
			               String B5 = line[1].trim();
			               System.out.println("B5="+B5);
			               FillExcel.excel("B5", B5);
			               count++;		               
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C5 = line1[0];
	    	    		   System.out.println("C5="+C5);
			               FillExcel.excel("C5", C5);
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1B")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B6 = line[1].trim();
			               System.out.println("B6="+B6);
			               FillExcel.excel("B6", B6);
			               count++;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split("G1");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C6 = line1[0];
	    	    		   System.out.println("C6="+C6);
			               FillExcel.excel("C6", C6);
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1C")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B7 = line[1].trim();
			               System.out.println("B7="+B7);
			               FillExcel.excel("B7", B7);
			               count++;
			               break;
	    	    	   }
	    	    	   else if (count == 1) {
	    	    		   String[] line = lineFromFile.split("G1");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C7 = line1[0];
	    	    		   System.out.println("C7="+C7);
			               FillExcel.excel("C7", C7);
	    	    		   count += 2;
			               break;
	    	    	   }
	    	    	   else if (count == 3) { // count skips 2 for BICHS1A continuation
	    	    		   String[] line = lineFromFile.split(":");
			               String B8 = line[1].trim();
			               System.out.println("B8="+B8);
			               FillExcel.excel("B8", B8);
			               count++;
			               break;
	    	    	   }
	    	    	   else { // count = 4
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C8 = line1[0];
	    	    		   System.out.println("C8="+C8);
			               FillExcel.excel("C8", C8);
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1J")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split(string);
			               String B9 = line[1].trim();
			               System.out.println("B9="+B9);
			               FillExcel.excel("B9", B9);
			               count++;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C9 = line1[0];
	    	    		   System.out.println("C9="+C9);
			               FillExcel.excel("C9", C9);
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1D")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split("G2");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B12 = line1[0];
	    	    		   System.out.println("B12="+B12);
			               FillExcel.excel("B12", B12);
	    	    		   count++;
			               break;
	    	    	   }
	    	    	   else if (count == 1) {
	    	    		   String[] line = lineFromFile.split("G1");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B13 = line1[0];
	    	    		   System.out.println("B13="+B13);
			               FillExcel.excel("B13", B13);
	    	    		   count += 2;
			               break;
	    	    	   }
	    	    	   else if (count == 3) {
	    	    		   String[] line = lineFromFile.split("G1");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B14 = line1[0];
	    	    		   System.out.println("B14="+B14);
			               FillExcel.excel("B14", B14);
	    	    		   count++;
			               break;
	    	    	   }
	    	    	   else if (count == 4) {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B15 = line1[0];
	    	    		   System.out.println("B15="+B15);
			               FillExcel.excel("B15", B15);
	    	    		   count++;
			               break;
	    	    	   }
	    	    	   else if (count == 5) {
	    	    		   // TOTAL IN
	    	    		   String[] line = lineFromFile.split("IN =");
	    	    		   String[] line1 = line[1].split(",");
	    	    		   String B17 = line1[0].trim();
	    	    		   System.out.println("B17="+B17);
			               FillExcel.excel("B17", B17);
	    	    		   
	    	    		   // TOTAL OUT
	    	    		   String[] line2 = line1[1].split("=");
	    	    		   String B19 = line2[1].trim();
	    	    		   System.out.println("B19="+B19);
			               FillExcel.excel("B19", B19);
	    	    		   
	    	    		   count++;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split("OUT =");
	    	    		   String B18 = line[1].trim();
	    	    		   System.out.println("B18="+B18);
			               FillExcel.excel("B18", B18);
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1DX")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B24 = line1[0];
	    	    		   System.out.println("B24="+B24);
			               FillExcel.excel("B24", B24);
	    	    		   count++;
			               break;
	    	    	   }
	    	    	   else if (count == 1) {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B25 = line1[0];
	    	    		   System.out.println("B25="+B25);
			               FillExcel.excel("B25", B25);
	    	    		   count += 2; 
			               break;
	    	    	   }
	    	    	   else if (count == 3) {
	    	    		   // TOTAL IN
	    	    		   String[] line = lineFromFile.split("IN =");
	    	    		   String[] line1 = line[1].split(",");
	    	    		   String B27 = line1[0].trim();
	    	    		   System.out.println("B27="+B27);
			               FillExcel.excel("B27", B27);
	    	    		   
	    	    		   // TOTAL OUT
	    	    		   String[] line2 = line1[1].split("=");
	    	    		   String B29 = line2[1].trim();
	    	    		   System.out.println("B29="+B29);
			               FillExcel.excel("B29", B29);
	    	    		   
	    	    		   count++;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split("OUT =");
	    	    		   String B28 = line[1].trim();
	    	    		   System.out.println("B28="+B28);
			               FillExcel.excel("B28", B28);
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1AF")) {
		    	       if (count == 0) {
			        	   String[] line = lineFromFile.split(":");
			               String B77 = line[1].trim();
			               System.out.println("B77="+B77);
			               FillExcel.excel("B77", B77);
			               count++;
			               break;
			    	   }
		    	       else {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C77 = line1[0];
	    	    		   System.out.println("C77="+C77);
			               FillExcel.excel("C77", C77);
			               count++;
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1CF")) {
	    	    	   if (count == 0) {
			        	   String[] line = lineFromFile.split(":");
			               String B79 = line[1].trim();
			               System.out.println("B79="+B79);
			               FillExcel.excel("B79", B79);
			               count++;
			               break;
			    	   }
		    	       else {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C79 = line1[0];
	    	    		   System.out.println("C79="+C79);
			               FillExcel.excel("C79", C79);
			               break;
		    	       }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1JF")) {
	    	    	   if (count == 0) {
			        	   String[] line = lineFromFile.split("WRITTEN");
			               String B80 = line[1].trim();
			               System.out.println("B80="+B80);
			               FillExcel.excel("B80", B80);
			               count++;
			               break;
			    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String C80 = line1[0];
	    	    		   System.out.println("C80="+C80);
			               FillExcel.excel("C80", C80);
			               break;
		    	       }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHS1DF")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B83 = line1[0];
	    	    		   System.out.println("B83="+B83);
			               FillExcel.excel("B83", B83);
	    	    		   count++; 
			               break;
	    	    	   }
	    	    	   else if (count == 1) {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B84 = line1[0];
	    	    		   System.out.println("B84="+B84);
			               FillExcel.excel("B84", B84);
	    	    		   count += 2; 
			               break;
		    	       }
	    	    	   else if (count == 3) {
	    	    		   String[] line = lineFromFile.split("G0");
	    	    		   String[] line1 = line[1].split("V00");
	    	    		   String B85 = line1[0];
	    	    		   System.out.println("B85="+B85);
			               FillExcel.excel("B85", B85);
	    	    		   count ++; 
			               break;
		    	       }
	    	    	   else if (count == 4) {
	    	    		   // TOTAL IN
	    	    		   String[] line = lineFromFile.split("IN =");
	    	    		   String[] line1 = line[1].split(",");
	    	    		   String B87 = line1[0].trim();
	    	    		   System.out.println("B87="+B87);
			               FillExcel.excel("B87", B87);
	    	    		   
	    	    		   // TOTAL OUT
	    	    		   String[] line2 = line1[1].split("=");
	    	    		   String B89 = line2[1].trim();
	    	    		   System.out.println("B89="+B89);
			               FillExcel.excel("B89", B89);
	    	    		   
	    	    		   count++;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split("OUT =");
	    	    		   String B88 = line[1].trim();
	    	    		   System.out.println("B88="+B88);
			               FillExcel.excel("B88", B88);
			               break;
	    	    	   }
	    	       }
	    	   }
	    	   else if (count == 2) { // for BICHS1A and BICHS1AF continuation
	    		   if (lineFromFile.indexOf(string) == 1) {
	    			   lineFromFile = scanner.nextLine();
	    			   if (file.getName().equals("BICHS1A")) {
	    				   String B4 = lineFromFile.trim();
	    				   System.out.println("B4="+B4);
			               FillExcel.excel("B4", B4);
	    				   count++;
	    	               break;
	    			   }
	    			   else { // file = BICHS1AF
	    				   String B78 = lineFromFile.trim();
	    				   System.out.println("B78="+B78);
			               FillExcel.excel("B78", B78);
	    				   count++;
	    	               break;
	    			   }
	    		   }
	    	   }
	    	}
		}
		catch (Exception e) {
			StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            Automation.printError(sw.toString());
		}
		return count;
    }
}