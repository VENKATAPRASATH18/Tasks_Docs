import java.lang.Runtime;
import java.lang.Process;
import java.io.*;
public class Invoke_Reverse_stream{
public static void run(String file){
	
	Process run = null;
	
	String cmd;
	try{
	
	cmd=String.format("java %s addidas",file);
	run = Runtime.getRuntime().exec(cmd);
	//BufferedReader is = new BufferedReader(new InputStreamReader(run.getInputStream()));
        InputStreamReader is=new InputStreamReader(run.getInputStream());
    	StringBuffer output=new StringBuffer();
    	int c=0;
    	c = is.read();
    while (c != -1)
 	{
        output.append((char)c);
	c = is.read();
	}
	
	FileWriter fw=new FileWriter("out_reverse.txt",false);
	fw.write(output.toString());
	fw.close();
	
	
	}
	
	
	
    
	catch(Exception e){
	System.out.println(e);
	}
}
 
   
	 

public static void main(String[] ar){

	run("Reverse");
	//runProcess("javac -d %CLASSPATH /home/venkat-20466/Documents/Task_Docs/day_2/Invoke/Sample.java");
	

}
}
