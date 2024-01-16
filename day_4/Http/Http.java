
import java.util.*;

import java.net.*;
import java.net.InetAddress;
import java.io.*;
public class Http {
	
	
	
	public static void main(String[] ar){
	
	
	try(ServerSocket server =new ServerSocket(8000,50)){

		System.out.println("Server "+server.toString());
		while(true){
			 try(Socket clientSocket = server.accept())
			 {
			 Date today = new Date();
			 String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" ;
			 clientSocket.getOutputStream().write((httpResponse+"Today's date " + today+"\n").getBytes());
			 BufferedReader reader =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			 String line= reader.readLine();
			 
			 while (!line.isEmpty()) 
			 {
                		System.out.println(line);
                		clientSocket.getOutputStream().write((line+"\n").getBytes());
                		line = reader.readLine();
			 }
				
			 } 
			 catch(Exception e)
			 {
			 
			 	 System.out.println(e);
			 }
                        
		}
		}
		
		catch(Exception e){
		System.out.println(e);
		}
		
		
		
		
	
	
	
	}
	
    
}
