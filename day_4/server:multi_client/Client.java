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
        
        //Socket socket= null;
        //ObjectOutputStream oos = null;
	//ObjectInputStream ois = null;
        try(
        Socket socket =  new Socket(InetAddress.getLocalHost().getHostName(), 8000);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
         Scanner sc=new Scanner(System.in))
         {
        
       
	System.out.println("Enter Name");
    	String ClientName=sc.nextLine();
        while(true){
            
            try{    
            	    System.out.print("you:");
		    String s=sc.nextLine();
		    oos.writeObject(ClientName+":"+s);
		    
		    String message = ois.readObject().toString();
		    System.out.println("server:"+message);

            }
            catch(Exception e){
		    System.out.println(e);
		    break;
            }
              
           }
         }
	catch(Exception e){
		    System.out.println(e);
            }

        
	
 
    }
}
