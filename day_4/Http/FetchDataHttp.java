
import java.util.*;

import java.net.*;
import java.net.InetAddress;
import java.io.*;
public class FetchDataHttp {
	
	
	
	public static void main(String[] ar) throws Exception{
	 String host = "www.hackerrank.com";
         int port = 80;
	  try(Socket socket = new Socket(host, port);
	      PrintWriter out = new PrintWriter(socket.getOutputStream());
              BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

   
            

   
            out.println("GET / HTTP/1.1");
            out.println("Host: " + host);
            out.println("Connection: close");
            out.println(); 
            out.flush();

          
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }


           // out.close();
            //in.close();
            //socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
	
	
	
	}
	
    
}
