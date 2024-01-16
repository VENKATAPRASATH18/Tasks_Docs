import java.io.*;
import java.util.*;
public class SearchOptimized{
public static void main(String[] ar){
try(	BufferedReader br_1 =new BufferedReader(new FileReader("input_1.ini"));
	BufferedReader br_2 =new BufferedReader(new FileReader("input2.txt"));
	FileOutputStream fr= new FileOutputStream("output.txt"))
	{

	StringBuffer s=new StringBuffer();
	String c;
	Map<String,List<String>> table = new HashMap<String,List<String>>();
	while((c=br_1.readLine())!=null) {
		
		String[] a=c.split("=");
		if(table.containsKey(a[0])){
			table.get(a[0]).add(c);
			}
		else{
		System.out.println(a[0]);
			table.put(a[0],new ArrayList<String>());
			table.get(a[0]).add(c);
			
		}
		
	}
	
	
	while((c=br_2.readLine())!=null) {

		if(table.containsKey(c)){
			for (String i : table.get(c)){
				System.out.println(i);
				fr.write(i.getBytes());
				fr.write('\n');
				}
			}
		
		
	}
	

        
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
       }
      }


