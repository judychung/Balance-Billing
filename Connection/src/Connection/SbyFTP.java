package Connection;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class SbyFTP {
	private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
	
    public void main(String[] args) throws Exception {
        String server = "sbrysv1.pok.ibm.com";
        int port = 21;
        String user = Automation.getUsername();
        String pass = Automation.getPassword();
        FTPClient ftpClient = new FTPClient();
        
        try {
            ftpClient.connect(server, port);
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            } 
            else {
            	System.out.println("LOGGED IN SERVER");
            
	            String userHomeFolder = System.getProperty("user.home");
	            byte[] bytesArray = new byte[4096];
	            int bytesRead = -1;    
	            
	            // retrieving BICHIS2 from server
	            File file1 = new File(userHomeFolder, "BICHIS2"); // puts file in user's home folder
	            InputStream is1 = ftpClient.retrieveFileStream("C2");
	            BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(file1));
	            while ((bytesRead = is1.read(bytesArray)) != -1) {
	                bos1.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 1 has been downloaded successfully.");
	                is1.close();
	                bos1.close();
	                int count = 0;
	                count = SbyKeywordSearch.searchKeywords(file1, "TOTAL NUMBER OF CIS OUTPUT RECORDS CREATED", count);
	                count = SbyKeywordSearch.searchKeywords(file1, "C SOURCE", count);
	            }  
	            
	            // retrieving BICHIS3 from server
	            InputStream is2 = ftpClient.retrieveFileStream("C3");
	            File file2 = new File(userHomeFolder, "BICHIS3"); // puts file in user's home folder
	            BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(file2));
	            while ((bytesRead = is2.read(bytesArray)) != -1) {
	                bos2.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	            	System.out.println("File 2 has been downloaded successfully.");
					is2.close();
	          	  	bos2.close();
	                int count = 0;
	          	  	count = SbyKeywordSearch.searchKeywords(file2, "TOTAL RECORD COUNT", count);
	          	  	count = SbyKeywordSearch.searchKeywords(file2, "TOTAL BASIC AMOUNT - +", count);
	            }
	            
	            // retrieving BICHIS4 from server
	            InputStream is3 = ftpClient.retrieveFileStream("C4");
	            File file3 = new File(userHomeFolder, "BICHIS4"); // puts file in user's home folder
	            BufferedOutputStream bos3 = new BufferedOutputStream(new FileOutputStream(file3));
	            while ((bytesRead = is3.read(bytesArray)) != -1) {
	                bos3.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 3 has been downloaded successfully.");
			        is3.close();
			        bos3.close();
			        int count = 0;
	                count = SbyKeywordSearch.searchKeywords(file3, "TOTAL INPUT OF CIS RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file3, "TOTAL INPUT OF MAC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file3, "TOTAL INPUT OF SVC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file3, "TOTAL INPUT OF OTC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file3, "TOTAL INPUT OF LSE RECORDS", count);
	            }
	            
	            // retrieving BICHIS4X from server
	            InputStream is4 = ftpClient.retrieveFileStream("C4X");
	            File file4 = new File(userHomeFolder, "BICHIS4X"); // puts file in user's home folder
	            BufferedOutputStream bos4 = new BufferedOutputStream(new FileOutputStream(file4));
	            while ((bytesRead = is4.read(bytesArray)) != -1) {
	                bos4.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 4 has been downloaded successfully.");
	                is4.close();
	                bos4.close();
	                int count = 0;
	                count = SbyKeywordSearch.searchKeywords(file4, "TOTAL INPUT OF CIS RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file4, "TOTAL INPUT OF MAC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file4, "TOTAL INPUT OF SVC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file4, "TOTAL INPUT OF OTC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file4, "TOTAL INPUT OF LSE RECORDS", count);
	            }
	            
	            // retrieving BICHIS2F from server
	            InputStream is5 = ftpClient.retrieveFileStream("F2");
	            File file5 = new File(userHomeFolder, "BICHIS2F"); // puts file in user's home folder
	            BufferedOutputStream bos5 = new BufferedOutputStream(new FileOutputStream(file5));
	            while ((bytesRead = is5.read(bytesArray)) != -1) {
	                bos5.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 5 has been downloaded successfully.");
	                is5.close();
	                bos5.close();
			        int count = 0;
	                count = SbyKeywordSearch.searchKeywords(file5, "CIS OUTPUT RECORDS CREATED", count);
	                count = SbyKeywordSearch.searchKeywords(file5, "C SOURCE", count);
	            }
	            
	            // retrieving BICHIS3F from server
	            InputStream is6 = ftpClient.retrieveFileStream("F3");
	            File file6 = new File(userHomeFolder, "BICHIS3F"); // puts file in user's home folder
	            BufferedOutputStream bos6 = new BufferedOutputStream(new FileOutputStream(file6));
	            while ((bytesRead = is6.read(bytesArray)) != -1) {
	                bos6.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 6 has been downloaded successfully.");
	                is6.close();
			        bos6.close();
			        int count = 0;
			        count = SbyKeywordSearch.searchKeywords(file6, "TOTAL RECORD COUNT", count);
	          	  	count = SbyKeywordSearch.searchKeywords(file6, "TOTAL BASIC AMOUNT -", count);
	            }
	            
	            // retrieving BICHIS4F from server
	            InputStream is7 = ftpClient.retrieveFileStream("F4");
	            File file7 = new File(userHomeFolder, "BICHIS4F"); // puts file in user's home folder
	            BufferedOutputStream bos7 = new BufferedOutputStream(new FileOutputStream(file7));
	            while ((bytesRead = is7.read(bytesArray)) != -1) {
	                bos7.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 7 has been downloaded successfully.");
	                is7.close();
			        bos7.close();
			        int count = 0;
			        count = SbyKeywordSearch.searchKeywords(file7, "TOTAL INPUT OF CIS RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file7, "TOTAL INPUT OF MAC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file7, "TOTAL INPUT OF SVC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file7, "TOTAL INPUT OF OTC RECORDS", count);
	                count = SbyKeywordSearch.searchKeywords(file7, "TOTAL INPUT OF LSE RECORDS", count);
	            }
            }
            Automation.printDoneMessage();
            ftpClient.disconnect();
        } 
        catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            Automation.printError(sw.toString());
        }
    }
}