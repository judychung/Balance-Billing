package Connection;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class SbyKeywordSearch {
	public static int searchKeywords(File file, String string, int count) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(file, "UTF-8");

	    	while (scanner.hasNextLine()) {
	    	   String lineFromFile = scanner.nextLine();
	    	   if(lineFromFile.contains(string) && count != 1) { 	    	   
	    	       if (file.getName().equals("BICHIS2")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B33 = line[1].trim();
			               System.out.println("B33="+B33);
			               FillExcel.excel("B33", B33);
			               count++;
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHIS3")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split("-");
			               String B37 = line[1].trim();
			               System.out.println("B37="+B37);
			               FillExcel.excel("B37", B37);
			               count += 2;
			               break;
	    	    	   }
	    	    	   else {			          
			               String[] line = lineFromFile.split(" +");
	    	    		   if (line[7].trim() == "-") { // credit
			            	   String B38 = "-" + line[8].trim();
				               System.out.println("B38="+B38);
				               FillExcel.excel("B38", B38);
				               break;
			               }
	    	    		   else { // debit
	    	    			   String B38 = line[8].trim();
				               System.out.println("B38="+B38);
				               FillExcel.excel("B38", B38);
	    	    		   }	   
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHIS4")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B41 = line[1].trim();
			               System.out.println("B41="+B41);
			               FillExcel.excel("B41", B41);
			               count += 2;
			               break;
	    	    	   }
	    	    	   else if (count == 2) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B42 = line[1].trim();
			               System.out.println("B42="+B42);
			               FillExcel.excel("B42", B42);
			               count++;
			               break;
	    	    	   }
	    	    	   else if (count == 3) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B43 = line[1].trim();
			               System.out.println("B43="+B43);
			               FillExcel.excel("B43", B43);
			               count++;
			               break;
	    	    	   }
	    	    	   else if (count == 4) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B44 = line[1].trim();
			               System.out.println("B44="+B44);
			               FillExcel.excel("B44", B44);
			               count++;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split(":");
			               String B45 = line[1].trim();
			               System.out.println("B45="+B45);
			               FillExcel.excel("B45", B45);
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHIS4X")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B49 = line[1].trim();
			               System.out.println("B49="+B49);
			               FillExcel.excel("B49", B49);
			               count += 2;
			               break;
	    	    	   }
	    	    	   else if (count == 2) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B50 = line[1].trim();
			               System.out.println("B50="+B50);
			               FillExcel.excel("B50", B50);
			               count++;
			               break;
	    	    	   }
	    	    	   else if (count == 3) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B51 = line[1].trim();
			               System.out.println("B51="+B51);
			               FillExcel.excel("B51", B51);
			               count++;
			               break;
	    	    	   }
	    	    	   else if (count == 4) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B52 = line[1].trim();
			               System.out.println("B52="+B52);
			               FillExcel.excel("B52", B52);
			               count++;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split(":");
			               String B53 = line[1].trim();
			               System.out.println("B53="+B53);
			               FillExcel.excel("B53", B53);
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHIS2F")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B93 = line[1].trim();
			               System.out.println("B93="+B93);
			               FillExcel.excel("B93", B93);
			               count ++;
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHIS3F")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split("-");
			               String B97 = line[1].trim();
			               System.out.println("B97="+B97);
			               FillExcel.excel("B97", B97);
			               count += 2;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split(" +");
	    	    		   if (line[7].trim().equals("-")) { // credit
			            	   String B98 = "-" + line[8].trim();
				               System.out.println("B98="+B98);
				               FillExcel.excel("B98", B98);
			               }
	    	    		   else { // debit
	    	    			   String B98 = line[8].trim();
				               System.out.println("B98="+B98);
				               FillExcel.excel("B98", B98);
	    	    		   }	   
			               break;
	    	    	   }
	    	       }
	    	       
	    	       else if (file.getName().equals("BICHIS4F")) {
	    	    	   if (count == 0) {
	    	    		   String[] line = lineFromFile.split(":");
			               String B101 = line[1].trim();
			               System.out.println("B101="+B101);
			               FillExcel.excel("B101", B101);
			               count += 2;
			               break;
	    	    	   }
	    	    	   else if (count == 2) {
	    	    		   String[] line = lineFromFile.split(":");
	    	    		   String B102 = line[1].trim();
			               System.out.println("B102="+B102);
			               FillExcel.excel("B102", B102);
			               count++;
			               break;
	    	    	   }
	    	    	   else if (count == 3) {
	    	    		   String[] line = lineFromFile.split(":");
	    	    		   String B103 = line[1].trim();
			               System.out.println("B103="+B103);
			               FillExcel.excel("B103", B103);
			               count++;
			               break;
	    	    	   }
	    	    	   else if (count == 4) {
	    	    		   String[] line = lineFromFile.split(":");
	    	    		   String B104 = line[1].trim();
			               System.out.println("B104="+B104);
			               FillExcel.excel("B104", B104);
			               count++;
			               break;
	    	    	   }
	    	    	   else {
	    	    		   String[] line = lineFromFile.split(":");
	    	    		   String B105 = line[1].trim();
			               System.out.println("B105="+B105);
			               FillExcel.excel("B105", B105);
			               break;
	    	    	   }
	    	       }
	    	   }
	    	   else if (count == 1) {
	    		   int nextLine = 0;
		    	   if (lineFromFile.indexOf(string) != -1) {
					   while (nextLine < 15) {
						   lineFromFile = scanner.nextLine();
						   if (nextLine == 14) {
							   if (file.getName().equals("BICHIS2")) {
								   String[] line = lineFromFile.split(" +");
								   if (line[3].endsWith("-")) { // credit
									   String B34 = "-" + line[3].replaceAll("[$+-]","").trim();
						               System.out.println("B34="+B34);
						               FillExcel.excel("B34", B34);
								   }
								   else { // debit
									   String B34 = line[3].replaceAll("[$+-]","").trim();
						               System.out.println("B34="+B34);
						               FillExcel.excel("B34", B34);
								   }
					               count++;
					               break;
							   }
							   else { // BICHIS2F
								   String[] line = lineFromFile.split(" +");
								   if (line[3].endsWith("-")) { // credit
									   String B94 = "-" + line[3].replaceAll("[$+-]","").trim();
									   System.out.println("B94="+B94);
						               FillExcel.excel("B94", B94);
								   }
								   else { // debit
									   String B94 = line[3].replaceAll("[$+-]","").trim();
						               System.out.println("B94="+B94);
						               FillExcel.excel("B94", B94);
								   }
					               count++;
					               break;
							   }
						   }
					       nextLine++;
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