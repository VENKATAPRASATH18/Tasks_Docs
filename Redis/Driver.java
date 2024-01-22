package src_redis; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import redis.clients.jedis.Jedis;


public class Driver {

	
    public static void In(){
    	try(BufferedReader br=new BufferedReader(new FileReader("check_in_data.txt")))
    	{
       	    	
       		String key=br.readLine();
       		while(key!=null){
       			try(Jedis connection =new Jedis("127.0.0.1",6379)){
				ThreadExecuter th =new ThreadExecuter(key,connection,"in");
				th.start();
				
        		}
        		catch(Exception e){
        			System.out.println("Exception in Jedis-Threads-checkin");
        			System.out.println(e);
        		}
        		key=br.readLine();	
        	}
       			
    	}

        catch(Exception e){
        	System.out.println("Exception in Buff-Reader");
        	System.out.println(e);
        }
    }
    
    public static void Out(){
    	try(BufferedReader br=new BufferedReader(new FileReader("check_out_data.txt")))
    	{
       	    	
       		String key=br.readLine();
       		while(key!=null){
       			try(Jedis connection =new Jedis("127.0.0.1",6379)){
				ThreadExecuter th =new ThreadExecuter(key,connection,"out");
				th.start();
				
        		}
        		catch(Exception e){
        			System.out.println("Exception in Jedis-Threads-checkout");
        			System.out.println(e);
        		}
        		key=br.readLine();	
        	}
       			
    	}

        catch(Exception e){
        	System.out.println("Exception in Buff-Reader");
        	System.out.println(e);
        }
    }
    
    public static void Report(){
    	try(Jedis connection =new Jedis("127.0.0.1",6379)){
    		Set<String> usr =connection.keys("usr:*");
   		
    		if(usr.size()>0){	
    			for(String key:usr){
    				try(Jedis thread_connection =new Jedis("127.0.0.1",6379)){
					ThreadExecuter th =new ThreadExecuter(key,thread_connection,"report");
					th.start();
				
        			}
        			catch(Exception e){
        				System.out.println("Exception in Jedis-Threads-Reports");
        				System.out.println(e);
        			}
    			}	
    		}
    		else{
    			System.out.println("insufficient data - Report()");
    		}
    	}
	
        catch(Exception e){
        	System.out.println("Exception redis-server-connection");
        	System.out.println(e);
        }
    }
  
    public static void main(String[] args) {
    	
    	if(args[0].equalsIgnoreCase("in")){
    		System.out.println("CheckIn");
    		In();
    	}
    	else if(args[0].equalsIgnoreCase("out")){
    		System.out.println("CheckOut");
    		Out();
    	}
    	else if(args[0].equalsIgnoreCase("report")){
    		System.out.println("Report");
    		Report();
    	}
    	else{
    	System.out.println("Invalid");
    	}
        
        

        
    }
}
