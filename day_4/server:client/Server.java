package src_chat_threads;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class Server {
    
    //private static ServerSocket server;
    
    private static int port = 8000;
    
    public static void main(String args[]) {
    	ServerSocket server =null;
	Socket socket = null;
	ObjectInputStream ois =null;
	ObjectOutputStream oos =null;
	//Scanner sc=null;
        try{
        	server = new ServerSocket(port);       
          while(true){
        	try{
        
		    
		    socket = server.accept();
		    Scanner sc=new Scanner(System.in);
		    ois = new ObjectInputStream(socket.getInputStream());
		    String message = ois.readObject().toString();
		    System.out.println("client: "+message);
		    //System.out.println();
		    
		    if(message.equalsIgnoreCase("exit")) break;
		    System.out.print("you:");
		    oos = new ObjectOutputStream(socket.getOutputStream());
		    
		    String s=sc.nextLine();
		    oos.writeObject(s);
           	 }
       	        catch(Exception e){
       		    System.out.println(e);
                 }
                finally{
		    ois.close();
		    oos.close();
		   // sc.close();
		    socket.close();
                 }            
                }
           server.close();
           }
           
	catch(Exception e){
       		    System.out.println(e);
        }
        
        finally{
        System.out.println("Shutting down Socket server!!");
        
        }
    }
    
}
