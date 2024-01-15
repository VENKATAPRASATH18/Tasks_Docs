package src_chat_threads;
//import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

class ThreadHandler extends Thread{
    final Socket client;
    final ObjectInputStream ois;
    final ObjectOutputStream oos;
    public ThreadHandler(Socket client,ObjectInputStream ois,ObjectOutputStream oos)
    {
    	this.client=client;
    	this.ois=ois;
    	this.oos=oos;
    }
    public void ChatService()
    {
    	
    	while(true)
    	{
        	try{
			    Scanner sc=new Scanner(System.in);
			    String[] message = ois.readObject().toString().split(":");
			    System.out.println(message[0]+":"+message[1]);
			    
			    if(message[1].equalsIgnoreCase("exit")){
			    client.close();
			     break;
			     }
			    System.out.print("reply to "+message[0]+":");
			    String s=sc.nextLine();
			    oos.writeObject(s);
			    
           	 }
       	        catch(Exception e)
       	        {
	       		    System.out.println(e);
	       		    break;
		}           
        }
        try{
			    ois.close();
			    oos.close();
			    //client.close();
                 } 
        catch(Exception e){
        System.out.println(e);
        }
    }
    
    @Override
    public void run()
    {
	ChatService();
    }
}
 
    
    
