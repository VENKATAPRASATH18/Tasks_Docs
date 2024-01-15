import java.lang.*;
import java.net.*;
 public class ClassPath{
public static void main(String[] ar){
URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
System.out.println(urlClassLoader);

}
}
