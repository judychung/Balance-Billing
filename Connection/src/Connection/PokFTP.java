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

public class PokFTP {
	private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
	
    public void main(String[] args) throws Exception {
        String server = "pkmfgmc.pok.ibm.com";
        String user = Automation.getUsername();
	    String pass = Automation.getPassword();
        int port = 21;
       
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
                Automation.printUserPassMessage();
                return;
            } 
            else {
                System.out.println("LOGGED IN SERVER");
                Automation.printLoggedInMessage();
                
	            String userHomeFolder = System.getProperty("user.home");
	            byte[] bytesArray = new byte[4096];
	            int bytesRead = -1;
	            
	            // retrieving BICHS1A from server
	            InputStream is1 = ftpClient.retrieveFileStream("A");
	            File file1 = new File(userHomeFolder, "BICHS1A"); // puts file in user's home folder
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
	                count = PokKeywordSearch.searchKeywords(file1, "TOTAL CIS RECORDS WRITTEN", count);
	                count = PokKeywordSearch.searchKeywords(file1, "IGD107I CHISP.BICHS1A.CISFILE", count);
	                count = PokKeywordSearch.searchKeywords(file1, "The number of continuation records is:", count);
	                count = PokKeywordSearch.searchKeywords(file1, "TOTAL IGSSO RECORDS WRITTEN", count);
	                count = PokKeywordSearch.searchKeywords(file1, "IGD107I CHISP.BICHS1A.IGSFILE", count);
	            }     
	            
	            // retrieving BICHS1B from server
	            InputStream is2 = ftpClient.retrieveFileStream("B");
	            File file2 = new File(userHomeFolder, "BICHS1B"); // puts file in user's home folder
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
	          	  	count = PokKeywordSearch.searchKeywords(file2, "CREATED", count);
	          	  	count = PokKeywordSearch.searchKeywords(file2, "IGD107I", count);
	            }
	           
	            // retrieving BICHS1C from server
	            InputStream is3 = ftpClient.retrieveFileStream("C");
	            File file3 = new File(userHomeFolder, "BICHS1C"); // puts file in user's home folder
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
	                count = PokKeywordSearch.searchKeywords(file3, "TOTAL CIS RECORDS WRITTEN", count);
	                count = PokKeywordSearch.searchKeywords(file3, "IGD107I CHISP.BICHS1C.CISFILE", count);
	                count = PokKeywordSearch.searchKeywords(file3, "TOTAL IGSSO RECORDS WRITTEN", count);
	                count = PokKeywordSearch.searchKeywords(file3, "IGD107I CHISP.BICHS1C.IGSFILE", count);
	            }
	            
	            // retrieving BICHS1J from server
	            InputStream is4 = ftpClient.retrieveFileStream("J");
	            File file4 = new File(userHomeFolder, "BICHS1J"); // puts file in user's home folder
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
	          	  	count = PokKeywordSearch.searchKeywords(file4, "WRITTEN", count);
	          	  	count = PokKeywordSearch.searchKeywords(file4, "IGD107I CHISP.BICHS1J.CISFILE", count);
	            }
	            
	            // retrieving BICHS1D from server
	            InputStream is5 = ftpClient.retrieveFileStream("D");
	            File file5 = new File(userHomeFolder, "BICHS1D"); // puts file in user's home folder
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
	                count = PokKeywordSearch.searchKeywords(file5, "IGD104I CHISP.BICHS1A", count);
	                count = PokKeywordSearch.searchKeywords(file5, "IGD104I CHISP.BICHS1B", count);
	                count = PokKeywordSearch.searchKeywords(file5, "IGD104I CHISP.BICHS1C", count);
	                count = PokKeywordSearch.searchKeywords(file5, "IGD104I CHISP.BICHS1J", count);
	                count = PokKeywordSearch.searchKeywords(file5, "ICE228I 0 NONCIS", count);
	                count = PokKeywordSearch.searchKeywords(file5, "ICE228I 0 SENDCIS", count);
	            }
	            
	            // retrieving BICHS1DX from server
	            InputStream is6 = ftpClient.retrieveFileStream("DX");
	            File file6 = new File(userHomeFolder, "BICHS1DX"); // puts file in user's home folder
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
			        count = PokKeywordSearch.searchKeywords(file6, "IGD104I CHISP.BICHS1A.IGSFILE", count);
			        count = PokKeywordSearch.searchKeywords(file6, "IGD104I CHISP.BICHS1C.IGSFILE", count);
	                count = PokKeywordSearch.searchKeywords(file6, "ICE228I 0 NONCIS", count);
	                count = PokKeywordSearch.searchKeywords(file6, "ICE228I 0 SENDCIS", count);
	            }
	           
	            // retrieving BICHS1AF from server
	            InputStream is7 = ftpClient.retrieveFileStream("AF");
	            File file7 = new File(userHomeFolder, "BICHS1AF"); // puts file in user's home folder
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
	                count = PokKeywordSearch.searchKeywords(file7, "TOTAL CIS RECORDS WRITTEN", count);
	                count = PokKeywordSearch.searchKeywords(file7, "IGD107I", count);
	                count = PokKeywordSearch.searchKeywords(file7, "The number of continuation records is:", count);
	            }
	            
		        // retrieving BICHS1CF from server
	            InputStream is8 = ftpClient.retrieveFileStream("CF");
	            File file8 = new File(userHomeFolder, "BICHS1CF"); // puts file in user's home folder
	            BufferedOutputStream bos8 = new BufferedOutputStream(new FileOutputStream(file8));
	            while ((bytesRead = is8.read(bytesArray)) != -1) {
	                bos8.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 8 has been downloaded successfully.");
	                is8.close();
			        bos8.close();
			        int count = 0;
			        count = PokKeywordSearch.searchKeywords(file8, "TOTAL CIS RECORDS WRITTEN", count);
	                count = PokKeywordSearch.searchKeywords(file8, "IGD107I", count);
	            }
	            
		        // retrieving BICHS1JF from server
	            InputStream is9 = ftpClient.retrieveFileStream("JF");
	            File file9 = new File(userHomeFolder, "BICHS1JF"); // puts file in user's home folder
	            BufferedOutputStream bos9 = new BufferedOutputStream(new FileOutputStream(file9));
	            while ((bytesRead = is9.read(bytesArray)) != -1) {
	                bos9.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 9 has been downloaded successfully.");
	                is9.close();
			        bos9.close();
			        int count = 0;
			        count = PokKeywordSearch.searchKeywords(file9, "TOTAL CIS RECORDS WRITTEN", count);
	                count = PokKeywordSearch.searchKeywords(file9, "IGD107I CHISP.BICHS1JF.CISFILE", count);
	            }
	            
		        // retrieving BICHS1DF from server
	            InputStream is10 = ftpClient.retrieveFileStream("DF");
	            File file10 = new File(userHomeFolder, "BICHS1DF"); // puts file in user's home folder
	            BufferedOutputStream bos10 = new BufferedOutputStream(new FileOutputStream(file10));
	            while ((bytesRead = is10.read(bytesArray)) != -1) {
	                bos10.write(bytesArray, 0, bytesRead);
	            }
	            success = ftpClient.completePendingCommand();
	            if (success) {
	                System.out.println("File 10 has been downloaded successfully.");
	                is10.close();
			        bos10.close();
			        int count = 0;
			        count = PokKeywordSearch.searchKeywords(file10, "IGD104I CHISP.BICHS1AF", count);
			        count = PokKeywordSearch.searchKeywords(file10, "IGD104I CHISP.BICHS1CF", count);
			        count = PokKeywordSearch.searchKeywords(file10, "IGD104I CHISP.BICHS1JF", count);
	                count = PokKeywordSearch.searchKeywords(file10, "ICE228I 0 NONCIS", count);
	                count = PokKeywordSearch.searchKeywords(file10, "ICE228I 0 SENDCIS", count);
	            }
            }
//            Automation.printDoneMessage();
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