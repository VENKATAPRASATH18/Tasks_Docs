import java.util.*;
import java.io.*;
public class Properties_Sample{


public static void main(String[] ar){
try{
	FileReader fr=new FileReader("data.properties");
  	Properties p=new Properties();
  	p.load(fr);	
   //System.out.println(p.getProperty("key1"));
   	
Enumeration valueEnumeration = p.propertyNames();
while (valueEnumeration.hasMoreElements()) {
    if (valueEnumeration.nextElement().equals("k1")){
    p.remove("k1");
}
//System.out.println(valueEnumeration.nextElement());
}
 valueEnumeration = p.propertyNames();
while (valueEnumeration.hasMoreElements()) {

System.out.println(valueEnumeration.nextElement());
}
}

  	catch(Exception e){
  	System.out.println(e);
  	}
  
 

}
}
