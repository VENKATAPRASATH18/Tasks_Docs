import java.io.*;

public class Stream{ 
public static void main(String[] ar){
 try {
 
        
            FileReader fr = new FileReader("Streams.txt");
            FileWriter fw = new FileWriter("Streams-out.txt");
            StringBuilder str = new StringBuilder();
 
            int i;
	    fr.skip(10);
            while ((i = fr.read()) != -1)         str.append((char)i);
            

            fw.write(str.toString());
 

            fr.close();
            fw.close();
 }

        catch (Exception e) {

            System.out.println(e);
    } 
}
}
