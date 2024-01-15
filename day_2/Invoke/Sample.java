import java.io.*;
public class Sample{

	
public static void main(String[] ar){
try{
FileWriter fw=new FileWriter("out.txt",false);
fw.write("This is Sample.java class executed from Invoke.java");
fw.close();
}
catch(Exception e){
System.out.println(e);
}

//System.out.println("This is Sample.java class executed from Invoke.java");

}
}
