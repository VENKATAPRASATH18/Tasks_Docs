package src_chat_threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Client {

    public static void main(String[] args){
        
        
        try{
    
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        
        while(true){
            
            try{    Scanner sc=new Scanner(System.in);
            	    socket = new Socket(InetAddress.getLocalHost().getHostName(), 8000);
            	    System.out.print("you:");
		    oos = new ObjectOutputStream(socket.getOutputStream());
		    
		    
		    String s=sc.nextLine();
		    oos.writeObject(s);
		    ois = new ObjectInputStream(socket.getInputStream());
		    String message = ois.readObject().toString();
		    System.out.println("server: "+message);

            }
            catch(Exception e){
		    System.out.println(e);
            }
            finally{
		    oos.close();
		    ois.close();
		    socket.close();
		   // sc.close();
            }   
           }
         }
	catch(Exception e){
		    System.out.println(e);
            }
        
	
 
    }
}
