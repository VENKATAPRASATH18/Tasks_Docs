
import java.util.*;

import java.net.*;
import java.net.InetAddress;
import java.io.*;
public class Http {
	
	
	
	public static void main(String[] ar){
	
	
	try{
		InetAddress host_address =InetAddress.getLocalHost();
		
		BufferedWriter host_service_writer;
		BufferedReader host_service_reader;
		ServerSocket server =new ServerSocket("localhost",8000);
		System.out.println("Connected Server ipconf "+server.toString());
		while(true){
			System.out.println("listening");
			Thread.sleep(1000);
		}

		
	
		}
		
		catch(Exception e){
	System.out.println(e);
	}
		
		
		
		
	
	
	
	}
	
    
}
