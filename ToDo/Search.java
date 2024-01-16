import java.io.*;
import org.ini4j.*;
public class Search{
public static void main(String[] ar){
try{

	BufferedReader br =new BufferedReader(new FileReader("input2.txt"));
	
	BufferedWriter bw =new BufferedWriter(new FileWriter("out.txt"));
	StringBuffer s=new StringBuffer();
	String c;
	while((c=br.readLine())!=null) {
		System.out.println(c);
		BufferedReader current_bf =new BufferedReader(new FileReader("input_1.ini"));
		String c1;
		while((c1=current_bf.readLine())!=null){
		
		if (c1.contains(c)){
		System.out.println(c1);
			bw.write(c1);
			bw.flush(); //data  will only get sent to an output device, when the buffer is full.
			bw.newLine();
		}
		
		}
		current_bf.close();
		
	}
	
   	
       // System.out.println("last char is: "+c);
        
        }
        catch(Exception e){
        System.out.println(e);
        }
        	}
        }


