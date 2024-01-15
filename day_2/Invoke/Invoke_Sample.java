import java.lang.*;
import java.io.*;
public class Invoke_Sample{
public static void run(String file){
	
	Process run = null;
	BufferedReader inStream = null;
	BufferedReader output_stream = null;
	String cmd;
	try{
	cmd=String.format("java %s",file);
	run = Runtime.getRuntime().exec(cmd);
	run.waitFor();
	Syste.out.println(run.exitValue());
	}
	
	catch(Exception e){
	System.out.println(e);
	}
	
	

	
	}

public static void main(String[] ar){

	run("Sample");
	//runProcess("javac -d %CLASSPATH /home/venkat-20466/Documents/Task_Docs/day_2/Invoke/Sample.java");
	

}
}
