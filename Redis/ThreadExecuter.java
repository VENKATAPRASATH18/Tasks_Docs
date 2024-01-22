package src_redis; 
import java.util.*;
import redis.clients.jedis.Jedis;
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.xssf.usermodel.XSSFRow; 
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import java.text.*;
import java.io.*;
public class ThreadExecuter extends Thread {
	String key;
	Jedis con_obj;
	String process;
	public ThreadExecuter(String key,Jedis con_obj,String process){
		this.key=key;
		this.con_obj=con_obj;
		this.process=process;
	}
	
	public String getData(String field){
		
    		if(field.equalsIgnoreCase("Checkin")){
    		
    			Date d =new Date(Long.parseLong(con_obj.hget(key,"Checkin")));
        		DateFormat df = new SimpleDateFormat("H:m");
        		return df.format(d);
    		}
    		else{
    			if(!con_obj.hget(key,"Checkout").equals("-")){
	    			Date d =new Date(Long.parseLong(con_obj.hget(key,"Checkout")));
				DateFormat df = new SimpleDateFormat("H:m");
				return df.format(d);
        		}
        		else{
        			return con_obj.hget(key,"Checkout");
        		}
    		}
    		
    	}
    	public  void ReportThread(){
	String path="output/Reports/";
    	String ext=".xlsx";
		try(FileOutputStream out = new FileOutputStream(path+key+ext,false)){
			XSSFWorkbook workbook = new XSSFWorkbook(); 
			XSSFSheet spreadsheet  = workbook.createSheet("Report"); 
			XSSFRow hrow,vrow; 
		 
			String[] header={"Date","CheckIn","CheckOut","Duration","Status"};
			hrow = spreadsheet.createRow(0);
			vrow = spreadsheet.createRow(1);
			int header_cells=0;
			int value_cell=0;
			for(String i:header){
				 Cell hcell = hrow.createCell(header_cells++);
				 hcell.setCellValue(i); 
				 if(i.equalsIgnoreCase("Checkin") || i.equalsIgnoreCase("Checkout")){
				 	 Cell vcell = vrow.createCell(value_cell++);
					 vcell.setCellValue(getData(i)); 
				 }
				 else{
					 Cell vcell = vrow.createCell(value_cell++);
					 vcell.setCellValue(con_obj.hget(key,i)); 
				 }
				 
				}
			
			workbook.write(out); 
			}
		catch(Exception e){
			System.out.println(e);
			}
	}
	public void OutThread(){
		if(con_obj.keys("usr*").contains(key)){
		    con_obj.hset(key,"Checkout",String.valueOf(System.currentTimeMillis()));
		    long totalSeconds =(Long.parseLong(con_obj.hget(key,"Checkout"))/1000) - (Long.parseLong(con_obj.hget(key,"Checkin"))/1000);
		    long hours = (totalSeconds / 3600);
		    long minutes = ((totalSeconds % 3600) / 60);
					//int seconds = totalSeconds % 60;
		    String duration = hours+":"+minutes;
		    con_obj.hset(key,"Duration",duration);
		    con_obj.hset(key,"Status","0");
	            //con_obj.del(key);
    		
    		}
    		else{
		    String path="output/Exception/";
		    String ext=".txt";
		    try(FileOutputStream stream = new FileOutputStream(path+key+ext,false)){
		    		byte[] bytesToWrite = new String("User not checked-in").getBytes();
				stream.write(bytesToWrite);
		    	}
		    catch(Exception e){
		    		System.out.println(e);
		    	}
	
    		}
	}
    	
    	@Override
    	public void run(){
      	
      		if(process.equalsIgnoreCase("in")){
		      	con_obj.hset(key,"Date",java.time.LocalDate.now().toString());
		    	con_obj.hset(key,"Checkin",String.valueOf(System.currentTimeMillis()));
		    	con_obj.hset(key,"Checkout","-");
		    	con_obj.hset(key,"Status","1");
		    	con_obj.hset(key,"Duration","-");
      		}
      	
      		else if(process.equalsIgnoreCase("out")){
      	    		OutThread();
      		}
      		else if(process.equalsIgnoreCase("report")){
      			ReportThread();
      		}
      	

    	

    }
  
}
