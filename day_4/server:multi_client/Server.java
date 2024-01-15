package src_chat_threads;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class Server {    
    private static int port = 8000;
    
    public static void main(String args[]) {
    	ServerSocket server =null;
	
	ObjectInputStream ois =null;
	ObjectOutputStream oos =null;

        try{
          server = new ServerSocket(port);       
          while(true){
          	Socket socket = null;
        	try{
		    socket = server.accept();
		    ois=new ObjectInputStream(socket.getInputStream());
		    oos=new ObjectOutputStream(socket.getOutputStream());
		    ThreadHandler  th = new ThreadHandler(socket,ois,oos);
		    th.start();
		    
		   
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
        
        finally{
        System.out.println("Shutting down Socket server!!");
        
        }
    }
    
}


