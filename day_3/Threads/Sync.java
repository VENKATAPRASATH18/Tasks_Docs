import java.io.FileReader;
import java.io.FileWriter;
class Copy 
{ 
    public  synchronized void proceed(String FileName) 
    { 
          try {
 
        
            FileReader fr = new FileReader("doc.txt");
            FileWriter fw = new FileWriter(FileName);
            StringBuffer str = new StringBuffer();
 
            int i;

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
  
class MyThread extends Thread{ 
    Copy obj; 
    String name; 
    public MyThread(Copy obj,String name) 
    { 
    	super(name); // set-thread-name
        this.obj=obj; 
        this.name=name; 
    } 
    public void run() 
    { 
        obj.proceed(name); 
    } 
} 
  
public class Sync{ 
    public static void main(String arg[]) 
    { 
        Copy d1=new Copy(); 
        Copy d2=new Copy(); 
        MyThread t1=new MyThread(d1,"t1_copy.txt"); 
        MyThread t2=new MyThread(d2,"t2_copy.txt"); 
        t1.start(); 
        t2.start(); 
    } 
} 
